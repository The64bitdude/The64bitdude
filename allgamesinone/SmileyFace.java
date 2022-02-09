package allgamesinone;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.util.*;
public class SmileyFace extends Canvas
{
   public SmileyFace()    //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
	   int e = 0;
	   while(e != -1) {
	   Scanner a = new Scanner(System.in);
	   System.out.println("yin yang 1 face 0 or -1 stop");
	   e = a.nextInt();
	   if(e == 1) {
      yinYang(window);
	   }
	   else if(e == 0) {
		   smileyFace(window);
	   }
	   }
   }

   public void smileyFace( Graphics window )
   {
      window.setColor(Color.BLUE);
      window.drawString("SMILEY FACE LAB ", 35, 35);

      window.setColor(Color.WHITE);
      window.fillRect(0,0,800,600);
      window.setColor(Color.YELLOW);
      window.fillOval( 210, 100, 400, 400 );
      window.setColor(Color.WHITE);
      window.fillOval(265, 175, 100, 100 );
      window.fillOval( 465, 175, 100, 100 );
      window.setColor(Color.BLACK);
      window.fillOval(265, 175, 50, 50 );
      window.fillOval( 465, 175, 50, 50 );
      window.setColor(Color.RED);
      window.fillArc( 420, 330, 100, 100,-180,235 );
      window.setColor(Color.YELLOW);
      window.fillArc( 315, 200, 200, 200,-180,180 );
      window.setColor(Color.BLACK);
      window.drawArc( 315, 200, 200, 200,-180,180 );

		//add more code here


   }
   public void yinYang( Graphics window )
   {
      window.setColor(Color.BLUE);
      window.drawString("SMILEY FACE LAB ", 35, 35);
      window.setColor(Color.RED);
      window.fillRect(0,0,800,600);
      window.setColor(Color.WHITE);
      window.fillArc( 110, 100, 400, 400,90,180 );
      window.setColor(Color.BLACK);
      window.fillArc( 110, 100, 400, 400,90,-180 );
      window.setColor(Color.WHITE);
      window.fillOval( 210, 100, 200, 200 );
      window.setColor(Color.BLACK);
      window.fillOval(210, 300, 200, 200 );
      window.setColor(Color.BLACK);
      window.fillOval( 285, 175, 50, 50 );
      window.setColor(Color.WHITE);
      window.fillOval(285, 375, 50, 50 );

		//add more code here


   }
}