package client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.accessibility.Accessible;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultiJOptionPane extends JFrame implements ActionListener,KeyListener{
	public MultiJOptionPane() {
	
	}
	public JButton btn = new JButton("enter");
	public JPanel pnl = new JPanel();
	public int x = 350;
	public int y = 80;
	public List<JTextField> txt = new ArrayList<JTextField>();
	List<JButton> bts = new ArrayList<JButton>();
	public static String[] showInputOptions(int amount,String[] names) {
		MultiJOptionPane e = new MultiJOptionPane();
		e.y *= amount;
		e.setSize(e.x, e.y);
		e.setDefaultCloseOperation(EXIT_ON_CLOSE);
		e.add(e.pnl);
		e.setVisible(true);
		String[] out = new String[amount];
		
		for(int i =0;i<amount;i++) {
			if(i<names.length) {
			e.pnl.add(new JLabel(names[i]));
			}
			e.txt.add(new JTextField(28));
			e.txt.get(i).addKeyListener(e);
			e.pnl.add(e.txt.get(i));
			e.setVisible(true);
		}
		e.pnl.add(e.btn);
		 e.btn.addActionListener(e);
		 e.setVisible(true);
        while(e.getActivated() == false) {
        for(int i =0;i<amount;i++) {
        	out[i] = e.txt.get(i).getText();
        }
        }
        e.dispose();
		return out;
	}
	public static int showButtonOptions(int amount,String[] names) {
		MultiJOptionPane e = new MultiJOptionPane();
		e.y *= amount;
		e.setSize(e.x, e.y);
		e.setDefaultCloseOperation(EXIT_ON_CLOSE);
		e.add(e.pnl);
		e.setVisible(true);
		int out = 0;
		
		for(int i =0;i<amount;i++) {
			if(i<names.length) {
				e.bts.add(new JButton(names[i]));
			}else {
				e.bts.add(new JButton());
			}
			e.pnl.add(e.bts.get(i));
			e.bts.get(i).addActionListener(e);
			e.setVisible(true);
		}
        while(e.getActivated() == false) {
        	  out = e.getEvent();
        	  System.out.flush();
        	 if(out != -1) {
        	        e.dispose();
        			return out;
        		}
        	
        }
       
        e.dispose();
		return out;
	}
	public static boolean activated = false;
	
	public int getEvent() {
		return theEvent;
	}
	public void setEvent(int i) {
		theEvent = i;
	}
	public boolean getActivated() {
		return activated;
	}
	public int theEvent = -1;
	public void actionPerformed(ActionEvent e) {
		for(int i = 0;i<bts.size();i++) {
			if(e.getSource() == bts.get(i)) {
				setEvent(i);
			}
		}
		if(e.getSource() == btn) {
			theEvent = -2;
		    activated = true;
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		if((int)e.getKeyChar() == 10) {

				theEvent = -2;
				  activated = true;
		
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
