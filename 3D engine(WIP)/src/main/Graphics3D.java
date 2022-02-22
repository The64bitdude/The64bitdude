package main;

import java.awt.Color;
import java.awt.Graphics;

public class Graphics3D {
	public Camera C;
	Graphics g;
	int Width = 0;
	int Height = 0;
	public Graphics3D(Graphics G) {
g=G;
	}
	public Graphics3D(Camera c,Graphics G){
		g=G;
		C=c;
	}
	public void setScreenSize(int width,int height) {
		Width = width;
		Height = height;
	}
	public void setCamera(Camera c) {
		C=c;
	}
	public int[] calcPoint(Point p) {
		double a = p.X+C.X;
		double o = p.Z+C.Z;
		double ay = p.Y+C.Y;
		double x = 0;
		
		if(o > 0) {
		x = ((a/o)/(Math.PI/2));
		
		}else {
			x = -((a/o)/(Math.PI/2));
		
		}
		double xpos = ((x * (Width))+(Width/2));
		
		if(o > 0) {
			x = ((ay/o)/(Math.PI/2));
			
			}else {
				x = -((ay/o)/(Math.PI/2));
			
			}
			double ypos = ((x * (Width))+(Height/2));
		return new int[] {(int) xpos,(int) ypos};
	}
	
	public void drawSquare(Point a, Point b) {
		int[] ag = calcPoint(a);
		int ax = ag[0];
		int ay = ag[1];
		int[] bg = calcPoint(b);
		int bx = bg[0];
		int by = bg[1];
		
		//lines
		g.drawLine(ax, ay, bx, ay);
		g.drawLine(ax, by, bx, by);
		g.drawLine(ax, ay, ax, by);
		g.drawLine(bx, ay, bx, by);
	}
	public void fillSquare(Point a, int size) {
		fillSquare(a,new Point(a.X+size,a.Y+size,a.Z));
	}
	public void fillSquare(Point a, Point b) {
		int[] ag = calcPoint(a);
		int ax = ag[0];
		int ay = ag[1];
		int[] bg = calcPoint(b);
		int bx = bg[0];
		int by = bg[1];
		
		//lines
		if(a.Z + C.Z > 0) {
		g.fillPolygon(new int[]{ax,bx,bx,ax}, new int[]{ay,ay,by,by}, 4);
		}
	}
	public void fillCube(Point p, int size) {
		fillRectangle(p,new Point(p.X+size,p.Y+size,p.Z+size),false);
	}
	public void drawCube(Point p, int size) {
		drawRectangle(p,new Point(p.X+size,p.Y+size,p.Z+size));
	}
	public void drawCube(int x, int y ,int z, int size) {
		drawRectangle(new Point(x,y,z),new Point(x+size,y+size,z+size));
	}
	public void drawRectangle(Point p,int width, int  height, int depth) {
		drawRectangle(p,new Point(p.X+width,p.Y+height,p.Z+depth));
	}
	public void drawRectangle(Point a, Point b) {
		int[] aa = calcPoint(a);
		int aax = aa[0];
		int aay = aa[1];
		int[] ba = calcPoint(new Point(a.X,a.Y,b.Z));
		int bax = ba[0];
		int bay = ba[1];
		
		int[] bb = calcPoint(b);
		int bbx = bb[0];
		int bby = bb[1];
		int[] ab = calcPoint(new Point(b.X,b.Y,a.Z));
		int abx = ab[0];
		int aby = ab[1];
		if((b.Z + C.Z > 0)){
		g.drawLine(bax, bay, bbx, bay);
		//bottom
		g.drawLine(bax, bby,bbx, bby);
		//left
		g.drawLine(bax, bay, bax, bby);
		//right
		g.drawLine(bbx, bay, bbx, bby);
		if((a.Z + C.Z > ((a.Z-b.Z)/2))){
		//top
		g.drawLine(aax, aay, abx, aay);
		//bottom
		g.drawLine(aax, aby, abx, aby);
		//left
		g.drawLine(aax, aay, aax, aby);
		//right
		g.drawLine(abx, aay, abx, aby);
		
		
		g.drawLine(aax, aay, bax, bay);
		//bottom
		g.drawLine(aax, aby, bax, bby);
		g.drawLine(abx, aby, bbx, bby);
		g.drawLine(abx, aay, bbx, bay);
		}
		}
		
	}
	public void fillRectangle(Point a, Point b,boolean lines) {
		int[] aa = calcPoint(a);
		int aax = aa[0];
		int aay = aa[1];
		int[] ba = calcPoint(new Point(a.X,a.Y,b.Z));
		int bax = ba[0];
		int bay = ba[1];
		
		int[] bb = calcPoint(b);
		int bbx = bb[0];
		int bby = bb[1];
		int[] ab = calcPoint(new Point(b.X,b.Y,a.Z));
		int abx = ab[0];
		int aby = ab[1];
		//top
		if((b.Z + C.Z > 0)){
		Color c = g.getColor();
		g.fillPolygon(new int[]{bax,bbx,bax,bbx,bax,bax,bbx,bbx}, new int[]{bay,bay,bby,bby,bay,bby,bay,bby}, 8);
		
		if(lines) {
		g.setColor(Color.GREEN);
		
		
		g.drawLine(bax, bay, bbx, bay);
		//bottom
		g.drawLine(bax, bby,bbx, bby);
		//left
		g.drawLine(bax, bay, bax, bby);
		//right
		g.drawLine(bbx, bay, bbx, bby);
		}
		g.setColor(c);
		
		if((a.Z + C.Z > ((a.Z-b.Z)/2))){
		//top
			g.setColor(c);
		g.fillPolygon(new int[]{bax,bbx,abx,aax}, new int[]{bay,bay,aay,aay}, 4);
		//right
		g.fillPolygon(new int[]{abx,bbx,bbx,abx}, new int[]{aay,bay,bby,aby}, 4);
		//left
		g.fillPolygon(new int[]{aax,bax,bax,aax}, new int[]{aay,bay,bby,aby}, 4);
		//bottom
		g.fillPolygon(new int[]{bax,aax,abx,bbx}, new int[]{bby,aby,aby,bby}, 4);
		
		
		if(lines) {
		g.setColor(Color.GREEN);
		//topleft
		g.drawLine(aax, aay, bax, bay);
		//bottomleft
		g.drawLine(aax, aby, bax, bby);
		//bottomright
		g.drawLine(abx, aby, bbx, bby);
		//topright
		g.drawLine(abx, aay, bbx, bay);
		}
		g.setColor(c);
		g.fillPolygon(new int[]{aax,abx,aax,abx,aax,aax,abx,abx}, new int[]{aay,aay,aby,aby,aay,aby,aay,aby}, 8);
		if(lines) {
		g.setColor(Color.GREEN);
		
		g.drawLine(aax, aay, abx, aay);
		//bottom
		g.drawLine(aax, aby, abx, aby);
		//left
		g.drawLine(aax, aay, aax, aby);
		//right
		g.drawLine(abx, aay, abx, aby);
		}
		}
		g.setColor(c);
		}
		
	}
	
	
}
