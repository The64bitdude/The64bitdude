package main.LogicBlocks;

public class NOT extends LogicBlock{
	public NOT() {
		super(1,1);
		w = 150;
		h = 100;
	}
	public NOT(int x,int y) {
		super(1,1);
		setPos(x, y);
		w = 150;
		h = 100;
	}
	public void calc() {
		out = true;
		out = !(inputs.get(0).input);
	}

}
