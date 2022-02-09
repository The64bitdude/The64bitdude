package cargame;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class drive extends JFrame implements KeyListener{
	public JPanel pnl = new JPanel();

	public void box(int x, int y,int w,int l,double angle,int hp,int wp, Graphics window)
	   {
		
	x = (int)(x + (wp * Math.cos(angle))+(hp * Math.sin(angle)));
	y = (int)(y + (wp * Math.sin(angle))-(hp * Math.cos(angle))); ;
			window.drawLine(x+(int)(l*Math.sin(angle)),y-(int)(l*Math.cos(angle)),x+(int)(l*Math.sin(angle))+(int)(w * Math.cos(angle)),y - (int)(l*Math.cos(angle))+(int)(w*Math.sin(angle)));
			//bottom
		//window.drawLine(x,y,x+(int)(w*Math.cos(angle)),y+(int)(w*Math.sin(angle)));
			//left side
			window.drawLine(x,y,x+(int)(l*Math.sin(angle)),y-(int)(l*Math.cos(angle)));
			window.drawLine(x,y,x-(int)(l*Math.sin(angle)),y+(int)(l*Math.cos(angle)));
			//right side

			window.drawLine(x-(int)(l*Math.sin(angle)),y+(int)(l*Math.cos(angle)),x-(int)(l*Math.sin(angle))+(int)(w * Math.cos(angle)),y + (int)(l*Math.cos(angle))+(int)(w*Math.sin(angle)));
			//top
			window.drawLine(x+(int)(l*Math.sin(angle))+(int)(w * Math.cos(angle)),y - (int)(l*Math.cos(angle))+(int)(w*Math.sin(angle)),x+(int)(w*Math.cos(angle)),y+(int)(w*Math.sin(angle)));
			window.drawLine(x-(int)(l*Math.sin(angle))+(int)(w * Math.cos(angle)),y + (int)(l*Math.cos(angle))+(int)(w*Math.sin(angle)),x+(int)(w*Math.cos(angle)),y+(int)(w*Math.sin(angle)));
		
	   }
	public int locx = 250;
	public int locy = 300;
	public int sizw = 100;
	public int sizl = 25;
	public int direction = 270;
	public int driving = 0;
	public boolean firing = false;
	public int turning = 0;
	public int speed = 10;
	public char up = 'w';
	public char down = 'a';
	public char left = 's';
	public char right = 'd';
	//player 2
	public int locx2 = 250;
	public int locy2 = 300;
	public int sizw2 = 100;
	public int sizl2 = 25;
	public int direction2 = 270;
	public int driving2 = 0;
	public boolean firing2 = false;
	public int turning2 = 0;
	public int speed2 = 10;
	public char up2 = 'w';
	public char down2 = 'a';
	public char left2 = 's';
	public char right2 = 'd';
	public drive(char w,char a, char s, char d,char pw,char pa, char ps, char pd) {
		super("drive");
		up = w;
		down = s;
		left = a;
		right = d;
		up2 = pw;
		down2 = ps;
		left2 = pa;
		right2 = pd;
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(pnl);
		this.addKeyListener(this);
		setVisible(true);
	} 
	public void player1(Graphics window) {
		box(locx,locy,sizw,sizl,(double)(direction *(Math.PI/180)),0,0,window);
		 box(locx,locy,sizw-75,sizl-20,(double)(direction *(Math.PI/180)),30,60,window);
		 box(locx,locy,sizw-75,sizl-20,(double)(direction *(Math.PI/180)),-30,60,window);
		 box(locx,locy,sizw-75,sizl-20,(double)(direction *(Math.PI/180)),-30,10,window);
		 box(locx,locy,sizw-75,sizl-20,(double)(direction *(Math.PI/180)),30,10,window);
		 box(locx,locy,sizw-72,sizl-4,(double)(direction *(Math.PI/180)),0,68,window);
		 box(locx,locy,sizw-72,sizl-22,(double)(direction *(Math.PI/180)),-19,85,window);
		 player2(window);
		 if(firing == true) {
			 box(locx,locy,10,sizl-20,(double)(direction *(Math.PI/180)),-19,110,window);
			 updateDelay(0.1);
			 box(locx,locy,10,sizl-20,(double)(direction *(Math.PI/180)),-19,135,window);
			 updateDelay(0.1);
			 box(locx,locy,10,sizl-20,(double)(direction *(Math.PI/180)),-19,165,window);
			 updateDelay(0.1);
			 box(locx,locy,50,25,(double)(direction *(Math.PI/180)),-19,200,window);
			 updateDelay(0.2);
			 firing = false;
			 setBackground(Color.WHITE);
		 }
		 if(driving == 1) {
				locx += speed * Math.cos(direction *(Math.PI/180));
				locy += speed * Math.sin(direction *(Math.PI/180));
				updateDelay(0.15);

			}
			if(driving == -1) {
				locx -= speed * Math.cos(direction *(Math.PI/180));
				locy -= speed * Math.sin(direction *(Math.PI/180));
				updateDelay(0.15);
			
			}
			if(turning == 1) {
				 direction -= 2;
				 updateDelay(0.15);
		

			}
			if(turning == -1) {
			 direction += 2;
			 updateDelay(0.15);
	
			}
	}
	public void player2(Graphics window) {
		box(locx2,locy2,sizw2,sizl2,(double)(direction2 *(Math.PI/180)),0,0,window);
		 box(locx2,locy2,sizw2-75,sizl2-20,(double)(direction2 *(Math.PI/180)),30,60,window);
		 box(locx2,locy2,sizw2-75,sizl2-20,(double)(direction2 *(Math.PI/180)),-30,60,window);
		 box(locx2,locy2,sizw2-75,sizl2-20,(double)(direction2 *(Math.PI/180)),-30,10,window);
		 box(locx2,locy2,sizw2-75,sizl2-20,(double)(direction2 *(Math.PI/180)),30,10,window);
		 box(locx2,locy2,sizw2-72,sizl2-4,(double)(direction2 *(Math.PI/180)),0,68,window);
		box(locx2,locy2,sizw2-72,sizl2-22,(double)(direction2 *(Math.PI/180)),-19,85,window);
		 if(firing2 == true) {
			 box(locx2,locy2,10,sizl2-20,(double)(direction2 *(Math.PI/180)),-19,110,window);
			 updateDelay(0.1);
			 box(locx2,locy2,10,sizl2-20,(double)(direction2 *(Math.PI/180)),-19,135,window);
			 updateDelay(0.1);
			 box(locx2,locy2,10,sizl2-20,(double)(direction2 *(Math.PI/180)),-19,165,window);
			 updateDelay(0.1);
			 box(locx2,locy2,50,25,(double)(direction2 *(Math.PI/180)),-19,200,window);
			 updateDelay(0.2);
			 firing2 = false;
		 }
		 if(driving2 == 1) {
				locx2 += speed2 * Math.cos(direction2 *(Math.PI/180));
				locy2 += speed2 * Math.sin(direction2 *(Math.PI/180));
				updateDelay(0.15);
			}
			if(driving2 == -1) {
				locx2 -= speed2 * Math.cos(direction2 *(Math.PI/180));
				locy2 -= speed2 * Math.sin(direction2 *(Math.PI/180));
				updateDelay(0.15);
			}
			if(turning2 == 1) {
				 direction2 -= 3;
				 updateDelay(0.15);

			}
			if(turning2 == -1) {
			 direction2 += 3;
			 updateDelay(0.15);
			}
	}
	public void paint( Graphics window)
	   {
		setBackground(Color.WHITE);
		box(400,0,100,100,0,0,0,window);
		box(400,400,100,100,0,0,0,window);
		player1(window);
		
		
	   }
	public void keyPressed(KeyEvent event) {
		
	}
	public void updateDelay(double seconds) {
		long tims = System.currentTimeMillis();
		int count = 0;
		long tbet = 0;
		while(tbet <= (seconds*1000)) {
		   tbet =  System.currentTimeMillis() - tims;
		}
	}
	public void keyTyped(KeyEvent event) {
		if(event.getKeyChar() == 'r') {
			locx = 250;
			locy = 300;
			sizw = 100;
			sizl = 25;
			direction = 270;
			driving = 0;
			//player 2
			locx2 = 250;
			locy2 = 300;
			sizw2 = 100;
			sizl2 = 25;
			direction2 = 270;
			driving2 = 0;
	
		}
		if(event.getKeyChar() == ' ') {
			firing = true;
	
		}
		if(event.getKeyChar() == 'c') {
			speed = 20;
		}
		if(event.getKeyChar() == 'v') {
			speed = 10;
		}
		if(event.getKeyChar() == up) {
			driving = 1;
			locx += speed * Math.cos(direction *(Math.PI/180));
			locy += speed * Math.sin(direction *(Math.PI/180));
		}
		else if(event.getKeyChar() == left) {
			
			turning = 1;
			    direction -= 3;
	

			

		}
		else if(event.getKeyChar() == down) {
			
			driving = -1;
			locx -= speed * Math.cos(direction *(Math.PI/180));
			locy -= speed * Math.sin(direction *(Math.PI/180));
		
		}
		else if(event.getKeyChar() ==right) {
			
		
			turning = -1;
			    direction += 3;
			
				

		}
		//player 2
		if(event.getKeyChar() == up2) {
			driving2 = 1;
			locx2 += speed2 * Math.cos(direction2 *(Math.PI/180));
			locy2 += speed2 * Math.sin(direction2 *(Math.PI/180));
			
	
		}
		else if(event.getKeyChar() == left2) {
			
			turning2 = 1;
			    direction2 -= 3;
			
				

			

		}
		else if(event.getKeyChar() == down2) {
			
			driving2 = -1;
			locx2 -= speed2 * Math.cos(direction2 *(Math.PI/180));
			locy2 -= speed2 * Math.sin(direction2 *(Math.PI/180));
	

		}
		else if(event.getKeyChar() ==right2) {
			
		
			turning2 = -1;
			    direction2 += 3;

		
		}
		if(event.getKeyChar() == 'o') {
			firing2 = true;
	
		}
		
	}
	public void keyReleased(KeyEvent event) {
		if(event.getKeyChar() == up) {
			driving = 0;

		}
		if(event.getKeyChar() == left) {
			turning = 0;
	
		}
		if(event.getKeyChar() == down) {
			driving = 0;

		}
		if(event.getKeyChar() == right) {
			turning = 0;
			
		}
		//player 2
		if(event.getKeyChar() == up2) {
			driving2 = 0;

		}
		if(event.getKeyChar() == left2) {
			turning2 = 0;
	
		}
		if(event.getKeyChar() == down2) {
			driving2 = 0;

		}
		if(event.getKeyChar() == right2) {
			turning2 = 0;
			
		} 
	}
	public static void main(String[] args) {
		drive gui = new drive('w','a','s','d','i','j','k','l');
	}
	
}