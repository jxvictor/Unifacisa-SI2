package com.game.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.game.store.model.Games;
import com.game.store.model.Response;
import com.game.store.repository.Database;
import com.game.store.repository.GamesRepository;
import com.sun.net.httpserver.Authenticator.Result;

@RestController
@RequestMapping("/v2/games")
public class GamesMelhoradoController {
	
	private GamesRepository gamesRepository;
	public GamesMelhoradoController() 
	{
		this.gamesRepository = new GamesRepository();
	}
	
	@GetMapping()
	public ResponseEntity<Response<List<Games>>> obterTodos(){		
		
		Response<List<Games>> response = new Response<List<Games>>();
		
		try
		{
			response.setDados(gamesRepository.obterTodos());
			response.setStatus(HttpStatus.OK.value());
			
			return ResponseEntity.ok(response);
		}
		catch(Exception e)
		{
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao cadastrar novo game");
			
			return ResponseEntity.ok(response);
		}
	}

	@PostMapping()
	public ResponseEntity<Response<Games>> cadastrar(@Valid @RequestBody Games game, BindingResult result)
	{	
		Response<Games> response = new Response<Games>(); 
		
		try
		{		
			if(result.hasErrors())
			{			
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				for(ObjectError  error : result.getAllErrors()) {
					String key = String.valueOf(response.getErros().size() + 1);
					
					response.getErros().put(key, error.getDefaultMessage());
				}
				
				return ResponseEntity.ok(response);
			}
			
			response.setStatus(HttpStatus.OK.value());
			gamesRepository.cadastrar(game);		
			response.setDados(game);
			
			return ResponseEntity.ok(response);
			
		}
		catch(Exception e) {	
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao cadastrar novo game");
			
			return ResponseEntity.ok(response);
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Games>> deletar(@PathVariable int id){
		
		Response<Games> response = new Response<Games>(); 
		
		
		try
		{	
			response.setStatus(HttpStatus.OK.value());
			gamesRepository.remover(id);
			return ResponseEntity.ok(response);
		}
		catch(Exception e) {
			
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao remover game");
			return ResponseEntity.ok(response);
		}
	}
	
	
	/*@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable int id){
		
		Response<String> response = new Response<String>();
		
		
		try
		{
			gamesRepository.remover(id);
			return new ResponseEntity<String>("Game removido com sucesso", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}*/
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<Games>> editar(@PathVariable int id, @Valid @RequestBody Games game, BindingResult result){
		
		Response<Games> response = new Response<Games>(); 
		
		try {
			if(result.hasErrors())
			{			
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				for(ObjectError  error : result.getAllErrors()) {
					String key = String.valueOf(response.getErros().size() + 1);
					
					response.getErros().put(key, error.getDefaultMessage());
				}
				
				return ResponseEntity.ok(response);
			}
			response.setStatus(HttpStatus.OK.value());
			response.setDados(gamesRepository.editar(game, id));
			return ResponseEntity.ok(response);
		}
		catch(Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getErros().put("1", "Falha ao editar game");
			return ResponseEntity.ok(response);
		}
	}
}