package com.FlawlessGecko.dungeon.level;
import java.util.Random;


public class RandomLevel extends Level {
	//Constructor for level executes the code
	private final Random random = new Random();
	public RandomLevel(int width, int height) {
		super(width, height);
		
	}

	//protected is a way to run code from level
	//allows us to control a specific tile
	protected void generateLevel(){
		for (int y =0;y <height;y++){
		for (int x =0;x <width;x++){
			tiles[x+y*width]= random.nextInt(4);//random tiles in level
		}
		}
}
}
