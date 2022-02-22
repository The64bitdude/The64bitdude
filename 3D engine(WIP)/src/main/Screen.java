package main;
// Author the64bitdude jan 15 2022


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable{

	final int originalTileSize = 16;
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	
	int FPS = 60;
	
	int currentFPS = 0;
	
	
	
	
	Thread gameThread;
	
	keyPresses keys = new keyPresses();
	
	int cameraX = 0;
	int cameraY = 0;
	int cameraZ = 0;
	
	public Screen() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.addKeyListener(keys);
	}
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		
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
				currentFPS = 120-drawCount;
				drawCount = 0;
				timer = 0;
			}
			
		}
		
	}
	public void update() {
		keyPresses();
	}
	public void keyPresses() {
		if(keys.forward == true) {
			cameraZ+=5;
		}
		if(keys.backward == true) {
			cameraZ-=5;
		}
		if(keys.up == true) {
			cameraY+=5;
		}
		if(keys.down == true) {
			cameraY-=5;
		}
		if(keys.right == true) {
			cameraX+=5;
		}
		if(keys.left == true) {
			cameraX-=5;
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawString(currentFPS+"", 15, 15);
		Graphics3D g3 = new Graphics3D(g);
		g3.setScreenSize(screenWidth, screenHeight);
	    g3.setCamera(new Camera(cameraX,cameraY,cameraZ));
	    g.setColor(Color.GREEN);
	    g3.fillCube(new Point(-tileSize*15,tileSize*6,tileSize*7),tileSize*30);
		g.setColor(Color.BLUE);
	    g3.fillCube(new Point(-tileSize,-tileSize,tileSize*2),tileSize*2);
	    g3.drawCube(new Point(tileSize,tileSize,tileSize*2),tileSize*2);
	    g3.fillSquare(new Point(-tileSize,tileSize,tileSize*4),tileSize*2);
	    g3.drawRectangle(new Point(tileSize,-tileSize,tileSize*2),tileSize*4,tileSize*2,tileSize*2);
		g.dispose();
	}
	
}
