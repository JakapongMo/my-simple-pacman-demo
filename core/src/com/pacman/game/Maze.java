package com.pacman.game;

public class Maze {
	private boolean [][]hasDots;
	
	String[] MAP = new String []{
			"####################",
	        "#..................#",
	        "#.###.###..###.###.#",
	        "#.#...#......#...#.#",
	        "#.#.###.####.###.#.#",
	        "#.#.#..........#.#.#",
	        "#.....###..###.....#",
	        "#.#.#..........#.#.#",
	        "#.#.###.####.###.#.#",
	        "#.#...#......#...#.#",
	        "#.###.###..###.###.#",
	        "#..................#",
	        "####################"
	};
	private int height;
	private int width;
	
	public Maze(){
		height = MAP.length;
		width = MAP[0].length();
		initDotData();
	}
	private void initDotData(){
	hasDots = new boolean[height][width];
		for(int r =0; r<height; r++){
			for(int c=0; c<width; c++){
				hasDots[r][c] = MAP[r].charAt(c) == '.';
			}
		}
	}
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	public boolean hasWallAt(int r, int c){
		return MAP[r].charAt(c) == '#';
	}
	public boolean hasDotAt(int r, int c){
		return hasDots[r][c];
	}
	public void removeDotAt(int r, int c){
		hasDots[r][c]= false;
	}
}
