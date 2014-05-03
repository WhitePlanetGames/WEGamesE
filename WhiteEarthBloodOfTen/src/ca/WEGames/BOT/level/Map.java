/**
 * 
 */
package ca.WEGames.BOT.level;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Map {
	
	public int mapWidth, mapHeight;
	
	public BufferedImage image;
	public int[] pixels;
	
	public int[] map;
	public double[] noiseMap;
	
	long seed;
	
	double noise;
	
	public Map(int mapWidth, int mapHeight, long seed) {
		this.seed = seed;
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		image = new BufferedImage(mapWidth, mapHeight, BufferedImage.TYPE_INT_RGB); 
		map = new int[mapWidth * mapHeight];
		//load("/Save_1/HeightMap.png");
		randomGen();
	}
	
	void randomGen() {
		noiseMap = new double[mapWidth * mapHeight];
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		for(int y = 0; y < mapHeight; y++) {
			for(int x = 0; x < mapWidth; x++) {
				perlin(x, y);
				noiseMap[x + y * mapWidth] = noise;
				//System.out.println(noise);
			}
		}
		translate();
	}
	
	void translate() {
	}
	
	void greyscale() {
	}
	
	void save(String path) {
		try {
			ImageIO.write(image, "png", new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void load(String path) {
		try {
			URL url = Map.class.getResource(path);
			 BufferedImage image0 = ImageIO.read(url);
			pixels = image0.getRGB(0, 0, mapWidth, mapHeight, pixels, 0, mapWidth);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void perlin(int x, int y) {
		PerlinNoise octave0 = new PerlinNoise(seed, 10);
		PerlinNoise octave1 = new PerlinNoise((long)(10*Math.sqrt(seed)), 5);
		PerlinNoise octave2 = new PerlinNoise((long)Math.pow(seed, 2), 20);
		double noise = 12*octave0.getNoiseLevelAtPosition(x,y) + 6*octave1.getNoiseLevelAtPosition(x,y) + 24*octave2.getNoiseLevelAtPosition(x,y);
		this.noise = noise;
	}
}
