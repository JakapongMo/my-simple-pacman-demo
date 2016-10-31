package com.pacman.game;

public class World {
	private Pacman pacman;
	private PacmanGame pacmanGame;
	private Maze maze;
	private int score;
	
	World(PacmanGame pacmanGame){
		maze = new Maze();
		this.pacmanGame = pacmanGame;
		pacman = new Pacman(60,60,this);
		score = 0;
			
	}
	public void increaseScore(){
		score +=1;
	}
	public int getScore(){
		return score;
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
