package com.ficticiusClean.veiculo;

public class GastosResponseDTO {

	private String nome;
	private String marca;
	private String modelo;
	private Integer ano;
	private Float quantidadeCombustivel;
	private Double valorGasto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Float getQuantidadeCombustivel() {
		return quantidadeCombustivel;
	}

	public void setQuantidadeCombustivel(Float quantidadeCombustivel) {
		this.quantidadeCombustivel = quantidadeCombustivel;
	}

	public Double getValorGasto() {
		return valorGasto;
	}

	public void setValorGasto(Double valorGasto) {
		this.valorGasto = valorGasto;
	}

}
