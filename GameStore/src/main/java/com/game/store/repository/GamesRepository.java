package com.game.store.repository;

import java.util.List;
import java.util.Optional;

import com.game.store.model.Games;
public class GamesRepository{
	
	private List<Games> games;
	
	public GamesRepository() {
		this.games = Database.getInstance().games();
	}
	public void cadastrar(Games game) {
		games.add(game);
	}
	public List<Games> obterTodos(){
		return games;
	}
	public void remover(int id) {
		games.remove(obterGame(id));
	}
	
	public Games obterGame(int id) {
		Optional<Games> gameEncontrado = games.stream().filter(p -> p.getId() == id).findFirst();
		return gameEncontrado.isPresent() ? gameEncontrado.get() : null;
	}
	
	public Games editar(Games game, int id) throws Exception {
		Games gameParaEditar = obterGame(id);
		
		if(gameParaEditar == null)
			throw new Exception("Game não existe");
		
		gameParaEditar.setTitulo(game.getTitulo());
		//gameParaEditar.setNumeroDeVendas(game.getNumeroDeVendas());
		
		return gameParaEditar;
	}
	
	public Games realizarVenda(Games game, int id) throws Exception {
		Games gameParaEditar = obterGame(id);
		
		if(gameParaEditar == null)
			throw new Exception("Game não existe");
		gameParaEditar.setNumeroDeVendas(game.getNumeroDeVendas());
		
		return gameParaEditar;
	}
	

}
