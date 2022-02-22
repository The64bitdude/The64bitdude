package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyPresses implements KeyListener{
	boolean forward,backward,up,down,left,right;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'w') {
			backward = true;
		}
		if(e.getKeyChar() == 's') {
			forward = true;
		}
		if(e.getKeyChar() == 'q') {
			up = true;
		}
		if(e.getKeyChar() == 'e') {
			down = true;
		}
		if(e.getKeyChar() == 'a') {
			right = true;
		}
		if(e.getKeyChar() == 'd') {
			left = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'w') {
			backward = false;
		}
		if(e.getKeyChar() == 's') {
			forward = false;
		}
		if(e.getKeyChar() == 'q') {
			up = false;
		}
		if(e.getKeyChar() == 'e') {
			down = false;
		}
		if(e.getKeyChar() == 'a') {
			right = false;
		}
		if(e.getKeyChar() == 'd') {
			left = false;
		}
		
	}

}
