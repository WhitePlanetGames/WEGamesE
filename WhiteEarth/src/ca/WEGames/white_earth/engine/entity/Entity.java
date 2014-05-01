/**
 * 
 */
package ca.WEGames.white_earth.engine.entity;

import ca.WEGames.white_earth.engine.Renderable;
import ca.WEGames.white_earth.engine.Tickable;

/**
 * @author Catman3304
 *
 */
public class Entity implements Renderable, Tickable {
	
	String type;
	int xSize, ySize;
	int[] pixels;
	
	/**
	 * 
	 */
	public Entity(String type, int xSize, int ySize) {
		this.type = type;
		this.xSize = xSize;
		this.ySize = ySize;
	}
	
	/* (non-Javadoc)
	 * @see ca.WEGames.white_earth.engine.Tickable#tick()
	 */
	public void tick() {
		
		render();
	}
	
	/* (non-Javadoc)
	 * @see ca.WEGames.white_earth.engine.Renderable#render()
	 */
	public void render() {
		for(int y = 0; y < ySize; y++) {
			for(int x = 0; x < xSize; x++) {
				pixels[x + y * xSize] = 0xbebe;
			}
		}
	}

}
