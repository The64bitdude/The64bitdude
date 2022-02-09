// Author the64bitdude jan 15 2022
package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener{

	public boolean reset,enterPressed,upPressed, downPressed, leftPressed, rightPressed;
	public boolean typingMode = false;
	public String msg = "";
	@Override
	public void keyTyped(KeyEvent e) {
		if(typingMode == true) {
			if(((int)e.getKeyChar() == 8)&&(msg.length() > 0)) {
			msg = msg.substring(0,msg.length()-1);	
			}else {
			msg += e.getKeyChar() + "";
			}
		}
	}
	public String getMsg() {
		return msg;
	}
	public void resetMsg() {
		enterPressed = false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER ) {
			enterPressed = true;
			typingMode = false;
		}
		if(typingMode == false) {
			if(code == KeyEvent.VK_R ) {
				reset = true;
			}
		if(code == KeyEvent.VK_T ) {
			msg = "";
			typingMode = true;
		}
		if(code == KeyEvent.VK_W ) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_A ) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_S ) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_D ) {
			rightPressed = true;
		}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_R ) {
			reset = false;
		}
		if(code == KeyEvent.VK_W ) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_A ) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_S ) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_D ) {
			rightPressed = false;
		}
		
	}

	
}

