import java.awt.Graphics2D;

public class Camera {
	Graphics2D g2;
	int tx;
	int ty;
	int screenHeight;
	int screenWidth;
	public Camera(Graphics2D g) {
		g2 =g;
	}
	public void update(Graphics2D g) {
		g2 =g;
	}
	public void moveTo(int x, int y) {
		tx = x;
		ty = y;
		g2.translate(x, y);
	}
	public void moveToMiddle(int x, int y,int sH,int sW) {
		tx = (-x+(sW/2));
		ty = (-y+(sH/2));
		screenHeight = sH;
		screenWidth = sW;
		g2.translate(-x+(sW/2),-y+(sH/2));
	}
	public void move(int x, int y) {
		tx += x;
		ty += y;
		g2.translate(tx,ty);
	}
	public void drawFollowedString(String str,int x, int y) {
		g2.drawString(str,-tx+x,-ty+y);
	}
}
