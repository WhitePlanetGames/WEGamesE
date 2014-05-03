/**
 * 
 */
package ca.WEGames.BOT.level;

import java.util.Random;

/**
 * @author Catman3304
 *
 */
public class RandomLevel extends Level {
	
	Random random = new Random();
	
	/**
	 * @param width
	 * @param height
	 */
	public RandomLevel(int width, int height) {
		super(width, height);
	}
	
	public void generateLevel() {
		HeightMap map = new HeightMap(width, height, random.nextInt());
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < height; x++) {
				tiles[x + y * width] = map.map[x + y * width];
			}
		}
	}
}
