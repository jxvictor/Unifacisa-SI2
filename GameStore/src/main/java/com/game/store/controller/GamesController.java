package com.game.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.game.store.model.*;
import com.game.store.repository.Database;
import com.game.store.repository.GamesRepository;


@RestController
@RequestMapping("/v1/games")

public class GamesController {
	
	private GamesRepository gamesRepository;
	
	public GamesController() 
	{
		this.gamesRepository = new GamesRepository();
	}
	
	@GetMapping()
	public ResponseEntity<List<Games>> obterTodos(){		
		try
		{
			return new ResponseEntity<List<Games>>(gamesRepository.obterTodos(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<List<Games>>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping()
	public ResponseEntity<String> cadastrar(@RequestBody Games game)
	{
		try
		{
			gamesRepository.cadastrar(game);
			return new ResponseEntity<String>("Game cadastrado com sucesso", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable int id){
		try
		{
			gamesRepository.remover(id);
			return new ResponseEntity<String>("Game removido com sucesso", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Games> editar(@PathVariable int id, @RequestBody Games game){
		try {
			Games gameEditado = gamesRepository.editar(game, id);
			return new ResponseEntity<Games>(gameEditado, HttpStatus.OK); 
		}
		catch(Exception e) {
			return new ResponseEntity<Games>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/vendas/{id}")
	public void realizarVenda(Games game, @PathVariable int id) {
		int realizeiVenda = 0;
		for (int i = 0; i <= realizeiVenda; i++) {
			game.setNumeroDeVendas(i++);
		}
	}
	
}
