/**
 * 
 */
package ca.WEGames.BOT.level.tile;

import ca.WEGames.BOT.graphics.*;

/**
 * @author Catman3304
 *
 */
public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile gabro = new GabroTile(Sprite.gabro);
	public static Tile marble = new MarbleTile(Sprite.marble);
	public static Tile nativeGold = new GoldTile(Sprite.gold);
	
	/**
	 * @param sprite the sprite of the tile
	 */
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x<<4, y<<4, this);
	}
	
	public boolean solid() {
		return false;
	}
	
	public int price() {
		return 0;
	}
}
