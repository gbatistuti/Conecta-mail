package br.com.projeto.conecta.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;

import br.com.projeto.conecta.mail.domain.Mensagem;
import br.com.projeto.conecta.mail.service.MensageiroService;
import br.com.projeto.conecta.mail.service.MensagemService;

@SpringBootApplication
public class ConectaMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConectaMailApplication.class, args);
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(

				ConectaMailApplication.class.getPackage().getName());

		MensageiroService mensageiro = applicationContext.getBean(MensageiroService.class);

		MensagemService mensagemComponent = new MensagemService();

		ResponseEntity<Mensagem> resposta = mensagemComponent.getRestTemplate().getForEntity(mensagemComponent.getUrl(),
				Mensagem.class);

		if(resposta != null) {
		Mensagem msg = resposta.getBody();
		
		mensageiro.enviar(msg);
		
		System.out.println("Enviou :)");
		}
		applicationContext.close();

		System.out.println("Fim!");
	}

}
