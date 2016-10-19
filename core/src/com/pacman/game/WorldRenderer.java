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
	public WorldRenderer(PacmanGame pacmanGame, World world){
		this.pacmanGame = pacmanGame;
		batch = pacmanGame.batch;
		
		this.world = world;
		
		pacmanImg = new Texture("pacman.png");
	}
	public void render(float delta){
		//update(delta);
		//Gdx.gl.glClearColor(0,0,0,1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		SpriteBatch batch = pacmanGame.batch;
		batch.begin();
		Vector2 pos = pacman.getPosition();
		batch.draw(pacmanImg,pos.x,pos.y);
		batch.end();
	}
}
