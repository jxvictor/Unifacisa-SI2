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
@RequestMapping("/games")

public class GamesController {
	
	private GamesRepository gamesRepository;
	
	public GamesController() 
	{
		this.gamesRepository = new GamesRepository();
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Games game) {
		gamesRepository.cadastrar(game);
	}
	
	//
	@GetMapping()
	public ResponseEntity<List<Games>> obterTodos(Games game){
		try 
		{
			return ResponseEntity.ok(gamesRepository.obterTodos());
		}
		catch(Exception e)
		{
			return (ResponseEntity<List<Games>>)ResponseEntity.badRequest();
		}
	}
	
	@DeleteMapping()
	public void deletarGame(@RequestBody Games game)
	{
		gamesRepository.remover(game);
	}
	
	@PutMapping()
	public ResponseEntity<Games> editar(@RequestBody Games game, @PathVariable int id) throws Exception{
		
		try {
			return new ResponseEntity<Games>(gamesRepository.editar(game, id), HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<Games>(HttpStatus.BAD_REQUEST);
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
