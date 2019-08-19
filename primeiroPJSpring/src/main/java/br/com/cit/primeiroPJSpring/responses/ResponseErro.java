package br.com.cit.primeiroPJSpring.responses;

public class ResponseErro {

	private String status;
	private String erro;

	
	
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getErro() {
		return erro;
	}



	public void setErro(String erro) {
		this.erro = erro;
	}



	public ResponseErro() {
	}
}
