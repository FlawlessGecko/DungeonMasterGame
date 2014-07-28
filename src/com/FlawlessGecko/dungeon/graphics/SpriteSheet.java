package com.FlawlessGecko.dungeon.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	//Path is where are folder is found at for the sprite sheet
	//Size is the total area of our canvas
	//pixels is called because we are working with pixels not images.
	private String path;
	public final int SIZE;
	public int []pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);
	//check the size per sheet
	//this is where we call the path of file size of screen and pixels of screen area.
	public SpriteSheet(String path,int size){
		this.path = path;
		this.SIZE = size;
		pixels = new int[size*size];//sets the area off sheet
		load();
	}
//here we calling for our image to load which is the sprite sheet
//We also have 3 temp ints w,h,Rgb;	try and catch was added to catch errors.
private void load(){
	try {
		BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
		int w =image.getWidth();
		int h = image.getHeight();
		image.getRGB(0, 0,w,h,pixels,0,w);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
