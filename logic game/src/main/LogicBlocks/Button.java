package main.LogicBlocks;

import java.awt.Color;
import java.awt.Graphics2D;

public class Button extends Block{
	public int wX,wY;
	public boolean state;
	public boolean isDragw;
	
	public Button(){
		super(0,0,50,50);
		state = false;
	}
	public Button(int X,int Y){
		super(X,Y,50,50);
		state = false;
	}
	
	public void wire(int x,int y) {
		wX=x;
		wY=y;
	}
	
}
