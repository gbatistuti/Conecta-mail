package br.com.projeto.conectamail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.projeto.conectamail.domain.Mensagem;

@Component
@EnableScheduling
public class MensagemService {

	@Autowired
	MensageiroService mensageiroService;

	private final RestTemplate restTemplate;
	private final String url;

	public MensagemService() {
		this.restTemplate = new RestTemplate();
		this.url = "http://localhost:8080/mensagem";
	}

	@Scheduled(fixedDelay = 1000)
	public void enviarMensagem() {
		
		ResponseEntity<Mensagem> resposta = this.restTemplate.getForEntity(url, Mensagem.class);
		
		if (resposta.hasBody()) {
			Mensagem msg = resposta.getBody();
			try {
				mensageiroService.enviar(msg);
				System.out.println("Email enviado para: " + msg.getDestinatarios());
				ResponseEntity.ok("Mensagem enviada com sucesso!");
			} catch (Exception e) {
				System.out.println("ERRO");
				ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
			}
		}
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public String getUrl() {
		return url;
	}
}
