package main.LogicBlocks;

public class AND extends LogicBlock{
	public AND() {
		super(2,1);
	}
	public AND(int x,int y) {
		super(2,1);
		setPos(x, y);
	}
	public void calc() {
		out = false;
		if(inputs.get(0).input && inputs.get(1).input) {
;			out = true;
		}
	}
	

}
