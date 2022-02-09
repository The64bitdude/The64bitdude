// Author the64bitdude jan 15 2022
package MainC;

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
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Main.KeyBoard;
import Main.ToLine;

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
	Thread gameThread;
	
		// player
		int playerX = 100 + tileSize;
		int playerY = 100;
		int playerSpeed = 4;
		Image playerSprite;
		String playerName = "";
		String p1message = "";
		String p1messageOut = "t";
		
		// player2
		int player2X = 100;
		int player2Y = 100;
		String player2Name = "";
		int playerSpeed2 = 4;
		String p2message = "";
		
	ObjectOutputStream dos;
	ObjectInputStream dis;
	public Screen() {
		playerName = JOptionPane.showInputDialog(this,"username");
		String ip = "";
		try {
			ip = JOptionPane.showInputDialog(this,"Ip(if on same system your ip is posted)",Inet4Address.getLocalHost().getHostAddress());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int port = (int)ToLine.SToDouble(JOptionPane.showInputDialog(this,"Port"));
		try {
			Socket s = new Socket(ip,port);
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
			// update info
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
		}
		if(keyB.upPressed == true) {
			playerY -= playerSpeed;
		}
		if(keyB.downPressed == true) {
			playerY += playerSpeed;
		}
		if(keyB.leftPressed == true) {
			playerX -= playerSpeed;
		}
		if(keyB.rightPressed == true) {
			playerX += playerSpeed;
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
		g2.drawString(playerName,playerX,playerY-15);
		g2.fillRect(playerX,playerY,tileSize,tileSize);
		g2.drawString(p1message,playerX,playerY+tileSize+15);
				
	}
	public void player2(Graphics2D g2) {
		//player2
		
		g2.setColor(Color.green);
		g2.drawString(player2Name,player2X,player2Y-15);
		g2.fillRect(player2X,player2Y,tileSize,tileSize);
		g2.drawString(p2message,player2X,player2Y+tileSize+15);
		
	}
}
