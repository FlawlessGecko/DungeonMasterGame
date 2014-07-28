package com.FlawlessGecko.dungeon.tiles;

import com.FlawlessGecko.dungeon.graphics.Screen;
import com.FlawlessGecko.dungeon.graphics.Sprite;

//Check where sprite tiles is located or rendered
public class Tile {

	public int x,y;
	public Sprite sprite;
	public static Tile grass = new GrassTile(Sprite.grass);
	//this is new tile for each tile we create
	public Tile(Sprite sprite){
		this.sprite =sprite;
	}
	//Where we are rendering and seeing class
	public void render(int x,int y,Screen screen){
		
	}
	// by default wont be solid
public boolean solid(){
	return false;
}
}
