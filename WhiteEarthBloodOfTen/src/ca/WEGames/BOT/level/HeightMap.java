package ca.WEGames.BOT.level;

public class HeightMap extends Map {

	public HeightMap(int mapWidth, int mapHeight, long seed) {
		super(mapWidth, mapHeight, seed);
	}
	
	void translate() {
		try {
			for(int i = 0; i < noiseMap.length; i++) {
				map[i] = (int) (noiseMap[i] * 9); 
				if(map[i] >= 0xff) map[i] = 0xff;
			}
		} catch (Exception e) {
			e.getCause();
		}
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = map[i];
		}
		//save("saves/Save_1/HeightMap.png");
		//new Trees(mapWidth, mapHeight, this);
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = map[i];
		}
	}
	void greyscale() {
	}
}