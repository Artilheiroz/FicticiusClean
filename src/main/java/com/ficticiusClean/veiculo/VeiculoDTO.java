package com.ficticiusClean.veiculo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class VeiculoDTO {

	private String nome;
	private String marca;
	private String modelo;
	private String dataFabricacao;
	private Float consumoCidade;
	private Float consumoRodovia;

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

	public String getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
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
	
	public Veiculo toVeiculo() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFabricacaoDate = null;
		try {
			dataFabricacaoDate = format.parse(dataFabricacao);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dataFabricacaoDate);
		
		return new Veiculo(nome, marca, modelo, calendar, consumoCidade, consumoRodovia);
	}

}
