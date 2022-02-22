package main;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.IconView;

public class JImage extends JFrame{
JPanel pnl = new JPanel();
	public JImage(Image img,String filename) {
		super(filename);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if((img.getWidth(pnl) > screenSize.width)||(img.getHeight(pnl) > screenSize.height)) {
			if((img.getHeight(pnl) > screenSize.height)) {
		img = img.getScaledInstance(img.getWidth(pnl),screenSize.height, 0);
			}
			if((img.getWidth(pnl) > screenSize.width)) {
		img = img.getScaledInstance(screenSize.width,img.getHeight(pnl), 0);	
			}
			setSize(img.getWidth(pnl)+10,img.getHeight(pnl)+27);
		}else {
		setSize(img.getWidth(pnl)+10,img.getHeight(pnl)+27);
		}
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(pnl);
		pnl.add(new JLabel(new ImageIcon(img)));
		setVisible(true);
	}
	
}
