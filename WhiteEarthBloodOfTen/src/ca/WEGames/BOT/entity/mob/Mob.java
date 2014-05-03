/**
 * 
 */
package ca.WEGames.BOT.entity.mob;

import ca.WEGames.BOT.entity.Entity;
import ca.WEGames.BOT.graphics.Sprite;

/**
 * @author Catman3304
 *
 */
public class Mob extends Entity {
	protected Sprite sprite;
	protected int dir = 0;
	
	public void move() {
	}
	
	public void tick() {
	}
	
	boolean collision() {
		return false;
	}
	
	public void render() {
	}
}
