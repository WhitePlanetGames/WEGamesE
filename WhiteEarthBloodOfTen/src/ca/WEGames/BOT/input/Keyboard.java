/**
 * 
 */
package ca.WEGames.BOT.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Catman3304
 *
 */
public class Keyboard implements KeyListener {
	
	private boolean[] keys = new boolean[65536];
	public boolean up, down, left, right, pickUp, drop, jump, inventory, stats;
	
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		pickUp = keys[KeyEvent.VK_P];
		drop = keys[KeyEvent.VK_O];
		jump = keys[KeyEvent.VK_SPACE];
		stats = keys[KeyEvent.VK_N];
	}
	
	/**
	 * 
	 */
	public Keyboard() {
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent e) {
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
