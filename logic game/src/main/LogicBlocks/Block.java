package main.LogicBlocks;

import java.awt.Color;
import java.awt.Graphics2D;

import main.AListener;

public class Block {
	public int x;
	public int y;
	public int w;
	public int h;
	public boolean selected = false;
	public int index;
	public int cmX;
	public int cmY;
	public Block(int X,int Y,int W,int H) {
		x=X;
		y=Y;
		w=W;
		h=H;
	}
	public void getSelected(AListener e) {
		if((e.md)&&(e.mouseX>x)&&(e.mouseX<x+w)&&(e.mouseY>y)&&(e.mouseY<y+h)) {
			if(e.selectedBlock == -1) {
			selected = true;
			e.selectedBlock = index;
			}
		}
		if(!e.md) {
			e.selectedBlock = -1;
			selected = false;
		}
		if(e.md) {
			if(e.selectedBlock == index) {
				selected = true;
				setPos(e.mouseX-w/2,e.mouseY-h/2);
			}
		}
	}
	public void setPos(int X,int Y) {
		x=X;
		y=Y;
		cmX = x+(w/2);
		cmY = y+(h/2);
	}
	public void setSize(int W,int H) {
		w = W;
		h = H;
	}
	public void draw(Graphics2D g2) {
		if(selected) {
			g2.setColor(Color.GREEN);
		}else {
			g2.setColor(Color.RED);
		}
		g2.fillRect(x, y, w,h);
		
	}
}
