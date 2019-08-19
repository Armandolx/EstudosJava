package br.com.minhagaragem.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity //Indica para o JPA que a classe é uma entidade. O mesmo relaciona esta com uma tabela do banco. Persistente
@Table(name = "carro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carro{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // O responsável pela persistência irá controlar o ID (primary-key), caso não estivesse presente, o controle deveria ser feito pela aplicação
	// auto increment ou sequence, dependendo do banco de dados
	private int id;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "placa")
	private String placa;
	
	@Column(name = "data_aquisicao")
	private Date dataAquisicao;
	
	@Column(name = "valor_pago", nullable = false) //nullable = false para que seja obrigatório. O valor default é true
	private float valorPago;
	
	@Column(name = "valor_estimado")
	private float valorEstimado;
	
	@Column(name = "cor")
	private String cor;
	
}
