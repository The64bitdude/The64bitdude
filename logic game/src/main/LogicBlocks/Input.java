package main.LogicBlocks;

import java.awt.Color;
import java.awt.Graphics2D;

public class Input extends Block{

	public boolean input;
	public Input(int X , int Y) {
		super(X,Y,50,50);
	}
	public void getWireInput(Button l) {
		if((l.wX > x)&&(l.wX < x+w)&&(l.wY > y)&&(l.wY < (y+h))){
			input = l.state;
		}
	}
	public void getWireInput(LogicBlock l) {
		if((l.wX > x)&&(l.wX <x+w)&&(l.wY > y)&&(l.wY < (y+h))){
			input = l.out;
		}
	}
}
