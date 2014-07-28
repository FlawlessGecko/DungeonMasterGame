package com.FlawlessGecko.dungeon.graphics;

public class Sprite {
	//changes in size of what our sprite for canvas
	public final int SIZE;
	private int x,y;
	public int []pixels;
	private SpriteSheet sheet;
	public static Sprite grass = new Sprite(16,0,0,SpriteSheet.tiles);//adds new instance of sprite glass
	
	//caliing where the spride is in the grid like x10y40
	public Sprite(int size,int x,int y,SpriteSheet sheet){
		SIZE = size;
		pixels = new int [SIZE*SIZE];
		this.x = x*size;
		this.y=y*size;
		this.sheet = sheet;
		load();
	}
private void load(){
for (int y = 0;y<SIZE;y++){
for (int x =0;x<SIZE;x++){
	pixels[x+y*SIZE]= sheet.pixels[(x+this.x)+(y+this.y)*sheet.SIZE];
}
}
}
}
