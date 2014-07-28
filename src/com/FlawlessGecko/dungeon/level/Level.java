package com.FlawlessGecko.dungeon.level;

import com.FlawlessGecko.dungeon.graphics.Screen;
//will get sub blocks levels like modblocks

public class Level {

//2 ints for our width and hight of class
protected int width,height;
protected int[]tiles;//where we are drawing from

//template for game levels for extends
public Level(int width,int height){
	this.width = width;
	this.height= height;
	tiles = new int[width*height];
	generateLevel();
}
//Loading random level from path of tiles
public Level(String path){
	loadLevel(path);
}

private void generateLevel() {
	
	
}
private void loadLevel(String path) {
	
	
}
public void Update(){
	
}
private void time(){
	
}
public void Render(int xScroll,int yScroll,Screen screen){
	
}
}
