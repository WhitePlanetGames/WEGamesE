package ca.wegames.engine.graphics;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
	private static final long serialVersionUID = 1L;
	
	private int width, height;
	private JFrame frame;
	
	public Window(int width, int height) {
		this.width = width;
		this.height = height;
		create();
	}
	
	private void create() {
		Dimension size = new Dimension(width, height);
		setMinimumSize(size);
		setPreferredSize(size);
		frame = new JFrame();
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
