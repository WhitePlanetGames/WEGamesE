/**
 * 
 */
package ca.WEGames.BOT.entity;

import java.util.Random;

import ca.WEGames.BOT.graphics.Screen;
import ca.WEGames.BOT.level.Level;

/**
 * @author Catman3304
 *
 */
public class Entity {
	
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	/**
	 * 
	 */
	public Entity() {
	}
	
	public void tick() {
	}
	
	public void render(Screen screen) {
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}
