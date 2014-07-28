package com.FlawlessGecko.dungeon.tiles;

import com.FlawlessGecko.dungeon.graphics.Screen;
import com.FlawlessGecko.dungeon.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);

	}

	public void render(int x, int y, Screen screen) {
		//do render  stuff
		screen.renderTile(x, y, this);
		
	}
}
