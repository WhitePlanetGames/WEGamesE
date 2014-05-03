package ca.WEGames.BOT.level;

import java.util.Random;

import ca.WEGames.BOT.graphics.Screen;
import ca.WEGames.BOT.level.tile.Tile;

public class Level {
	
	int width, height;
	int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		LoadLevel(path);
	}
	
	public void tick() {
		
	}
	
	public void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = (xScroll) >> 4;
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = (yScroll) >> 4;
		int y1 = (yScroll + screen.height) >> 4;
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);;
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width-1 || y > height-1) return Tile.gabro;
		if(tiles[x + y * width] > 0xdf) return Tile.marble;
		if(tiles[x + y * width] > 0xbf) return Tile.nativeGold;
		return Tile.gabro;
	}
	
	private void LoadLevel(String path) {
		
	}
	Random random = new Random();
	public void generateLevel() {
		HeightMap map = new HeightMap(width, height, random.nextInt());
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < height; x++) {
				tiles[x + y * width] = map.map[x + y * width];
			}
		}
	}
}
