package ca.WEGames.white_earth.engine;

import java.awt.Canvas;

import ca.WEGames.white_earth.engine.entity.Entity;

public class WEGameE extends Canvas implements Tickable {
	private static final long serialVersionUID = 1L;
	
	Entity[] entity = new Entity[1000];
	
	void genEntity() {
		for(int i = 0; i < entity.length; i++) {
			entity[i] = new Entity("player", 32, 64);
		}
	}
	
	public WEGameE() {
		genEntity();
	}
	
	public void tick() {
		for(int i = 0; i < entity.length; i++) {
			entity[i].tick();
		}
	}
}
