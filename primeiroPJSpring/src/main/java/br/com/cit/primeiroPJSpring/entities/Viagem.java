package br.com.cit.primeiroPJSpring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity //JPA
@Table(name = "viagem") //JPA
@JsonInclude(Include.NON_EMPTY) //Se o dado estiver vazio, o mesmo não é incluído no json
public class Viagem implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	@Id //JPA
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "local_destino", nullable = false) //JPA
	private String localDeDestino;

	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "data_partida", nullable = false)
	private Date dataPartida;

	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "data_retorno", nullable = true)
	private Date dataRetorno;

	@Column(name = "acompanhante", nullable = true)
	private String acompanhante;

	public Viagem() {

	}

	public Viagem(Long id, String localDeDestino, Date dataPartida, Date dataRetorno, String acompanhante) {
		this.id = id;
		this.localDeDestino = localDeDestino;
		this.dataPartida = dataPartida;
		this.dataRetorno = dataRetorno;
		this.acompanhante = acompanhante;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Formatar os campos na hora de retornar
	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public String getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(String acompanhante) {
		this.acompanhante = acompanhante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocalDeDestino() {
		return localDeDestino;
	}

	public void setLocalDeDestino(String localDeDestino) {
		this.localDeDestino = localDeDestino;
	}

	@Override
	public String toString() {
		return "Viagem [id=" + id + ", localDeDestino=" + localDeDestino + ", dataPartida=" + dataPartida
				+ ", dataRetorno=" + dataRetorno + ", acompanhante=" + acompanhante + "]";
	}

}