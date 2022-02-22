// Author the64bitdude made in jan 9 2022 
package main;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
public class chatProgramWeb extends JFrame implements ActionListener,KeyListener,ListSelectionListener{
	public JPanel pnl = new JPanel();
	public TextArea txa = new TextArea();
	public TextField txp = new TextField(28);
	public JButton btn = new JButton("enter");
	public JButton itn = new JButton("clear");
	public String username = "";
	public TextField Picp = new TextField(28);
	public ObjectOutputStream dos;
	public ObjectInputStream dis;
	public boolean OoF = false;
	public String Tusername;
	public chatProgramWeb() throws IOException, ClassNotFoundException {
		super("chatClient");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(pnl);
		pnl.add(txa);
		pnl.add(txp);
		pnl.add(btn);
		pnl.add(itn);
		btn.addActionListener(this);
		itn.addActionListener(this);
		txp.addKeyListener(this);
		setVisible(true);
		
		
		
		
		while(true) {
			txa.setText(readFile(new File("/Users/s214714/eclipse-workspace/chatServerRunner/WebContent/textchat.txt")));
		}
	}
	
	public static String readFile(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		String out = "";
		while(in.hasNextLine()) {
			out += in.nextLine() + "\n";
		}
		in.close();

		return out;
		
	}
	public static void addWriteFile(String in) throws IOException {
		String old = readFile(new File("/Users/s214714/eclipse-workspace/chatServerRunner/WebContent/textchat.txt"));
		FileWriter fw = new FileWriter(new File("/Users/s214714/eclipse-workspace/chatServerRunner/WebContent/textchat.txt"));
		fw.write(old +in + "\n");
		fw.close();
		
	}
	
	public void msg() throws IOException {
		String u = "";
		u = txp.getText();
		txp.setText("");
		addWriteFile(u);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn) {
			try {
				msg();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == itn) {
			try {
				FileWriter fw = new FileWriter(new File("/Users/s214714/eclipse-workspace/chatServerRunner/WebContent/textchat.txt"));
				fw.write("");
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
		public void keyTyped(KeyEvent e) {
			
		}
		public void keyPressed(KeyEvent e) {
			if((int)e.getKeyChar() == 10) {
				try {
					msg();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		public void keyReleased(KeyEvent e) {
			
		}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		chatProgramWeb e = new chatProgramWeb();
	}
	
	public void valueChanged(ListSelectionEvent e) {
	
		
	}
}
