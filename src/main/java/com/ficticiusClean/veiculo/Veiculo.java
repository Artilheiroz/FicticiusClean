package com.ficticiusClean.veiculo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo {

	public Veiculo() {

	}

	public Veiculo(String nome, String marca, String modelo, Calendar dataFabricacao, Float consumoCidade,
			Float consumoRodovia) {

		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.dataFabricacao = dataFabricacao;
		this.consumoCidade = consumoCidade;
		this.consumoRodovia = consumoRodovia;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = 0L;

	@Column
	private String nome;

	@Column
	private String marca;

	@Column
	private String modelo;

	@Column
	private Calendar dataFabricacao;

	@Column
	private Float consumoCidade;

	@Column
	private Float consumoRodovia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Float getConsumoCidade() {
		return consumoCidade;
	}

	public void setConsumoCidade(Float consumoCidade) {
		this.consumoCidade = consumoCidade;
	}

	public Float getConsumoRodovia() {
		return consumoRodovia;
	}

	public void setConsumoRodovia(Float consumoRodovia) {
		this.consumoRodovia = consumoRodovia;
	}

}
