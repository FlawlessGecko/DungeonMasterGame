package com.FlawlessGecko.dungeon.graphics;

import java.util.Random;

import com.FlawlessGecko.dungeon.tiles.Tile;

public class Screen {

private int width,height;
public int[]pixels;
public final int MAP_SIZE=8;
public final int MAP_SIZE_MASK=MAP_SIZE-1;
public int[]tiles = new int[MAP_SIZE*MAP_SIZE];

private Random random = new Random();

// = to whatever we put in game class for width,height,scale
//pixel array for pixels for game
//Tiles[0] blacks out every 8th square

public Screen(int width,int height){
	this.width = width;
	this.height=height;
	pixels = new int[width*height];//0-50,399 =50,400

	for (int i = 0;i< MAP_SIZE*MAP_SIZE;i++){
	tiles[i]= random.nextInt(0xff00ff);
	tiles[0]=0;
}
}

//Clear the canvas of former animation
public void clear(){
	for (int i = 0;i<pixels.length;i++){
		pixels[i]=0;
	}
}
//for keeps going till break drawing one pixel at a time
//Tile index know which tiles to retrieve
	public void render(int xOffset, int yOffset) {
		
		for (int y = 0; y < height; y++) {
			int yp = y+yOffset;
			if(yp < 0 ||yp >=height)continue;
			
			for (int x = 0; x < width; x++) {
			int xp= x + xOffset;
		    if(xp < 0 ||xp >=width)continue;
				pixels[xp + yp * width] = Sprite.grass.pixels[(x&15)+(y&15)*Sprite.grass.SIZE];          // pixel array plus

			}

		}

	}
	//allows up to change the sprite without changing everything
	//absolute value the  of the 2d area for one tile
	//Relative value moves both
	//offset is managing the change of where the player is tile base
	// if (Xa < 0 || Xa >= width || ya < 0 || ya >= width) allows us render to what is visible
	public void renderTile(int xp, int yp, Tile tile) {
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + xp;
		
			for (int X = 0; y < tile.sprite.SIZE; X++) {
				int Xa = X + xp;
				if (Xa < 0 || Xa >= width || ya < 0 || ya >= width)break;
			pixels[Xa+ya*width]= tile.sprite.pixels[X+y*tile.sprite.SIZE];
			}
		}
	}
}