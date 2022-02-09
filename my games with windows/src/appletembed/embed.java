package appletembed;

import java.applet.*;
import java.awt.*;
import java.util.Scanner;

import cargame.drive;


public class embed extends Applet{
	public static String[] wcodes = {"/",".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	public static String[] icodes = {"-----",".----","..---","...---","....-",".....","-....","--...","---..","----."};
	
	
   public void paint(Graphics g){
      g.drawString("Welcome in Java Applet.",40,20);
      Scanner in = new Scanner(System.in);
      g.drawString("are you code or decoding",40,50);
			if((in.next()).equals("code")) {
				 g.drawString("put a dubble period at the end with a space to finish",40,20);
				 g.drawString("what want to code",40,60);
		String str = ToLine.tillenter(in);
		String[] codes = ToLine.arSum(wcodes,icodes);
		 g.drawString(ToLine.sToMorse(str,codes),40,80);
			}else {
				 g.drawString("put a dubble comma at the end with a space to finish",40,20);
				 g.drawString("what want to decode",40,100);
		String str = ToLine.tillenter2(in);
		String[] codes = ToLine.arSum(wcodes,icodes);
		g.drawString(ToLine.mToString(str,codes),40,120);
			}
   }
   
}