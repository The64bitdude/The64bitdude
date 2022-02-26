package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Graphics3D {
	public Camera C;
	Graphics g;
	int Width = 0;
	int Height = 0;
	double sens = 90.000;
	public List<Point> points;
	public Graphics3D(Graphics G) {
		points = new ArrayList<Point>();
    g=G;
	}
	public Graphics3D(Camera c,Graphics G){
		g=G;
		C=c;
	}
	public void setSpeed(double speed) {
		sens = speed;
	}
	public void setScreenSize(int width,int height) {
		Width = width;
		Height = height;
	}
	public void setCamera(Camera c, double cameraH, double cameraV) {
		C=c;
		C.setRotation(cameraH, cameraV);
		points.add(c);
	}
	public int[] calcPoint(Point p) {
		points.add(p);
		double a = (p.X-C.X);
		double o = (p.Z-C.Z);
		double ay =(p.Y-C.Y);
		double x = 0;
		a = (a)+((o)*Math.sin(C.v*Math.PI/180));
		ay = (ay)+((o)*Math.sin(C.h*Math.PI/180));
		o = o +(-o*Math.cos(C.v*Math.PI/180))+(-o*Math.cos(C.h*Math.PI/180));
		if(o > 0) {
		x = ((a/(o)));
		
		}else {
			x = ((a+C.X/(o+C.Z))/(Math.PI/2));
		
		}
		double xpos = ((x * (Width))+(Width/2));
		if(o > 0) {
			x = ((ay/(o)));
			
			}else {
				x = ((ay+C.Y/(o+C.Z))/(Math.PI/2));
			
			}
			double ypos = ((x * (Width))+(Height/2));
		return new int[] {(int) xpos,(int) ypos};
	}
	public void drawPoint(Point p) {
		int[] t = calcPoint(p);
		g.drawLine(t[0], t[1], t[0], t[1]);
	}
	public void drawLine(Point p,Point b) {
		int[] t = calcPoint(p);
		int[] d = calcPoint(b);
		g.drawLine(t[0], t[1], d[0], d[1]);
	}
	public void rainbow(Point p,int focus) {
		focus *= 2;
		drawPoint(p);
		drawPoint(new Point(p.X,p.Y-255,p.Z));
		drawPoint(new Point(p.X-255,p.Y,p.Z));
		drawPoint(new Point(p.X+255,p.Y,p.Z));
		for(int i = 0;i<=focus;i+=1) {
			double angle = 90.00/focus;
			double ang = angle*i;
			double ang2 = angle*(i-1);
			drawLine(new Point((int)(p.X+(255*Math.cos(ang*Math.PI/180))),(int)(p.Y-(255*Math.sin(ang*Math.PI/180))),p.Z),new Point((int)(p.X+(255*Math.cos(ang2*Math.PI/180))),(int)(p.Y-(255*Math.sin(ang2*Math.PI/180))),p.Z));
			
			drawLine(new Point((int)(p.X-(255*Math.cos(ang*Math.PI/180))),(int)(p.Y-(255*Math.sin(ang*Math.PI/180))),p.Z),new Point((int)(p.X-(255*Math.cos(ang2*Math.PI/180))),(int)(p.Y-(255*Math.sin(ang2*Math.PI/180))),p.Z));
			
		}
		for(int k = 1;k<=focus*1.00;k++) {
			int x = (int) (p.X);
			int y = (int) (p.Y);
			int z= (int) (p.Z);
			int w = (int) (255);
		for(int i = 0;i<=focus;i+=1) {
			double angle = 90.00/focus;
			double ang = angle*i;
			double ang2 = angle*(i-1);
			drawLine(new Point((int)(x),(int)(y-(w*Math.sin(ang*Math.PI/180))),(int) (z+(w*Math.cos(ang*Math.PI/180)))),new Point((int)(x),(int)(y-(w*Math.sin(ang2*Math.PI/180))),(int) (z+(w*Math.cos(ang2*Math.PI/180)))));
			drawLine(new Point((int)(x),(int)(y-(w*Math.sin(ang*Math.PI/180))),(int) (z-(w*Math.cos(ang*Math.PI/180)))),new Point((int)(x),(int)(y-(w*Math.sin(ang2*Math.PI/180))),(int) (z-(w*Math.cos(ang2*Math.PI/180)))));
			
		}
		for(int i = 0;i<=focus;i+=1) {
			double angle = 90.00/focus;
			double ang = angle*i;
			double ang2 = angle*(i-1);
			drawLine(new Point((int)(x+(w*Math.cos(ang*Math.PI/180))),y,(int) (z+(w*Math.sin(ang*Math.PI/180)))),new Point((int)(x+(w*Math.cos(ang2*Math.PI/180))),y,(int) (z+(w*Math.sin(ang2*Math.PI/180)))));
			drawLine(new Point((int)(x+(w*Math.cos(ang*Math.PI/180))),y,(int) (z-(w*Math.sin(ang*Math.PI/180)))),new Point((int)(x+(w*Math.cos(ang2*Math.PI/180))),y,(int) (z-(w*Math.sin(ang2*Math.PI/180)))));
			drawLine(new Point((int)(x-(w*Math.cos(ang*Math.PI/180))),y,(int) (z+(w*Math.sin(ang*Math.PI/180)))),new Point((int)(x-(w*Math.cos(ang2*Math.PI/180))),y,(int) (z+(w*Math.sin(ang2*Math.PI/180)))));
			drawLine(new Point((int)(x-(w*Math.cos(ang*Math.PI/180))),y,(int) (z-(w*Math.sin(ang*Math.PI/180)))),new Point((int)(x-(w*Math.cos(ang2*Math.PI/180))),y,(int) (z-(w*Math.sin(ang2*Math.PI/180)))));
			
		}
		}
	}
	public void mtv(){
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 200, 200);
		g.setColor(Color.WHITE);
		g.fillRect(0, 200, 200, 200);
		g.setColor(Color.GRAY);
		g.fillRect(0, 400, 200, 200);
		g.setColor(Color.GREEN);
		int i = 0;
		for(Point p:points) {
		if(i == 0) {
			g.setColor(Color.GREEN);
		g.drawLine(((p.X-4)/4)+100, ((-p.Z-4)/4)+100, ((p.X+4)/4)+100, ((-p.Z+4)/4)+100);
		g.drawLine(((p.X)/4)+100, ((-p.Z)/4)+100, (int)((p.X+(-100*Math.sin(C.v*Math.PI/180)))/4)+100, (int)((-p.Z+(100*Math.cos(C.v*Math.PI/180)))/4)+100);
		g.setColor(Color.BLUE);
		g.fillRect(((p.X-4)/4)+100, ((p.Y-4)/4)+300, 4, 4);
		g.setColor(Color.RED);
		g.fillRect(((p.Z-4)/4)+100, ((p.Y-4)/4)+500, 4, 4);
		}else {
			g.setColor(Color.GREEN);
			g.drawLine(((p.X-4)/4)+100, ((-p.Z-4)/4)+200, ((p.X+4)/4)+100, ((-p.Z+4)/4)+200);
			g.setColor(Color.BLUE);
			g.fillRect(((p.X-4)/4)+100, ((p.Y-4)/4)+300, 4, 4);
			g.setColor(Color.RED);
			g.fillRect(((p.Z-4)/4)+100, ((p.Y-4)/4)+500, 4, 4);
		}
		i++;
		}
		
		g.setColor(c);
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
		//if(a.Z + C.Z > 0) {
		g.fillPolygon(new int[]{ax,bx,bx,ax}, new int[]{ay,ay,by,by}, 4);
		//}
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
		//if((b.Z + C.Z > 0)){
		g.drawLine(bax, bay, bbx, bay);
		//bottom
		g.drawLine(bax, bby,bbx, bby);
		//left
		g.drawLine(bax, bay, bax, bby);
		//right
		g.drawLine(bbx, bay, bbx, bby);
		//if((a.Z + C.Z > ((a.Z-b.Z)/2))){
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
		//}
		//}
		
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
		//if((b.Z + C.Z > 0)){
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
		
		//if((a.Z + C.Z > ((a.Z-b.Z)/2))){
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
		//}
		//}
		g.setColor(c);
		}
		
	}
	
	
}
