package com.game.store.repository;

import java.util.ArrayList;
import java.util.List;

import com.game.store.model.*;
public class Database {
	
	private static Database instancia;
	
	private List<Games> games = new ArrayList<Games>();
	
	public static Database getInstance() {
		if(instancia == null ) {
			instancia = new Database();
		}
		
		return instancia;
	}
	public List<Games> games()
	{
		return games;
	}
	
}
