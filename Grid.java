package length;

import java.util.ArrayList;

public class Grid<E> {
	public int xLength = 0;
	public int yLength = 0;
	public ArrayList<ArrayList<E>> Data;
	public Grid() {
		
	}
	public Grid(int xL,int yL) {
		xLength = xL;
		yLength = yL;
		Data = new ArrayList<ArrayList<E>>(yLength);
		for(int y = 0;y<yLength;y++) {
			Data.add(y,new ArrayList<E>(xLength));
			for(int x = 0;x<xLength;x++) {
				Data.get(y).add(x,null);
			}
		}
	}
	public void add(int X,int Y,E e){
		Data.get(Y).set(X, e);
		
	}
	public void add(Location loc,E e){
		Data.get(loc.getY()).set(loc.getX(),e);

	}
	public E get(Location loc) {
		return Data.get(loc.getY()).get(loc.getX());
	}
	public E get(int x,int y) {
		return Data.get(y).get(x);
	}
	public String toString(int type) {
		String out = "";
		switch(type) {
		case 0 :
		for(int y = yLength-1;y >= 0;y--) {
			for(int x = 0;x<xLength;x++) {
				out+= "("+x + "," + y+") ";
			}
			out += "\n";
		}
		break;
		case 1 : 
			for(int y = yLength-1;y >= 0;y--) {
				for(int x = 0;x<xLength;x++) {
					out+= 	Data.get(y).get(x)+" ";
				}
				out += "\n";
			}
		break;
		case 2 :
			for(int y = yLength-1;y >= 0;y--) {
				for(int x = 0;x<xLength;x++) {
					if(Data.get(y).get(x) == null) {
						out+= "("+x + "," + y+") ";
					}else {
					out+= 	Data.get(y).get(x)+" ";
					}
				}
				out += "\n";
			}
		}
		
		return out;
	}
	public String toString() {
		String out = "";
		for(int y = yLength-1;y >= 0;y--) {
			for(int x = 0;x<xLength;x++) {
				if(Data.get(y).get(x) == null) {
					out+= "("+x + "," + y+") ";
				}else {
				out+= 	Data.get(y).get(x)+" ";
				}
			}
			out += "\n";
		}
		return out;
	}
	public static void main(String[] args) {
		Grid<String> test= new Grid<String>(5,5);
		test.add(0,1,"did this work");
		System.out.println(test.toString());
		System.out.println(test.get(0,0));
	}
	
}
