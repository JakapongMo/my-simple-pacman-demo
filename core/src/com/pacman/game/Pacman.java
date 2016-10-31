package com.pacman.game;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
	private int currentDirection;
	private int nextDirection;
	private World world;
	
	
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
	 public static final int SPEED = 5;
	
	private Vector2 position;
	
	public Pacman(int x, int y, World world){
		position = new Vector2(x,y);
		currentDirection = DIRECTION_STILL;
		nextDirection = DIRECTION_STILL;
		this.world = world;
	}
	public void setNextDirection(int dir){
		nextDirection = dir;
	}
	public Vector2 getPosition(){
		return position;
	}
	public void move(int dir){
		position.x += SPEED * DIR_OFFSETS[dir][0];
	    position.y += SPEED * DIR_OFFSETS[dir][1];
	}
	public void update(){
		Maze maze = world.getMaze();
		if(isAtCenter()){
			if(maze.hasDotAt(getRow(), getColumn())){
				maze.removeDotAt(getRow(), getColumn());
				world.increaseScore();
			}
			if(canMoveInDirection(nextDirection)){
				currentDirection = nextDirection;
			}else{
				currentDirection=DIRECTION_STILL;
			}
		}
		position.x +=SPEED*DIR_OFFSETS[currentDirection][0];
		position.y +=SPEED*DIR_OFFSETS[currentDirection][1];
	}
	public boolean isAtCenter(){
		int blockSize = WorldRenderer.BLOCK_SIZE;
		return ((((int)position.x - blockSize/2)% blockSize) == 0) &&
				((((int)position.y - blockSize/2)% blockSize) ==0);
	}
	private boolean canMoveInDirection(int dir){
		Maze maze = world.getMaze();
		int newRow = (int)getRow()+ DIR_OFFSETS[nextDirection][1];
		int newCol = (int)getColumn()+  DIR_OFFSETS[nextDirection][0];
		if(maze.hasWallAt(newRow, newCol)){
			return false;
		}
			return true;
	}
	private int getRow(){
		return ((int)position.y)/ WorldRenderer.BLOCK_SIZE;
	}
	private int getColumn(){
		return ((int)position.x)/ WorldRenderer.BLOCK_SIZE;
	}
}