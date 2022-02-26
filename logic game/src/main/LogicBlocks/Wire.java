package main.LogicBlocks;

import java.awt.Graphics2D;

public class Wire {
	public int wX,wY;
	public int x,y;
	public boolean out;
	public Wire(int px,int py) {
		x=px;
		y=py;
	}
	public void draw(Graphics2D g2) {
		g2.drawLine(x, y, wX, wY);
	}
	public void setPos(int X, int Y) {
		wX=X;
		wY=Y;
	}
}
