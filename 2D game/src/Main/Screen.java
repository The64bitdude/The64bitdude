// Author the64bitdude jan 15 2022
package Main;

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
	
	double Ug = Math.abs(9.8/FPS);
	double grav = Math.abs(9.8/FPS);
	
	long ping = 0;
	
	KeyBoard keyB = new KeyBoard();
	Thread gameThread;
	
	// player
	collider p1Col = new collider(100,100,tileSize,tileSize);
	int playerX = 100;
	int playerY = 100;
	double velocityX = 0;
	double velocityY = 0;
	int playerSpeedX = 4;
	int playerSpeedY = 10;
	double gtime = 0;
	Image playerSprite;
	String playerName = "";
	String p1message = "";
	String p1messageOut = "";
	
	// player2
	collider p2Col = new collider(100,100,tileSize,tileSize);
	int player2X = 100 + tileSize;
	int player2Y = 100;
	int playerSpeed2 = 4;
	String player2Name = "";
	String p2message = "";
	double P1a = 0;
	
	//envorment
	collider ground = new collider(0,tileSize*11,tileSize*16,tileSize*2);
	collider thing = new collider(tileSize*2,tileSize*9,tileSize*4,tileSize*2);
	
	ObjectOutputStream dos;
	ObjectInputStream dis;
	public String ip = "";
	public int port =0;
	public Screen() {
		playerName = JOptionPane.showInputDialog(this,"Server username");
		try {
			ip = JOptionPane.showInputDialog(this,"your ip is",Inet4Address.getLocalHost().getHostAddress());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		port = (int)ToLine.SToDouble(JOptionPane.showInputDialog(this,"Port"));
		try {
			ServerSocket server = new ServerSocket(port);
			Socket s = server.accept();
			dos = new ObjectOutputStream(s.getOutputStream());
			dis = new ObjectInputStream(s.getInputStream());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dos.writeObject(playerName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			player2Name = (String) dis.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSprites();
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyB);
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
				
			gtime++;
			
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
	public void col(collider col,collider pcol) {
		if(col.isTouching(pcol)[0]) {
			gtime = 0;
			if((velocityY == 0)&&(col.TopLeft[1]+1 < pcol.BottomRight[1])) {
				velocityY = -5;	
			}else if((col.TopLeft[1]+1 < pcol.BottomRight[1])){
				velocityY = 0;
			}
			
		}
		if(col.isTouching(pcol)[2]) {
			if((velocityY == 0)&&(col.BottomLeft[1]-1 > pcol.BottomRight[1])) {
				velocityY = 5;	
			}else {
			velocityY = 0;
			}
		}
		if(col.isTouching(pcol)[3]&&(!col.isTouching(pcol)[1])) {
			if((velocityX == 0)&&(col.TopLeft[1]+1 < pcol.BottomRight[1])) {
				velocityX = 5;	
			}else if((col.TopLeft[1]+1 < pcol.BottomRight[1])){
			velocityX = 0;
			}
		}
		if(col.isTouching(pcol)[1]&&(!col.isTouching(pcol)[3])) {
			if((velocityX == 0)&&(col.TopLeft[1]+1 < pcol.BottomRight[1])) {
				velocityX = -5;	
			}else if((col.TopLeft[1]+1 < pcol.BottomRight[1])){
			velocityX = 0;
			}
		}
	}
	public void colliders() {
		col(ground,p1Col);
		col(thing,p1Col);
		col(p2Col,p1Col);
	
	}
	public void physics() {
		Ug = grav;
		colliders();
		playerY += Ug*gtime;
		playerY += velocityY;
		playerX += velocityX;
		
	}
	public void update() {
		try {
			sendTime();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			getTime();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			sendMyXandY();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			player2XandY();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sendMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			getMessage();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		keypresses();
		physics();
		
	}
	public void sendTime() throws IOException {
		dos.writeObject(System.currentTimeMillis());
	}
	public void getTime() throws ClassNotFoundException, IOException {
		ping = System.currentTimeMillis() - ((long)dis.readObject());
	}
	public void player2XandY() throws IOException, ClassNotFoundException {
		player2X = (int) dis.readObject();
		player2Y = (int) dis.readObject();
		p2Col.moveCol(player2X, player2Y);
	}
	public void getMessage() throws IOException, ClassNotFoundException {
		p2message = (String) dis.readObject();
	}
	public void sendMyXandY() throws IOException {
		dos.writeObject(playerX);
		dos.writeObject(playerY);
	}
	public void sendMessage() throws IOException {
		String out = p1messageOut;
		dos.writeObject(out);
	}
	public void keypresses() {
		
		if(keyB.reset == true) {
			playerY = 100;
			playerX = 100;
			velocityY =0;
			velocityX =0;
			gtime = 0;
		}
		if(keyB.upPressed == true) {
			velocityY = -5;
		}
		if(keyB.downPressed == true) {
			velocityY = 5;
		}
		if(!(keyB.upPressed == false ^ keyB.downPressed == false)) {
			velocityY = 0;
		}
		if(keyB.leftPressed == true) {
			velocityX = -5;
		}
		if(keyB.rightPressed == true) {
			velocityX = 5;
		}
		if(!(keyB.leftPressed == false ^ keyB.rightPressed == false)) {
			velocityX = 0;
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
		p1Col.moveCol(playerX, playerY);
	}
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.white);
		//fps
		g2.drawString("FPS:" + currentFPS,5,15);
		g2.drawString("PING:" + Math.abs(ping),5,30);
		//player
		
		g2.fillRect(tileSize*2,tileSize*9,tileSize*4,tileSize*2);
		g2.fillRect(0,tileSize*11,tileSize*16,tileSize*2);
		
		//g2.drawString(ground.isTouching(p1Col)[0]+"",ground.Width/2,ground.TopLeft[1]-30);
		
		
		//g2.drawImage(playerSprite,playerX,playerY-100,this);
		
		//g2.setColor(Color.black);
		
		//g2.fillRect(playerX, playerY-100, playerSprite.getWidth(this), tileSize*2);
		
		//g2.fillRect(playerX, playerY+playerSprite.getHeight(this)-tileSize+20-100, playerSprite.getWidth(this), tileSize-20);
		
		//player2
		player2(g2);
		
		//player1
		player1(g2);
		
		g2.dispose();
	}
	public void player1(Graphics2D g2) {
		//player1
		g2.setColor(Color.white);
		g2.drawString(playerName,playerX,playerY-30);
		
		//g2.drawString(p1Col.isTouching(p2Col)[0]+"",playerX,playerY-30);
		//g2.drawString(p1Col.isTouching(p2Col)[1]+"",playerX-tileSize,playerY+(tileSize/2));
		//g2.drawString(p1Col.isTouching(p2Col)[2]+"",playerX,playerY+tileSize+30);
		//g2.drawString(p1Col.isTouching(p2Col)[3]+"",playerX+tileSize*2,playerY+(tileSize/2));
		
		
		g2.fillRect(playerX,playerY,tileSize,tileSize);
		g2.drawString(p1message,playerX,playerY-15);
				
	}
	public void player2(Graphics2D g2) {
		//player2
		
		g2.setColor(Color.green);
		g2.drawString(player2Name,player2X,player2Y-15);
		g2.fillRect(player2X,player2Y,tileSize,tileSize);
		g2.drawString(p2message,player2X,player2Y+tileSize+15);
		
	}
}
