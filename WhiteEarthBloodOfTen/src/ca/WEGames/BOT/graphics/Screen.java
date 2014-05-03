/**
 * 
 */
package ca.WEGames.BOT.graphics;

import java.util.Random;

import ca.WEGames.BOT.level.tile.Tile;

/**
 * @author Catman3304
 *
 */
public class Screen {
	
	Random random = new Random();
	
	public int width, height;
	public int[] pixels;
	
	int MAP_SIZE = 128;
	int MAP_SIZE_MASK = MAP_SIZE - 1;
	int TILE_SIZE = 64;
	public int xOffset, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	/**
	 * @param width the width of the screen
	 */
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear() {
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++) {
				pixels[x + y * width] = 0xff000000;
			}
		}
	}
	
	public void renderTile(int xPos, int yPos, Tile tile) {
		xPos -= xOffset;
		yPos -= yOffset;
		for(int y = 0; y < tile.sprite.size; y++){
			int ya = y + yPos;
			for(int x = 0; x < tile.sprite.size; x++) {
				int xa = x + xPos;
				if(xa < -tile.sprite.size || xa >= width || ya < 0 || ya > width) break;
				if(xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.size];
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	/**
	 * @return the pixels
	 */
	public int[] getPixels() {
		return pixels;
	}
}
