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
	double cameraH = 0;
	double cameraV = 0;
	int colorframeR = 255;
	int colorframeG = 0;
	int colorframeB = 0;
	
	public Screen() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.addKeyListener(keys);
		this.addMouseMotionListener(keys);
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
		cameraV = keys.MouseX*180/screenWidth+90;
		cameraH = keys.MouseY*180/screenHeight+90;
		/*if(keys.lU) {
			if(cameraH > -360) {
			cameraH-=1;
			}
		}
		if(keys.lD) {
			if(cameraH < 360) {
			cameraH+=1;
			}
		}
		if(keys.lR) {
			if(cameraV > -360) {
			cameraV-=1;
			}
		}
		if(keys.lL) {
			if(cameraV < 360) {
			cameraV+=1;
			}
		}*/
		if(keys.forward) {	
			cameraZ-=(5*Math.cos((cameraV)*Math.PI/180));
			cameraX-=(5*Math.sin((cameraV)*Math.PI/180));
		}
		if(keys.backward) {
			cameraZ+=(5*Math.cos((cameraV)*Math.PI/180));
			cameraX+=(5*Math.sin((cameraV)*Math.PI/180));
		}
		if(keys.up) {
			cameraY+=5;
		}
		if(keys.down) {
			cameraY-=5;
		}
		if(keys.right) {
			cameraZ+=(5*Math.sin((cameraV)*Math.PI/180));
			cameraX-=(5*Math.cos((cameraV)*Math.PI/180));
		}
		if(keys.left) {
			cameraZ-=(5*Math.sin((cameraV)*Math.PI/180));
			cameraX+=(5*Math.cos((cameraV)*Math.PI/180));
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawString(currentFPS+"", 15, 15);
		g.drawString(cameraV+"", 15, 30);
		Graphics3D g3 = new Graphics3D(g);
		g3.setSpeed(90);
		g3.setScreenSize(screenWidth, screenHeight);
	    g3.setCamera(new Camera(cameraX,cameraY,cameraZ),cameraH,cameraV);
	    g.setColor(Color.GREEN);
	    g3.fillCube(new Point(-tileSize*15,tileSize*6,tileSize*7),tileSize*30);
	    g3.rainbow(new Point(-tileSize*2,-tileSize*6,tileSize*8),10);
		g.setColor(new Color(colorframeR,colorframeG,colorframeB));
		g3.fillSquare(new Point(colorframeR,colorframeG,colorframeB),100);
	    g3.fillCube(new Point(-tileSize,-tileSize,tileSize*2),tileSize*2);
	    g3.drawCube(new Point(tileSize,tileSize,tileSize*2),tileSize*2);
	    g3.fillSquare(new Point(-tileSize,tileSize,tileSize*4),tileSize*2);
	    g3.drawRectangle(new Point(tileSize,-tileSize,tileSize*2),tileSize*4,tileSize*2,tileSize*2);
	    if(colorframeR > 0) {
	    	colorframeR--;
	    	colorframeG++;
	    }else if(colorframeG >= 0) {
	    	colorframeG--;
	    	colorframeB++;
	    }
	    if(colorframeB >= 255) {
	    	
	    	colorframeR = 255;
	    			colorframeB = 0;
	    			
	    }
	    g3.mtv();
	    g.dispose();
	}
	
}
