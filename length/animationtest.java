package length;
import javax.swing.JFrame;

public class animationtest extends JFrame
{

		private static final int WIDTH = 800;
		private static final int HEIGHT = 600;

		public animationtest()
		{
			super("Graphics Runner");

			setSize(WIDTH,HEIGHT);

			getContentPane().add(new anitest());
			
			//add other classes to run them 
			//BigHouse, Robot, or ShapePanel 

			setVisible(true);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		public static void main( String args[] )
		{
			animationtest run = new animationtest();
		}
		public void runpls() {
			animationtest run = new animationtest();
		}
}
