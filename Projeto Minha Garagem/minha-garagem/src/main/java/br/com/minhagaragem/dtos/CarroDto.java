package br.com.minhagaragem.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CarroDto {

	private int id;
	
	private String modelo;
	
	private String marca;
	
	private String placa;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataAquisicao;
	
	private float valorPago;
	
	private float valorEstimado;
	
	private String cor;
	
	public CarroDto(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public float getValorPago() {
		return valorPago;
	}

	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}

	public float getValorEstimado() {
		return valorEstimado;
	}

	public void setValorEstimado(float valorEstimado) {
		this.valorEstimado = valorEstimado;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
