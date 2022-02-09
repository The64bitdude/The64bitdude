import java.awt.Graphics2D;

public class collider {
	public double velocityX = 0;
	public double velocityY = 0;
	public double accelY = 0;
	public double accelX = 0;
	public double time  = 0;
	public double timex  = 0;
	public int test = 0;
	public int[] pos = new int[2];
	public int[] TopLeft;
	public int[] TopRight;
	public int[] BottomLeft;
	public int[] BottomRight;
	public int Width;
	public int Height;
	public collider(int x,int y,int width, int height) {
		if(x + width < x) {
			x += width;
			width *=-1;
		}
		if(y + height < y) {
			y += height;
			height *=-1;
		}
		TopLeft = new int[] {x,y};
		TopRight = new int[] {x+width,y};
		BottomLeft = new int[] {x,y+height};
		BottomRight = new int[] {x+width,y+height};
		pos[0] = x;
		pos[1] = y;
		Width = width;
		Height = height;
	}
	public void moveCol(int x, int y) {
		TopLeft = new int[] {x,y};
		TopRight = new int[] {x+Width,y};
		BottomLeft = new int[] {x,y+Height};
		BottomRight = new int[] {x+Width,y+Height};
	}
	public void movePos(int x, int y) {
		pos[0] = x;
		pos[1] = y;
	}
	public void setVelocityX(double x) {
		velocityX = x;
	}
	public void setVelocityY(double y) {
		velocityY = y;
	}
	public void setaccelY(double y) {
		accelY = y;
	}
	public void setaccelX(double x) {
		accelX = x;
	}
	public void addVelocity(double velocityX2, double d) {
		velocityX += velocityX2;
		velocityY += d;
	}
	public void collideWith(collider thiscol,collider[] col) {
		for(int i = 0;i < col.length;i++) {
			col[i].collideWith(thiscol);
		}
	}
	public void collideWith(collider[] thiscol,collider col) {
		for(int i = 0;i < thiscol.length;i++) {
			col.collideWith(thiscol[i]);
		}
	}
	public void collideWith(collider[] thiscol,collider[] col) {
		for(int i = 0;i < col.length;i++) {
			for(int k = 0;k < thiscol.length;k++) {
				col[i].collideWith(thiscol[k]);
			}
		}
	}
	public void collideWithBoth(collider thiscol,collider[] col) {
		for(int i = 0;i < col.length;i++) {
			if(!(col[i].equals(thiscol))){
			col[i].collideWith(thiscol);
			thiscol.collideWith(col[i]);
			}
		}
	}
	public void collideWithBoth(collider[] thiscol,collider[] col) {
		for(int i = 0;i < col.length;i++) {
			for(int k = 0;k < thiscol.length;k++) {
				if(!(col[i].equals(thiscol[k]))){
				col[i].collideWith(thiscol[k]);
				thiscol[k].collideWith(col[i]);
				}
			}
		}
	}
	public String name = "none";
	public void setName(String nm) {
		name = nm;
	}
	public void draw(Graphics2D g2) {
		g2.fillRect(pos[0],pos[1],Width,Height);
	}
	public void draw(int xp,int yp,Graphics2D g2) {
		g2.fillRect(pos[0]+xp,pos[1]+yp,Width,Height);
	}
	public void drawString(String in,int xp,int yp,Graphics2D g2) {
		g2.drawString(in,pos[0]+xp,pos[1]+yp);
	}
	public boolean[] isTouching(collider col){
		//(wasd)(top,left,bottom,right)
		int x1=col.TopLeft[0];
		int x2=col.TopRight[0];
		int y1=col.TopLeft[1];
		int y2=col.BottomRight[1];
		boolean[] out = new boolean[5];
		boolean xMiddleTouch =(TopLeft[0] <= x1)&&(TopRight[0] >= x2);
		boolean xLeftTouch = ((TopLeft[0] >= x1)&&(x2 >= TopLeft[0]));
		boolean xRightTouch = ((TopRight[0] >= x1)&&(x2 >= TopRight[0]));
		boolean yMiddleTouch =(TopLeft[1] <= y1)&&(BottomRight[1] > y2);
		boolean yUpTouch = ((TopLeft[1] >= y1)&&(y2 >= TopLeft[1]));
		boolean yDownTouch = ((BottomRight[1] >= y1)&&(y2 >= BottomRight[1]));
		boolean inside = (TopLeft[1] < col.TopLeft[1])&&(BottomLeft[1] > col.BottomLeft[1])&&(TopLeft[0] < col.TopLeft[0])&&(TopRight[0] > col.TopRight[0]);
		if((xLeftTouch||xRightTouch||xMiddleTouch)&&yUpTouch) {
			out[0] = true;
		}else {
			out[0] = false;
		}
		if((xLeftTouch||xRightTouch||xMiddleTouch)&&yDownTouch) {
			out[2] = true;
		}else {
			out[2] = false;
		}
		if((yUpTouch||yDownTouch||yMiddleTouch)&&xLeftTouch) {
			out[1] = true;
		}else {
			out[1] = false;
		}
		if((yUpTouch||yDownTouch||yMiddleTouch)&&xRightTouch) {
			out[3] = true;
		}else {
			out[3] = false;
		}
		if(inside) {
			out[4] = true;
		}else {
			out[4] = false;
		}
		return out;
		
	}
	public void gravity() {
		test = (int)((0.5)*(accelX)*(time*time));
		velocityX += (int)((0.5)*(accelX)*(timex*timex));
		velocityY += (int)((0.5)*(accelY)*(time*time));
	}
	public void physicsMove() {
		pos[0] += velocityX;
		pos[1] += velocityY;
		moveCol(pos[0],pos[1]);
	}
	public void physicsAccX(double x) {
		pos[0] += (int)((1/2)*(x)*(time*time));
		moveCol(pos[0],pos[1]);
	}
	public void physicsAccY(double y) {
		pos[1] = pos[1]+(int)((1/2)*(y)*(time*time));
		moveCol(pos[0],pos[1]);
	}
	public void setTime(double gtime) {
		time = gtime;
	}
	public void addTime(int t) {
		time = time + t;
	}
	public void reset() {
		moveCol(100, 100);
		movePos(100, 100);
		setVelocityX(0);
		setVelocityY(0);
		setTime(0);
	}
	public void reset(int x, int y) {
		moveCol(x, y);
		movePos(x, y);
		setVelocityX(0);
		setVelocityY(0);
		setTime(0);
	}
	public void collideWith(collider pcol) {
		/*if((isTouching(pcol)[0])&&(isTouching(pcol)[3])&&(!isTouching(pcol)[1])) {
			pcol.time = 0;
			if(pcol.velocityY > 0){
				pcol.velocityY = 0;
			}
			if((TopLeft[1] < pcol.BottomRight[1])) {
				if(pcol.velocityX > 0){
					pcol.velocityX = 0;
				}
			}
		}
		if((isTouching(pcol)[0])&&(!isTouching(pcol)[3])&&(isTouching(pcol)[1])) {
			pcol.time = 0;
			if(pcol.velocityY > 0){
				pcol.velocityY = 0;
			}
			if((TopLeft[1] < pcol.BottomRight[1])) {
			if(pcol.velocityX > 0){
				pcol.velocityX = 0;
			}
			}
			
		}
		*/
		if((isTouching(pcol)[0])) {
			if((TopLeft[1] <= pcol.BottomRight[1])) {
				if((TopLeft[1] < pcol.BottomRight[1])&&(!isTouching(pcol)[3])&&(!isTouching(pcol)[1])){
				pcol.velocityY = TopLeft[1]-pcol.Height-pcol.pos[1];
				pcol.time = 0;
				}
				if((pcol.velocityY >= 0)&&(TopLeft[0] < pcol.BottomRight[0])&&(TopRight[0] > pcol.BottomLeft[0])){
					pcol.velocityY = TopLeft[1]-pcol.Height-pcol.pos[1];
					pcol.time = 0;
				}
				
			}	
		}
		if((isTouching(pcol)[2])){
			if((BottomLeft[1] >= pcol.TopRight[1])) {
				if((BottomLeft[1] > pcol.TopRight[1])&&(TopLeft[0] < pcol.BottomRight[0]+pcol.velocityX)&&(TopRight[0] > pcol.BottomLeft[0]+pcol.velocityX)&&(!(pcol.name.equals("bal")))) {
					pcol.velocityY = BottomLeft[1]-pcol.pos[1];
					}
				if((pcol.velocityY <= 0)&&(TopLeft[0] < pcol.BottomRight[0]-pcol.velocityX)&&(TopRight[0] > pcol.BottomLeft[0]-pcol.velocityX)){
					pcol.velocityY = 0;
				}
			}
		}
		if(isTouching(pcol)[3]&&(!isTouching(pcol)[1])) {
			if((TopRight[0] > pcol.BottomLeft[0])&&(TopLeft[1] < pcol.BottomRight[1]-pcol.velocityY)&&(BottomLeft[1] > pcol.TopRight[1]-pcol.velocityY)&&(!isTouching(pcol)[0])&&(!isTouching(pcol)[2])) {
				pcol.velocityX = BottomRight[0]-pcol.pos[0];
			}
			if((TopRight[0] > pcol.BottomLeft[0])&&(TopLeft[1] < pcol.BottomRight[1]-pcol.velocityY)&&(BottomLeft[1] > pcol.TopRight[1]-pcol.velocityY)&&(!isTouching(pcol)[0])) {
					if(pcol.name.equals("bal")) {
					pcol.velocityX = BottomRight[0]-pcol.pos[0];
					}
				}
			if((TopRight[0] >= pcol.BottomLeft[0])&&(TopLeft[1] < pcol.BottomRight[1])&&(BottomLeft[1] > pcol.TopRight[1])) {
				if( pcol.velocityX < 0) {
					pcol.velocityX = 0;
		
				}	
				
			}
		}
		if(isTouching(pcol)[1]&&(!isTouching(pcol)[3])) {
			if((TopLeft[0] < pcol.BottomRight[0])&&(TopLeft[1] < pcol.BottomRight[1]-pcol.velocityY)&&(BottomLeft[1] > pcol.TopRight[1]-pcol.velocityY)&&(!isTouching(pcol)[0])&&(!isTouching(pcol)[2])) {
				pcol.velocityX = TopLeft[0]-pcol.Width-pcol.pos[0];
				
			}
			if((TopLeft[0] < pcol.BottomRight[0])&&(TopLeft[1] < pcol.BottomRight[1]-pcol.velocityY)&&(BottomLeft[1] > pcol.TopRight[1]-pcol.velocityY)&&(!isTouching(pcol)[0])) {
				if(pcol.name.equals("bal")) {
				pcol.velocityX = TopLeft[0]-pcol.Width-pcol.pos[0];
				}
			}
			if((TopLeft[0] <= pcol.BottomRight[0])&&(TopLeft[1] < pcol.BottomRight[1])&&(BottomLeft[1] > pcol.TopRight[1])) {
				if( pcol.velocityX > 0) {
					pcol.velocityX = 0;
				
				}
				
			}
		}
		if((((pcol.velocityY + pcol.pos[1]) > BottomRight[1])&&(pcol.pos[1] < TopRight[1]))&&((TopLeft[0] <= pcol.TopRight[0])&&(TopRight[0] >= pcol.TopLeft[0]))) {
			pcol.velocityY = TopLeft[1]-pcol.Height-pcol.pos[1];
			pcol.time = 0;
		}else if((isTouching(pcol)[4])) {
			pcol.velocityY = 0;
			pcol.pos[1] = TopLeft[1]-pcol.Height;
			//pcol.velocityY = TopLeft[1]-pcol.Height-pcol.pos[1];
			pcol.time = 0;
		}
	}
	
	

}
