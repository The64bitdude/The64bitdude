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
import java.util.ArrayList;
import java.util.List;

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
	
	long ping = 0;
	
	KeyBoard keyB = new KeyBoard();
	Mouse mos = new Mouse();
	Thread gameThread;
	
	// player
	collider p1Col = new collider(100,100,tileSize,tileSize);
	Image playerSprite;
	String playerName = "";
	String p1message = "";
	String p1messageOut = "";
	
	// player2
	collider p2Col = new collider(100+tileSize,100,tileSize,tileSize);
	int player2X = 100 + tileSize;
	int player2Y = 100;
	int playerSpeed2 = 4;
	String player2Name = "";
	String p2message = "";
	double P1a = 0;
	
	//envorment
	collider ground = new collider(0,tileSize*11,tileSize*16,tileSize*4);
	
	//collider thing = new collider(tileSize*2,tileSize*9,tileSize*4,tileSize*2);
	//collider thing2 = new collider(tileSize*8,tileSize*10,tileSize*1,tileSize*1);
	collider bul = new collider(tileSize*4,tileSize*11-10,20,10);
	List<collider> test = new ArrayList<collider>();
	//camera
	Camera cam;
	public Screen() {
		playerName = JOptionPane.showInputDialog(this,"Server username");
		setSprites();
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyB);
		this.addMouseListener(mos);
		this.setFocusable(true);
	}
	
	public void setSprites() {
		try {
			playerSprite = ImageIO.read(new File("/Users/s214714/Desktop/IMG_2125.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		bul.setName("bal");
		bul.setaccelY(9.8/FPS);
        p1Col.setaccelY(9.8/FPS);
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
				
				/*for(int i = 0; i < boxesp.length;i++) {
					boxesp[i].addTime(1);
				}*/
				
				p1Col.addTime(1);
				bul.addTime(1);
				if((bul.velocityX < 1.0)&&(bul.velocityX > -1.0)){
					bul.velocityX = 0;
				}	else if(bul.velocityX != 0) {
					bul.velocityX -= bul.velocityX*0.025;
				}
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
	
	public void physics() {
		bul.gravity();
		p1Col.gravity();
		for(int i = 0;i<test.size();i++) {
			test.get(i).collideWith(p1Col);
			test.get(i).collideWith(bul);
		}
		ground.collideWith(bul);
		//thing.collideWith(bul);
		//thing2.collideWith(bul);
		ground.collideWith(p1Col);
		//thing.collideWith(p1Col);
		p1Col.collideWith(bul);
		//thing2.collideWith(p1Col);
		p2Col.collideWith(p1Col);
		bul.physicsMove();
		p1Col.physicsMove();
		
	}
	public void update() {
		 mousePresses();
		keypresses();
		physics();
		
	}
	public int stx;
	public int sty;
	public boolean ism = false;
	public void mousePresses() {
		if(mos.mousePressed == true) {
		stx = -cam.tx+mos.mouseX;
		sty = -cam.ty+mos.mouseY;
		ism = true;
		}
		if((mos.mousePressed == false)&&(ism == true)) {
			test.add(new collider(stx,sty,(-cam.tx+mos.mouseX)-stx,(-cam.ty+mos.mouseY)-sty));
			ism = false;
		}
	}
	public void keypresses() {
		
		if(keyB.reset == true) {
			p1Col.reset();
			bul.reset(tileSize*4,tileSize*11-10);
			test.clear();
		}
		if(keyB.upPressed == true) {
			p1Col.setVelocityY( -15);
		}
		if(keyB.downPressed == true) {
			p1Col.setVelocityY( 5);
		}
		if(!(keyB.upPressed == false ^ keyB.downPressed == false)) {
			p1Col.setVelocityY(0);
		}
		if(keyB.leftPressed == true) {
			p1Col.setVelocityX(-7);
		}
		if(keyB.rightPressed == true) {
			p1Col.setVelocityX(7);
		}
		if(!(keyB.leftPressed == false ^ keyB.rightPressed == false)) {
			p1Col.setVelocityX(0);
		}
		if(keyB.getMsg().length() > 0) {
			String in = keyB.getMsg().substring(1);
			p1message = in;
		}else {
			String in = keyB.getMsg();
			p1message = in;
		}
		if(keyB.enterPressed == true) {
			p1messageOut = p1message;
			keyB.resetMsg();
			p1message = p1messageOut;
		}
		if((keyB.space == true)) {
			if((p1Col.TopRight[0] <= bul.TopLeft[0]+20)&&(p1Col.TopRight[0]+20 >= bul.TopLeft[0])) {
			bul.setVelocityX(10);
			}else if((p1Col.TopLeft[0] >= bul.TopRight[0]-20)&&(p1Col.TopLeft[0]-20 <= bul.TopRight[0])) {
				bul.setVelocityX(-10);
			}
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		cam = new Camera(g2);
		g2.setColor(Color.white);
		cam.moveToMiddle(p1Col.pos[0], p1Col.pos[1], screenHeight, screenWidth);
		//fps
		cam.drawFollowedString("FPS:" + currentFPS,5, 15);
		
		cam.drawFollowedString("PING:" + Math.abs(p1Col.time),5,30);
		cam.drawFollowedString("test:" + Math.abs(p1Col.test),5,45);
		cam.drawFollowedString("accelY:" + Math.abs(p1Col.accelY),5,60);
		cam.drawFollowedString("Vx:" + bul.velocityX,5,75);
		cam.drawFollowedString("mouseX:" + mos.mouseX,5,90);
		cam.drawFollowedString("mouseY:" + mos.mouseY,5,105);
		cam.drawFollowedString("mouseClicked:" + mos.mousePressed,5,120);
		//player
		
		ground.draw(g2);
		//thing.draw(g2);
		//thing2.draw(g2);
		bul.draw(g2);
		for(int i = 0;i<test.size();i++) {
			test.get(i).draw(g2);
		}
		//g2.drawString(ground.isTouching(p1Col)[0]+"",ground.Width/2,ground.TopLeft[1]-30);
		
		
		//g2.drawImage(playerSprite,playerX,playerY-100,this);
		
		//g2.setColor(Color.black);
		
		//g2.fillRect(playerX, playerY-100, playerSprite.getWidth(this), tileSize*2);
		
		//g2.fillRect(playerX, playerY+playerSprite.getHeight(this)-tileSize+20-100, playerSprite.getWidth(this), tileSize-20);
		
		//boxes
		//boxes(g2);
		//player2
		player2(g2);
		
		//player1
		player1(g2);
		
		g2.dispose();
	}
	public void player1(Graphics2D g2) {
		//player1
		g2.setColor(Color.white);
		g2.drawString(playerName,p1Col.pos[0],p1Col.pos[1]-30);
		
		//g2.drawString(p1Col.isTouching(p2Col)[0]+"",playerX,playerY-30);
		//g2.drawString(p1Col.isTouching(p2Col)[1]+"",playerX-tileSize,playerY+(tileSize/2));
		//g2.drawString(p1Col.isTouching(p2Col)[2]+"",playerX,playerY+tileSize+30);
		//g2.drawString(p1Col.isTouching(p2Col)[3]+"",playerX+tileSize*2,playerY+(tileSize/2));
		
		p1Col.draw(g2);
		p1Col.drawString(p1message, 0, -15, g2);
				
	}
	public void player2(Graphics2D g2) {
		//player2
		
		g2.setColor(Color.green);
		g2.drawString(player2Name,player2X,player2Y-15);
		g2.fillRect(player2X,player2Y,tileSize,tileSize);
		g2.drawString(p2message,player2X,player2Y+tileSize+15);
		
	}
	/*public void boxes(Graphics2D g2) {
		
		for(int i = 0; i < boxesp.length;i++) {
			g2.fillRect(boxesp[i].pos[0],boxesp[i].pos[1],tileSize,tileSize);	
		}
		
	}*/
}
