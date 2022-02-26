package main.LogicBlocks;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class LogicBlock extends Block{
	public boolean out;
	public int index =0;
	public int wX,wY;
	public List<Input> inputs;
	public List<Wire> outputs;
	public boolean isDragw;
	public boolean locked;
	
	public LogicBlock(int Inums,int Onums) {
		super(0,0,150,100);
		inputs = new ArrayList<Input>();
		outputs = new ArrayList<Wire>();
		for(int i = 0;i<(Inums*2);i+=2) {
			inputs.add(new Input(x,y+((h/(Inums*2)*i))));
		}
		for(int i = 0;i<(Onums*2);i+=2) {
			outputs.add(new Wire(x+w,y+((h/(Inums*2)*i))));
		}
	}
	/*public void draw(Graphics2D g2) {
		Color c = g2.getColor();
		g2.fillRect(x, y, w,h);
		g2.setColor(Color.GRAY);
		for(int i = 0;i<(inputs.size());i++) {
			g2.fillRect(inputs.get(i).x,inputs.get(i).y,20,20);
		}
		for(int i = 0;i<(outputs.size());i++) {
			outputs.get(i).draw(g2);
		}
		g2.setColor(c);
	}*/
	public void getWireInput(Button l) {
		for(int i = 0;i<inputs.size();i++) {
			inputs.get(i).getWireInput(l);
		}
	}
	public void calc() {
		
	}
	public void wire(int x,int y) {
		wX=x;
		wY=y;
	}
	public void getWireInput(LogicBlock l) {
		for(int i = 0;i<inputs.size();i++) {
			inputs.get(i).getWireInput(l);
		}
	}
}
