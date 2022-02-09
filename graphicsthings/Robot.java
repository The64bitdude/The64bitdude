package graphicsthings;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class Robot extends Canvas
{
   public Robot()    //constructor method - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);   	
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString("Robot LAB ", 35, 35 );

      head(window);
      upperBody(window);
      lowerBody(window);
      
   }
   public void triangle(int xa,int ya,int ha, int wa,Graphics window)
   {
	window.drawLine(xa,ya,(wa/2)+xa,ha + ya);
	window.drawLine(xa,ya,xa + wa,ya);
	window.drawLine(xa+wa,ya,(wa/2)+xa,ha + ya);
   }

   public void head( Graphics window )
   {
      window.setColor(Color.GRAY);

      window.fillRect(300, 100, 200, 100);
    
      window.setColor(Color.RED);
      window.fillOval(350,100,100,100);
      window.setColor(Color.GRAY);
window.fillOval(350,100,50,50);
window.fillOval(350,150,50,50);
window.fillOval(400,150,50,50);
window.fillOval(400,100,50,50);

		//add more code here
				
   }

   public void upperBody( Graphics window )
   {
	   window.setColor(Color.RED);

	   window.fillRect(300, 200, 200, 500);
   }

   public void lowerBody( Graphics window )
   {

		//add more code here
	   window.setColor(Color.GRAY);
	   triangle(300,200,100,200,window);

   }
}