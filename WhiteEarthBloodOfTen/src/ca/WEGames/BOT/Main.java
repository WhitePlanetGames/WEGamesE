/**
 * 
 */
package ca.WEGames.BOT;

import java.awt.*;
import java.awt.image.*;

import javax.swing.JFrame;

import ca.WEGames.BOT.graphics.Screen;
import ca.WEGames.BOT.input.Keyboard;
import ca.WEGames.BOT.level.Level;

/**
 * Blood of Ten
 * @author Catman3304
 */
public class Main extends Canvas implements Runnable {
	private static final long serialVersionUID = 8520469459656981941L;
	
	public static int width = 1080, height = width / 16 * 9;
	
	Thread thread;
	boolean running = false;
	
	Screen screen;
	JFrame frame;
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	public int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	Level level;
	Keyboard key;
	
	/**
	 * 
	 */
	public Main() {
		frame = new JFrame();
		screen = new Screen(width, height);
		key = new Keyboard();
		level = new Level(256, 256);
		
		requestFocus();
		addKeyListener(key);
	}
	
	int frames = 0;
	int ticks = 0;
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double ns = 1000000000.0 / 30.0;
		double delta = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("Ticks: " + ticks + " | Frames: " + frames);
				ticks = 0;
				frames = 0;
			}
		}
	}
	
	synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	int speed = 4;
	
	private void tick() {
		key.tick();
		if(key.up)y-=speed;
		if(key.down)y+=speed;
		if(key.left)x-=speed;
		if(key.right)x+=speed;
	}
	int x = 0, y = 0;
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		level.render(width, height, screen);
		
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.getPixels()[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();
		bs.show();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.frame.add(main);
		main.frame.pack();
		main.frame.setSize(width, height);
		main.frame.setLocationRelativeTo(null);
		main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.frame.setVisible(true);
		
		main.start();
	}
}
