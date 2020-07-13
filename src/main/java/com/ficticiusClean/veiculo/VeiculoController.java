package com.ficticiusClean.veiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/FicticiusClean/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping("/getVeiculos")
	public ResponseEntity<List<Veiculo>> getVeiculos() {

		ResponseEntity<List<Veiculo>> response = null;
		try {
			List<Veiculo> veiculos = veiculoService.getVeiculos();
			response = ResponseEntity.ok(veiculos);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			response = ResponseEntity.status(500).build();
		}

		return response;

	}

	@GetMapping("/getVeiculo/{veiculoId}")
	public ResponseEntity<Veiculo> getVeiculo(@PathVariable Long veiculoId) {

		ResponseEntity<Veiculo> response = null;
		try {
			Veiculo veiculo = veiculoService.getVeiculoById(veiculoId);

			response = ResponseEntity.ok(veiculo);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			ResponseEntity.status(500).build();
		}

		return response;
	}

	@PostMapping("/createVeiculo")
	public ResponseEntity<Veiculo> createVeiculo(@RequestBody VeiculoDTO veiculoDTO) {

		ResponseEntity<Veiculo> response = null;
		Veiculo veiculo;
		try {
			veiculo = veiculoService.createveiculo(veiculoDTO.toVeiculo());

			response = ResponseEntity.ok(veiculo);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			ResponseEntity.status(500).build();
		}

		return response;
	}

	@PutMapping("/updadeVeiculo/{veiculoId}")
	public ResponseEntity<Veiculo> updadeVeiculo(@PathVariable Long veiculoId, @RequestBody VeiculoDTO veiculoDTO) {

		ResponseEntity<Veiculo> response = null;
		Veiculo veiculo;
		try {
			veiculo = veiculoService.updateVeiculo(veiculoId, veiculoDTO.toVeiculo());

			response = ResponseEntity.ok(veiculo);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			ResponseEntity.status(500).build();
		}

		return response;
	}

	@DeleteMapping("/deleteVeiculo/{veiculoId}")
	public ResponseEntity<Boolean> deleteVeiculo(@PathVariable Long veiculoId) {

		ResponseEntity<Boolean> response = null;
		try {
			Boolean deleated = veiculoService.deleteVeiculoById(veiculoId);

			response = ResponseEntity.ok(deleated);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			ResponseEntity.status(500).build();
		}

		return response;
	}
	
	@GetMapping("/getGastos")
	public ResponseEntity<List> getGastos(@RequestBody GastosRequestDTO gastosRequestDTO) {

		ResponseEntity<List> response = null;
		try {
			List gastos = veiculoService.calculaGastosCarros(gastosRequestDTO);

			response = ResponseEntity.ok(gastos);
		} catch (Exception e) {
			// TODO: Tratar erro melhor
			ResponseEntity.status(500).build();
		}

		return response;
	}


}
