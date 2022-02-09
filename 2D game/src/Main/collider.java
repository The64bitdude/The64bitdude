package Main;

public class collider {
	public int[] TopLeft;
	public int[] TopRight;
	public int[] BottomLeft;
	public int[] BottomRight;
	public int Width;
	public int Height;
	public collider(int x,int y,int width, int height) {
		TopLeft = new int[] {x,y};
		TopRight = new int[] {x+width,y};
		BottomLeft = new int[] {x,y+height};
		BottomRight = new int[] {x+width,y+height};
		Width = width;
		Height = height;
	}
	public void moveCol(int x, int y) {
		TopLeft = new int[] {x,y};
		TopRight = new int[] {x+Width,y};
		BottomLeft = new int[] {x,y+Height};
		BottomRight = new int[] {x+Width,y+Height};
	}
	public boolean[] isTouching(collider col){
		//(wasd)(top,left,bottom,right)
		int x1=col.TopLeft[0];
		int x2=col.TopRight[0];
		int y1=col.TopLeft[1];
		int y2=col.BottomRight[1];
		boolean[] out = new boolean[4];
		boolean xMiddleTouch =(TopLeft[0] < x1)&&(TopRight[0] > x2);
		boolean xLeftTouch = ((TopLeft[0] >= x1)&&(x2 >= TopLeft[0]));
		boolean xRightTouch = ((TopRight[0] >= x1)&&(x2 >= TopRight[0]));
		boolean yMiddleTouch =(TopLeft[1] < y1)&&(BottomRight[1] > y2);
		boolean yUpTouch = ((TopLeft[1] >= y1)&&(y2 >= TopLeft[1]));
		boolean yDownTouch = ((BottomRight[1] >= y1)&&(y2 >= BottomRight[1]));
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
		return out;
		
	}
	
	
	
}
