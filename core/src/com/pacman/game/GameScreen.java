package com.pacman.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
public class GameScreen extends ScreenAdapter {

	World world;
	WorldRenderer worldRenderer; 
	private PacmanGame pacmanGame;
	private Texture pacmanImg;
	private Pacman pacman;
	
	public GameScreen(PacmanGame pacmanGame){
	 	this.pacmanGame = pacmanGame;
	 	pacmanImg =new Texture("pacman.png");
	 	world = new World(pacmanGame);
	 	pacman = world.getPacman();
	}
	@Override
    public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		worldRenderer = new WorldRenderer(pacmanGame, world);
		worldRenderer.render(delta);
    }
	private void update(float delta){
		updatePacmanDirection();
		world.update(delta);
	}
	private void updatePacmanDirection() {
		Pacman pacman = world.getPacman();
		if(Gdx.input.isKeyPressed(Keys.UP)) {
            pacman.setNextDirection(Pacman.DIRECTION_UP);
        }
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			pacman.setNextDirection(Pacman.DIRECTION_RIGHT);
        }
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			pacman.setNextDirection(Pacman.DIRECTION_DOWN);
        }
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			pacman.setNextDirection(Pacman.DIRECTION_LEFT);
        }
		if(this.isStill()){
			pacman.setNextDirection(Pacman.DIRECTION_STILL);
		}
	}
	public boolean isStill(){
		return (!(Gdx.input.isKeyPressed(Keys.UP)) && !(Gdx.input.isKeyPressed(Keys.RIGHT)) && 
				!(Gdx.input.isKeyPressed(Keys.DOWN))&&!(Gdx.input.isKeyPressed(Keys.LEFT)) );
	}
}

