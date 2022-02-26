package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class keyPresses implements KeyListener , MouseMotionListener{
	boolean lU,lD,lL,lR,forward,backward,up,down,left,right;
	int MouseX,MouseY;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'c') {
			lU = true;
		}
		if(e.getKeyChar() == 'v') {
			lD = true;
		}
		if(e.getKeyChar() == 'z') {
			lR = true;
		}
		if(e.getKeyChar() == 'x') {
			lL = true;
		}
		if(e.getKeyChar() == 's') {
			backward = true;
		}
		if(e.getKeyChar() == 'w') {
			forward = true;
		}
		if(e.getKeyChar() == 'q') {
			up = true;
		}
		if(e.getKeyChar() == 'e') {
			down = true;
		}
		if(e.getKeyChar() == 'd') {
			right = true;
		}
		if(e.getKeyChar() == 'a') {
			left = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'c') {
			lU = false;
		}
		if(e.getKeyChar() == 'v') {
			lD = false;
		}
		if(e.getKeyChar() == 'z') {
			lR = false;
		}
		if(e.getKeyChar() == 'x') {
			lL = false;
		}
		if(e.getKeyChar() == 's') {
			backward = false;
		}
		if(e.getKeyChar() == 'w') {
			forward = false;
		}
		if(e.getKeyChar() == 'q') {
			up = false;
		}
		if(e.getKeyChar() == 'e') {
			down = false;
		}
		if(e.getKeyChar() == 'd') {
			right = false;
		}
		if(e.getKeyChar() == 'a') {
			left = false;
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		MouseX = e.getX();
		MouseY= e.getY();
	}

}
