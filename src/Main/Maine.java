//Author the64bitdude made in jan 9 2022 
package Main;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Main.ToLine;
import client.JImage;
import client.MultiDataStream;
import client.MultiJOptionPane;
import client.openDesktopFile;

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
public class Maine extends JFrame implements ActionListener,KeyListener{
	public JPanel pnl = new JPanel();
	public TextArea txa = new TextArea();
	public TextField txp = new TextField(28);
	public JButton btn = new JButton("enter");
	public JButton itn = new JButton("image");
	public JButton Ntn = new JButton("net image");
	public String username = "";
	public TextField Picp = new TextField(28);
	public TextField NPicp = new TextField(28);
	public ObjectOutputStream dos;
	public ObjectInputStream dis;
	public static int port = 0;
	public Maine() throws IOException, ClassNotFoundException {
		super("chatServer " +Inet4Address.getLocalHost().getHostAddress());
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(pnl);
		pnl.add(txa);
		pnl.add(txp);
		pnl.add(btn);
		pnl.add(Picp);
		pnl.add(itn);
		pnl.add(NPicp);
		pnl.add(Ntn);
		setVisible(true);
		String[] selections = MultiJOptionPane.showInputOptions(2,new String[]{"username","port"});
		String name = selections[0];
		int Port = (int)ToLine.SToDouble(selections[1]);
		port = Port;
		txp.setText("your ip is " +Inet4Address.getLocalHost().getHostAddress() + " : and your port is : "+port);
		setTitle("chatServer " +Inet4Address.getLocalHost().getHostAddress() + " : "+ port);
		btn.addActionListener(this);
		itn.addActionListener(this);
		txp.addKeyListener(this);
		Ntn.addActionListener(this);
		username = name;
		connect(port);
		Picp.setDropTarget(new DropTarget() {
		    public synchronized void drop(DropTargetDropEvent evt) {
		        try {
		            evt.acceptDrop(DnDConstants.ACTION_COPY);
		            List<File> droppedFiles = (List<File>)
		                evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
		            for (File file : droppedFiles) {
		                Picp.setText(file.getPath());
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		NPicp.setDropTarget(new DropTarget() {
		    public synchronized void drop(DropTargetDropEvent evt) {
		        try {
		            evt.acceptDrop(DnDConstants.ACTION_COPY);
		            List<File> droppedFiles = (List<File>)
		                evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
		            for (File file : droppedFiles) {
		                NPicp.setText(file.getPath());
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		while(true) {
			try {
			String pass = (String) dis.readObject();
		if(pass.equals("FileGoingThrough1515%34189%")) {
			String filename = (String) dis.readObject();
			txa.setText(txa.getText() +"file " +filename+" recived" + "\n");
		byte[] fileData = (byte[]) dis.readObject();
		FileOutputStream fos = new FileOutputStream(filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write(fileData, 0, fileData.length);
		File file = new File(filename);
		if(isImage(file)) {
		Image img = ImageIO.read(file);
		JImage test = new JImage(img,filename);
		}
		}else {
		txa.setText(txa.getText() +pass + "\n");
		}
		dcount = 0;
		}catch(EOFException e) {
			if(dcount < 1) {
			txa.setText(txa.getText() +"disconnected" + "\n");
			
			}
			dos.close();
			dis.close();
			s.close();
			server.close();
			connect(port);
			dcount++;
		}
		}
	}
	int dcount = 0;
	public Socket s;
	ServerSocket server;
	public void connect(int port) throws UnknownHostException, IOException, ClassNotFoundException {
		server = new ServerSocket(port);
		s = server.accept();
		String u = username +" : has joined";
		dos = new ObjectOutputStream(s.getOutputStream());
		dis = new ObjectInputStream(s.getInputStream());
		dos.writeObject(u);
		txa.setText(txa.getText() + u + "\n");
		String msga = (String) dis.readObject();
		txa.setText(txa.getText() + msga + "\n");
		Picp.setText("");
	}
	public boolean isImage(File file) {
		String[] ext = new String[] {".jpeg",".jpg",".png",".gif",".bmp",".webmp"};
		String filename = file.getName();
		for(int i = 0;i<ext.length;i++) {
			if(ext[i].equals(filename.substring(filename.length()-ext[i].length()))) {
				return true;
			}
		}
		return false;
		
	}
	public void msg() throws IOException {
		String u = "";
		u = txp.getText();
		u = username +" : "+ u;
		dos.writeObject(u);
		txa.setText(txa.getText() + u + "\n");
		txp.setText("");
		
	}
	public void img() throws IOException {
		String FileName = Picp.getText();
		File file = new File(FileName);
		byte[] bitar = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		bis.read(bitar,0,bitar.length);
		dos.writeObject("FileGoingThrough1515%34189%");
		dos.writeObject(file.getName());
		dos.writeObject(bitar);
	}
	public void Nimg() throws IOException {
		String FileName = Picp.getText();
		File file = new File(FileName);
		String out = "";
		Scanner fis = new Scanner(FileName);
		while(fis.hasNextLine()){
			out += fis.nextLine() + "\n";
		}
		fis.close();
		dos.writeObject("TXTFileGoingThrough1515%34189%");
		dos.writeObject(file.getName());
		dos.writeObject(out);
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
				img();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == Ntn) {
			try {
				Nimg();
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
		public void drop(DropTargetDropEvent evt) {
			
		}
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Maine e = new Maine();
	}

	}
