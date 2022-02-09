package MainC;

import javax.swing.JFrame;
//Author the64bitdude jan 15 2022
public class MainC {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2d game");
		
		Screen screen = new Screen();
		window.add(screen);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		screen.startGameThread();
	}
}
