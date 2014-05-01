/**
 * 
 */
package ca.wegames.engine.graphics;

/**
 * @author Catman3304
 *
 */
public class Screen {
	
	private int width, height;
	private int[] pixels;
	
	/**
	 * 
	 */
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear(int color) {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}
	
	public void clear() {
		clear(0);
	}
	
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
}
