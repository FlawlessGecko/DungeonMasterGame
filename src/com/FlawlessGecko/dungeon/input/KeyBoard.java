package com.FlawlessGecko.dungeon.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//key listner record to canvas what we use for code
public class KeyBoard implements KeyListener {
	//all the max keys we can do
	//we are adding a array for true or false up,down,left,right
	private boolean[]keys = new boolean[120];
	public boolean up,down,left,right;
	//checks if key is pressed or not.
	//we are adding Key events to have the canvas check for keyboard input
	public void update(){
		up =keys[KeyEvent.VK_UP]||  keys[KeyEvent.VK_W];
		down =keys[KeyEvent.VK_DOWN]||  keys[KeyEvent.VK_S];
		left =keys[KeyEvent.VK_LEFT]||  keys[KeyEvent.VK_A];
		right =keys[KeyEvent.VK_RIGHT]||  keys[KeyEvent.VK_D];
		
	}
	//We are checking of true or false event here we get key pressed true
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
		
	}

	//here we get key in not pressed false
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
		
	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}

}
