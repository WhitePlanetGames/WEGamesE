/**
 * 
 */
package ca.WEGames.white_earth;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.image.*;

import javax.swing.JFrame;

import ca.WEGames.white_earth.engine.Renderable;
import ca.WEGames.white_earth.engine.Tickable;
import ca.WEGames.white_earth.engine.WEGameE;
import ca.WEGames.white_earth.engine.graphics.Color;

/**
 * @author Catman3304
 *
 */
public class Main extends WEGameE implements Runnable, Tickable, Renderable {
	private static final long serialVersionUID = 1L;
	
	int width = 1080, height = width / 16 * 9;
	
	Thread thread;
	boolean running = false;
	
	JFrame frame;
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	public int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	/**
	 * 
	 */
	public Main() {
		frame = new JFrame();
		Dimension dim = new Dimension(width, height);
		setMinimumSize(dim);
		setPreferredSize(dim);
		setMaximumSize(dim);
	}
	
	/**
	 * @param config
	 * Ask Cherno
	 */
	/*
	public Main(GraphicsConfiguration config) {
		super(config);
	}
	*/
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while(running) {
			tick();
			render();
		}
	}
	
	/* (non-Javadoc)
	 * @see ca.WEGames.white_earth.engine.Tickable#tick()
	 */
	public void tick() {
		
	}
	
	/* (non-Javadoc)
	 * @see ca.WEGames.white_earth.engine.Renderable#render()
	 */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.frame.add(main);
		main.frame.pack();
		main.frame.setResizable(false);
		main.frame.setLocationRelativeTo(null);
		main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.frame.setVisible(true);
	}
}
