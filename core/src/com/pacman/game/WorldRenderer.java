package com.pacman.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
	PacmanGame pacmanGame;
	Pacman pacman;
	World world;
	
	SpriteBatch batch;
	Texture pacmanImg;
	private MazeRenderer mazeRenderer;
	public static final int BLOCK_SIZE = 40;
	
	public WorldRenderer(PacmanGame pacmanGame, World world){
		this.pacmanGame = pacmanGame;
		batch = pacmanGame.batch;
		
		this.world = world;
		
		pacmanImg = new Texture("pacman.png");
		
		mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
	}
	public void render(float delta){
		mazeRenderer.render();
		pacman = world.getPacman();
		SpriteBatch batch = pacmanGame.batch;
		Vector2 pos = pacman.getPosition();
		batch.begin();
		batch.draw(pacmanImg,pos.x-BLOCK_SIZE/2,PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
		batch.end();
	}
}
