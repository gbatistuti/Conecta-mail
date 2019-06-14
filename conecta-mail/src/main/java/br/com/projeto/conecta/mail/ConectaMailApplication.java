package br.com.projeto.conecta.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConectaMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConectaMailApplication.class, args);
//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
//
//				ConectaMailApplication.class.getPackage().getName());
//
//		MensageiroService mensageiro = applicationContext.getBean(MensageiroService.class);
//
//		mensageiro.enviar(new Mensagem("conecta.mensagem@gmail.com",
//
//				"gustavo.batistuti1@gmail.com"
//
//				, "Aula Spring E-mail", "Olá! \n\n O envio de e-mail deu certo!"));
//
//		applicationContext.close();
//
//		System.out.println("Fim!");
	}

}
