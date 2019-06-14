package br.com.projeto.conecta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.conecta.mail.domain.Mensagem;
import br.com.projeto.conecta.mail.service.MensageiroService;

@RestController
@RequestMapping("localhost:8080/homeConsultor")
public class MensagemController {
	
	@Autowired
	MensageiroService mensageiroService;
	
	@PostMapping
	public ResponseEntity<String> enviarMensagemApontamento(@RequestBody Mensagem mensagem) {
		try {
			mensageiroService.enviar(mensagem);
			return ResponseEntity.ok("Mensagem enviada com sucesso!");
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("erro interno no servidor");
		}
	}

}
