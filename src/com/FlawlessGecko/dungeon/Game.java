package com.FlawlessGecko.dungeon;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.FlawlessGecko.dungeon.graphics.Screen;
import com.FlawlessGecko.dungeon.input.KeyBoard;
//canvas is where we paint the image too also record mouse
public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int width =300;
	public static int height =width /16*9;
	public static int scale =3;
	public static String title ="DungeonMaster";
	
	//creating a sub thread with-in a thread
	private Thread thread;
	private JFrame frame;
	private KeyBoard key;
	private boolean running = false;
	private Screen screen;
	
	//Pixels total non alpha total pixels
	private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	
	//contains many integers in one group
	//dataBuffer get information on pixels
	//[] contains a array of ints
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
			
			
	//set preferred size function is in canvas
	//Dimension creates a new area size for game
	public Game(){
	Dimension size = new Dimension(width*scale,height*scale);
	setPreferredSize(size);
	
	frame = new JFrame();
	screen = new Screen(width,height);
	key = new KeyBoard();
	
	addKeyListener(key);
;	}
	
	//Void means return nothing just what in brackets
	//synchronized avoids concurrent same Threads
	//Also starts and stops threads like display or game
	//when thread starts it also implements while run
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this,"Display");
		thread.start();
		
	}
	
	//stops threads and sub-threads ,  also ends while loop
	//display or game and waits for stop
	public synchronized void stop(){
		running =false;
		try{
			thread.join();
	}catch(InterruptedException e){
		e.printStackTrace();
		}
	}

	//What runs when thread starts
	//while loop keeps gaming running
	//Render and update is frames limited and buffer
	//Sets what ever out computer time to game time
	
	public void run(){
	long lastTime = System.nanoTime();
	long timer = System.currentTimeMillis();
	final double ns =1000000000.0 /60.0;
	double delta =0;
	int frames =0;
	int updates =0;
	requestFocus();
	while(running){
	long now =System.nanoTime();//re-sets time to computer time lag
	delta += (now-lastTime)	/ns;
	lastTime =now;
	while (delta >=1){
		update();
		updates++;
		delta--;
	}
	
	render();
	frames++;
	//adds 1000 ns to time which is 1 sec per
	if(System.currentTimeMillis()-timer > 1000){
		timer += 1000;
		System.out.println(updates+ "ups,"+frames+"frames");//prints frames and ups
		frame.setTitle(title+" | " +updates+ "ups,"+frames+"frames");
		updates =0;
		frames =0;
	}
	}
  stop();
	}
	
	//Limits fps so don't have different frames per cpu;
	//if(key.whatever)y-- means were moving in the canvas
	int x =0,y=0;
	public void update(){
		key.update();
		if(key.up)y--;
		if(key.down)y++;
		if(key.left)x--;
		if(key.right)x++;
	}
	
	//Handles rendering of what's on screen 
	//Buffer handles the flow of information for use
	//Buffer strategy is buffer x3 or x2 or x1 prevents screen tearing
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs ==null){
			createBufferStrategy(3);
			return;
		}
		//Linking the between buffer and draw
		//g.dispose gets rid of old graphics
		//bs.show adds the new image from the buffer
		//g.fillrect adds new rect to window
		screen.clear();
		screen.render(x,y);
		for(int i =0;i < pixels.length;i++){
			pixels[i] =screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(),null);
		g.dispose();
		bs.show();
		
	}
	
	//This is the very first thing run
	////Re-sizable helps from changing window graphics errors
	//Location is where the window is displayed
	public static void main(String[] args){
	
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("DungeonMaster");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
		
	}
}