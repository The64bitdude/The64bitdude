package main;

public class Camera extends Point{
	public double h;
	public double v;
	public Camera(int x, int y, int z) {
		super(x, y, z);
	}
	public void setRotation(double cameraH,double cameraV){
		h=cameraH;
		v=cameraV;
	}
	

}
