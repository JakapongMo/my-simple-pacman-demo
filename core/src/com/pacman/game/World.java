package com.pacman.game;

public class World {
	private Pacman pacman;
	private PacmanGame pacmanGame;
	private Maze maze;
	
	World(PacmanGame pacmanGame){
		this.pacmanGame = pacmanGame;
		
		pacman = new Pacman(60,60);
		maze = new Maze();	
	}
	Maze getMaze(){
		return maze;
	}
	Pacman getPacman(){
		return pacman;
	}
	public void update(float delta){
		pacman.update();
	}

}
