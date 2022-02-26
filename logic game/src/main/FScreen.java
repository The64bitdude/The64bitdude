package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.LogicBlocks.*;

public class FScreen extends JPanel implements Runnable{
	final int originalTileSize = 16;
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	
	Thread gameThread;
	
	int FPS = 60;
	
	int currentFPS = 0;
	AListener input = new AListener();
	List<Block> comps;
	AND test = new AND();
	Button btn = new Button();
	Button btn5 = new Button(50,400);
	Button btn4 = new Button(0,400);
	Button btn2 = new Button(0,50);
	Input btn3 = new Input(500,50);
	
	public void run() {
		comps = new ArrayList<Block>();
		comps.add(test);
		comps.add(btn);
		comps.add(btn2);
		comps.add(btn3);
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >=1) {
				
				
				
				
				
			update();
			//draw new frame
			repaint();
			
			delta--;
			drawCount++;
			}
			if(timer >= 1000000000) {
				currentFPS = drawCount;
				drawCount = 0;
				timer = 0;
			}
			
		}
		
	}
	public void update() {
		calcs();
		inputs();
	}
	public void calcs() {
		for(int i = 0; i < comps.size();i++) {
			comps.get(i).index = i;
		}
	}
	public void inputs() {
		for(int i = 0; i < comps.size();i++) {
			comps.get(i).getSelected(input);
		}
		
	}
public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.drawString(currentFPS + "", 15, 15);
		g2.drawString(input.selectedBlock + "", 15, 30);
		for(int i = 0;i<comps.size();i++) {
			comps.get(i).draw(g2);
		}
		
		g2.dispose();
}
	public FScreen() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.addKeyListener(input);
		this.addMouseListener(input);
		this.addMouseMotionListener(input);
	}
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
}
