package br.com.projeto.conecta.mail.service;

import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.projeto.conecta.mail.domain.Mensagem;

@Component
public class MensagemService extends TimerTask {

	@Autowired
	MensageiroService mensageiroService;

	private final RestTemplate restTemplate;
	private final String url;
	private final ResponseEntity<Mensagem> resposta;

	public MensagemService() {
		this.restTemplate = new RestTemplate();
		this.url = "http://localhost:8080/mensagem";
		this.resposta = this.restTemplate.getForEntity(url, Mensagem.class);
	}

	@Autowired
	@Override
	public void run() {
		
		
		System.out.println("TA RODANDO");
		if (resposta.hasBody()) {
			System.out.println("------TEM CORPO-------");
			Mensagem msg = resposta.getBody();
			Mensagem msg2 = new Mensagem("gustavo.batistuti1@gmail.com", "TESTE", "TESTE");
			try {
				System.out.println("------TRY-------");
				System.out.println(msg.getDestinatarios());
				System.out.println(msg.getAssunto());
				System.out.println(msg.getCorpo());
				System.out.println(msg.toString());
				mensageiroService.enviar(msg);
				System.out.println("---------------DEU BOM------------");
				ResponseEntity.ok("Mensagem enviada com sucesso!");
			} catch (Exception e) {
				System.out.println("------CATCH-------");
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
