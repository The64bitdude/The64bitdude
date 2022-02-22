package main;
// Author the64bitdude jan 15 2022


import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2d game Default");
		
		Screen screen = new Screen();
		window.add(screen);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		screen.startGameThread();
	}
}
