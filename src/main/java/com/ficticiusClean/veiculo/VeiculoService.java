package com.ficticiusClean.veiculo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<Veiculo> getVeiculos() {
		List<Veiculo> findAll = veiculoRepository.findAll();
		return findAll;
	}

	public Veiculo getVeiculoById(Long veiculoId) {
		Veiculo veiculo = veiculoRepository.findById(veiculoId).get();

		return veiculo;
	}

	public Veiculo createveiculo(Veiculo veiculo) {
		veiculo = veiculoRepository.save(veiculo);

		return veiculo;
	}

	public Veiculo updateVeiculo(Long veiculoId, Veiculo veiculo) throws Exception {
		Veiculo updatedVeiculo = veiculoRepository.findById(veiculoId).map(foundVeiculo -> {
			foundVeiculo.setNome(veiculo.getNome());
			foundVeiculo.setMarca(veiculo.getMarca());
			foundVeiculo.setModelo(veiculo.getModelo());
			foundVeiculo.setDataFabricacao(veiculo.getDataFabricacao());
			foundVeiculo.setConsumoCidade(veiculo.getConsumoCidade());
			foundVeiculo.setConsumoRodovia(veiculo.getConsumoRodovia());
			foundVeiculo = veiculoRepository.save(foundVeiculo);
			return foundVeiculo;
		}).orElseThrow(() -> new Exception("NOT FOUND"));
		// TODO: Tratar erro melhor

		return updatedVeiculo;
	}

	public Boolean deleteVeiculo(Veiculo veiculo) {
		veiculoRepository.delete(veiculo);

		return true;
	}

	public Boolean deleteVeiculoById(Long veiculoId) {
		veiculoRepository.deleteById(veiculoId);

		return true;
	}

	public List<GastosResponseDTO> calculaGastosCarros(GastosRequestDTO gastosRequestDTO) {

		List<GastosResponseDTO> gastos = new ArrayList<GastosResponseDTO>();
		Double precoGasolina = gastosRequestDTO.getPrecoGasolina();
		Float kmCidade = gastosRequestDTO.getKmCidade();
		Float kmRodovia = gastosRequestDTO.getKmRodovia();

		List<Veiculo> veiculos = veiculoRepository.findAll();

		veiculos.forEach(veiculo -> {
			GastosResponseDTO gastosResponseDTO = new GastosResponseDTO();

			Float consumo = calculaCombustivelGasto(veiculo, kmCidade, kmRodovia);
			Double valorGasto = consumo * precoGasolina;
			valorGasto = Math.round(valorGasto * 100.0) / 100.0;

			gastosResponseDTO.setNome(veiculo.getNome());
			gastosResponseDTO.setMarca(veiculo.getMarca());
			gastosResponseDTO.setModelo(veiculo.getModelo());
			gastosResponseDTO.setAno(veiculo.getDataFabricacao().get(Calendar.YEAR));
			gastosResponseDTO.setQuantidadeCombustivel(consumo);
			gastosResponseDTO.setValorGasto(valorGasto);
			
			gastos.add(gastosResponseDTO);

		});

		Collections.sort(gastos, (veiculo1, veiculo2) -> veiculo1.getValorGasto().compareTo(veiculo2.getValorGasto()));

		return gastos;

	}

	public Float calculaCombustivelGasto(Veiculo veiculo, Float kmCidade, Float kmRodovia) {
		Float consumo = (kmCidade / veiculo.getConsumoCidade()) + (kmRodovia / veiculo.getConsumoRodovia());

		return consumo;
	}

}
