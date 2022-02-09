package graphicsthings;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class BigHouse extends Canvas
{
   public BigHouse()  //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      bigHouse(window);
   }
   public void triangle(int xa,int ya,int ha, int wa,Graphics window)
   {
	window.drawLine(xa,ya,(wa/2)+xa,ha + ya);
	window.drawLine(xa,ya,xa + wa,ya);
	window.drawLine(xa+wa,ya,(wa/2)+xa,ha + ya);
   }

   public void bigHouse( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString( "BIG HOUSE ", 50, 50 );

      window.setColor(Color.BLUE);

      window.fillRect( 200, 200, 400, 400 );
      window.setColor(Color.red);
      triangle(200, 200, -200, 400,window);

   }
}