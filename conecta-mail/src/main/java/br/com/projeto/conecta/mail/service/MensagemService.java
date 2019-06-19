package br.com.projeto.conecta.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.projeto.conecta.mail.domain.Mensagem;

@Component
public class MensagemService {
	
	@Autowired
	MensageiroService mensageiroService;
	
	private final RestTemplate restTemplate;
	private final String url;
	
	public MensagemService() {
		this.restTemplate = new RestTemplate();
		this.url = "http://localhost:8080/mensagem";
	}
	
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}


	public String getUrl() {
		return url;
	}


//	public ResponseEntity<String> enviarMensagemApontamento() {
//		ResponseEntity<Mensagem> resposta = this.restTemplate.getForEntity(url, Mensagem.class);
//		
//		Mensagem msg = resposta.getBody();
//		
//		try {
//			mensageiroService.enviar(msg);
//			return ResponseEntity.ok("Mensagem enviada com sucesso!");
//		} catch (Exception e) {
//			return ResponseEntity
//					.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("erro interno no servidor");
//		}	
//		
//	}
	
	

}
