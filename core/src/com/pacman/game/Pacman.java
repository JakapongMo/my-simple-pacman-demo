package com.pacman.game;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    private static final int [][] DIR_OFFSETS = new int [][] {
	        {0,0},
	        {0,-1},
	        {1,0},
	        {0,1},
	        {-1,0}
	    };
	
	private Vector2 position;
	
	public Pacman(int x, int y){
		position = new Vector2(x,y);
	}
	public Vector2 getPosition(){
		return position;
	}
	public void move(int dir){
		position.x += 10 * DIR_OFFSETS[dir][0];
	    position.y += 10 * DIR_OFFSETS[dir][1];
	}

}