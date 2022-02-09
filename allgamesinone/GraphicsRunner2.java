package allgamesinone;

import javax.swing.JFrame;

public class GraphicsRunner2 extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public GraphicsRunner2()
	{
		super("Graphics Runner");

		setSize(WIDTH,HEIGHT);

		getContentPane().add(new SmileyFace());
		
		//add other classes to run them 
		//BigHouse, Robot, or ShapePanel 

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
