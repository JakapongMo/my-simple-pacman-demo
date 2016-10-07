package com.pacman.game;

public class World {
	private Pacman pacman;
	private PacmanGame pacmanGame;
	
	World(PacmanGame pacmanGame){
		this.pacmanGame = pacmanGame;
		
		pacman = new Pacman(100,100);
		
	}
	Pacman getPacman(){
		return pacman;
	}

}
