package br.com.cit.primeiroPJSpring.dtos;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

// Data transfer object: transfere informações vindas da requisição, seja de outra API ou da tela e passar por todas as camadas: Controller, service e repository
// pode parecer redundante, mas são os campos para o salvar, por exemplo. Se quisessemos adicionar
// uma hora (como a que foi salvo) o usuário não precisa passar esse campo na requisição, mas o mesmo estará
// presente na resposta obtida
public class ViagemDto implements Serializable {

	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;

	private String localDeDestino;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataPartida;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataRetorno;

	private String acompanhante;

	public ViagemDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "Local de Destino é uma informação obrigatória") // evita que campos inconsistentes cheguem ao banco
	@Length(min = 3, max = 40, message = "Local de Destino deve estar entre 3 e 40 caracteres")
	public String getLocalDeDestino() {
		return localDeDestino;
	}

	public void setLocalDeDestino(String localDeDestino) {
		this.localDeDestino = localDeDestino;
	}

	@NotNull(message = "Data da Partida é uma informação obrigatória")
	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

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

	@Override
	public String toString() {
		return "ViagemDto [id=" + id + ", localDeDestino=" + localDeDestino + ", dataPartida=" + dataPartida
				+ ", dataRetorno=" + dataRetorno + ", acompanhante=" + acompanhante + "]";
	}
}
