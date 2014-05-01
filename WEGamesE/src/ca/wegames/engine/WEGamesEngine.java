/**
 * 
 */
package ca.wegames.engine;

/**
 * @author Catman3304
 *
 */
public abstract class WEGamesEngine {

	private boolean running = false;
	
	protected final void start() {
		
	}
	
	public void run() {
		while(running) {
			
		}
	}
	
	protected final void show() {
		
	}
	
	protected abstract void init();
	protected abstract void tick();
	protected abstract void render();
}
