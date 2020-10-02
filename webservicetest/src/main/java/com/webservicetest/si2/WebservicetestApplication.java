package com.webservicetest.si2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebservicetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebservicetestApplication.class, args);
	}
	
	@GetMapping
	public String olaWebService() {
		return "EndPoint principal";
	}
	
	@GetMapping("/inicio")
	public String bemVindo() {
		return "Bem vindo ao WebService REST";
	}
	
	@RequestMapping(value = "mensagem", method = RequestMethod.GET)
	public String teste() {
		return "Utilizando Request Mapping";
	}
	
	//localhost:8080/obterAluno/123654
	@GetMapping("/obterAluno/{matricula}")
	public String aluno(@PathVariable int matricula) {
		return "João Victor de matrícula: " + matricula;
	}
	
	@GetMapping("/soma/{numero1}/{numero2}")
	public String soma(@PathVariable int numero1, @PathVariable int numero2) {
		return "A soma é igual a: " + (numero1 + numero2);
	}
	
	@PostMapping("/cadastro")
	public String cadastrar(@RequestBody Aluno aluno) {
		
		return "Nome: " + aluno.getNome() + " | Matricula: " + aluno.getMatricula();
	}

}
