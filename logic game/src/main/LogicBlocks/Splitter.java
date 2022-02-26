package main.LogicBlocks;

public class Splitter extends LogicBlock{
	public Splitter() {
		super(1,3);
		w = 150;
		h = 100;
	}
	public Splitter(int x,int y) {
		super(1,1);
		setPos(x, y);
		w = 150;
		h = 100;
	}
	public void calc() {
		out = false;
		out = inputs.get(0).input;
	}

}
