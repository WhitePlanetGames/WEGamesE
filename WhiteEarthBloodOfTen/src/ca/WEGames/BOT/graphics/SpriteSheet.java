/**
 * 
 */
package ca.WEGames.BOT.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Catman3304
 *
 */
public class SpriteSheet {
	
	String path;
	final int size;
	int[] pixels;
	
	public static SpriteSheet sheet = new SpriteSheet("/spriteSheet.png", 128);
	
	/**
	 * 
	 */
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.size = size;
		pixels = new int[size * size];
		load();
	}
	
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
