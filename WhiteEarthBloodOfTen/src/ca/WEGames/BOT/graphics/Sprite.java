/**
 * 
 */
package ca.WEGames.BOT.graphics;

/**
 * @author Catman3304
 *
 */
public class Sprite {
	
	final int size;
	int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.sheet);
	public static Sprite gabro = new Sprite(16, 1, 0, SpriteSheet.sheet);
	public static Sprite marble = new Sprite(16, 6, 0, SpriteSheet.sheet);
	public static Sprite gold = new Sprite(16, 4, 0, SpriteSheet.sheet);
	public static Sprite brass = new Sprite(16, 4, 1, SpriteSheet.sheet);
	public static Sprite copper = new Sprite(16, 4, 2, SpriteSheet.sheet);
	public static Sprite iron = new Sprite(16, 5, 0, SpriteSheet.sheet);
	
	/**
	 * 
	 */
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.size = size;
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		pixels = new int[size * size];
		load();
	}
	
	private void load() {
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				pixels[x + y * size] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.size];
			}
		}
	}
}
