package br.com.projeto.conecta.mail.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mensagem {

	@JsonProperty private String remetente;
	@JsonProperty private String destinatarios;
	@JsonProperty private String assunto;
	@JsonProperty private String corpo;

	public Mensagem(String remetente, String destinatarios, String assunto, String corpo) {
		this.remetente = remetente;
		this.destinatarios = destinatarios;
		this.assunto = assunto;
		this.corpo = corpo;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
}
