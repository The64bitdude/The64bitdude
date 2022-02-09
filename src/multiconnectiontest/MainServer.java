// Author the64bitdude made in jan 9 2022 
package multiconnectiontest;
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

import Main.ToLine;
import client.JImage;
import client.MultiJOptionPane;

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
public class MainServer extends JFrame implements ActionListener,KeyListener,ListSelectionListener{
	public JPanel pnl = new JPanel();
	public TextArea txa = new TextArea();
	public TextField txp = new TextField(28);
	public JButton btn = new JButton("enter");
	public JButton itn = new JButton("image");
	public String username = "";
	public TextField Picp = new TextField(28);
	public ObjectOutputStream dos;
	public ObjectInputStream dis;
	public boolean OoF = false;
	public String Tusername;
	public MainServer(String ips,int ports,String name) throws IOException, ClassNotFoundException {
		super("chatClient");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(pnl);
		pnl.add(txa);
		pnl.add(txp);
		pnl.add(btn);
		pnl.add(Picp);
		pnl.add(itn);
		btn.addActionListener(this);
		itn.addActionListener(this);
		txp.addKeyListener(this);
		ip = ips;
		port = ports;
		username = name;
		connect(ip,port);
		setVisible(true);
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
		JImage test = new JImage(img);
		}
		}else {
			Tusername = pass.substring(0,pass.indexOf(":")-1);
			therest(ip,port);
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
			connect(ip,port);
			dcount++;
		}
		}
	}
	String ip;
	int port;
	public void therest(String ip ,int port) throws IOException, ClassNotFoundException,NullPointerException {
		FileWriter fileriter = new FileWriter("old_connections.dat");
		String filedata = readFile(new File("old_connections.dat"));
		HashMap<String,Integer> olds = getPort(filedata);
		List<String> outnames = getoutnames(filedata);
		if(!(outnames.contains(ip))){
		fileriter.write(filedata+ip +":" + port+":"+Tusername+":");
		}else {
			if(olds.get(ip) == port) {
		fileriter.write(filedata);
			}else {
				fileriter.write(filedata.substring(0,filedata.indexOf(ip)+ip.length())+":"+port+":"+Tusername+filedata.substring(filedata.indexOf(port)+(port+"").length()).substring(filedata.substring(filedata.indexOf(port)+(port+"").length()).indexOf(":")));
			}
		}
		fileriter.close();
	}
	public static String readFile(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		String out = "";
		while(in.hasNextLine()) {
			out += in.nextLine();
		}
		in.close();

		return out;
		
	}
	public static List<String> getoutnames(String in){
			HashMap<String,Integer> out = new HashMap<String,Integer>();
			List<String> outname = new ArrayList<String>();
			while(in.indexOf(":") != -1) {
				String firstkey = in.substring(0,in.indexOf(":"));
	            outname.add(firstkey);
				in = in.substring(in.indexOf(":")+1);
				String secondkey = in.substring(0,in.indexOf(":"));
				in = in.substring(in.indexOf(":")+1);
				String thirdkey = in.substring(0,in.indexOf(":"));
				in = in.substring(in.indexOf(":")+1);
				out.put(firstkey,(int)ToLine.SToDouble(secondkey));
			}
			return outname;
			
		}
	public static List<String> getNames(String in){
		HashMap<String,String> out = new HashMap<String,String>();
		List<String> outname = new ArrayList<String>();
		while(in.indexOf(":") != -1) {
			String firstkey = in.substring(0,in.indexOf(":"));
			in = in.substring(in.indexOf(":")+1);
			String secondkey = in.substring(0,in.indexOf(":"));
			in = in.substring(in.indexOf(":")+1);
			String thirdkey = in.substring(0,in.indexOf(":"));
			in = in.substring(in.indexOf(":")+1);
			outname.add(thirdkey);
			out.put(firstkey,thirdkey);
		}
		return outname;
		
	}
	public static HashMap<String,String> getHashNames(String in){
		HashMap<String,String> out = new HashMap<String,String>();
		List<String> outname = new ArrayList<String>();
		while(in.indexOf(":") != -1) {
			String firstkey = in.substring(0,in.indexOf(":"));
			in = in.substring(in.indexOf(":")+1);
			String secondkey = in.substring(0,in.indexOf(":"));
			in = in.substring(in.indexOf(":")+1);
			String thirdkey = in.substring(0,in.indexOf(":"));
			in = in.substring(in.indexOf(":")+1);
			outname.add(thirdkey);
			out.put(thirdkey,firstkey);
		}
		return out;
		
	}
	public static HashMap<String,Integer> getPort(String in){
		HashMap<String,Integer> out = new HashMap<String,Integer>();
		List<String> outname = new ArrayList<String>();
		while(in.indexOf(":") != -1) {
			String firstkey = in.substring(0,in.indexOf(":"));
            outname.add(firstkey);
			in = in.substring(in.indexOf(":")+1);
			String secondkey = in.substring(0,in.indexOf(":"));
			in = in.substring(in.indexOf(":")+1);
			String thirdkey = in.substring(0,in.indexOf(":"));
			in = in.substring(in.indexOf(":")+1);
			out.put(firstkey,(int)ToLine.SToDouble(secondkey));
		}
		return out;
		
	}
	public Socket s;
	public void connect(String ip,int port) throws UnknownHostException, ClassNotFoundException {
		try {
		s = new Socket(ip,port);
		String u = username +" : has joined";
		dos = new ObjectOutputStream(s.getOutputStream());
		dis = new ObjectInputStream(s.getInputStream());
		dos.writeObject(u);
		txa.setText(txa.getText() + u + "\n");
		String msga = (String) dis.readObject();
		txa.setText(txa.getText() + msga + "\n");
		Picp.setText("");
        }catch(IOException e) {
			
		}
	}
	int dcount = 0;
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
		JFrame frm = new JFrame("name");
		frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		String filedata;
		int ports = 0;
		String ips = "";
		HashMap<String,Integer> olds;
		try {
			File pa = new File("old_connections.dat");
			filedata = readFile(pa);
			olds = getPort(filedata);
		}catch(FileNotFoundException awd) {
			FileWriter filewrtier = new FileWriter("old_connections.dat");
			filewrtier.write(Inet4Address.getLocalHost().getHostAddress()+":"+2222 + ":"+"server:");
			filewrtier.close();
			File pa = new File("old_connections.dat");
			filedata = readFile(pa);
			olds = getPort(filedata);
		}
		String name = "";
		if(JOptionPane.showConfirmDialog(frm,"do you wabt to pick from past connections?")!= 0) {
		String[] selections = MultiJOptionPane.showInputOptions(3,new String[]{"username","ip","port"});
		name = selections[0];
		ips = selections[1];
		ports = (int)ToLine.SToDouble(selections[2]);
		}else {
			name = JOptionPane.showInputDialog(frm,"username");
		String out = (String) JOptionPane.showInputDialog(frm, "do it", "pick one", JOptionPane.PLAIN_MESSAGE, null, getNames(filedata).toArray(), getNames(filedata).toArray()[0]);
		ips= getHashNames(filedata).get(out);
		ports = olds.get(ips);
		}
		frm.setVisible(true);
		frm.dispose();
		MainServer e = new MainServer(ips,ports,name);
		
	}
	
	public void valueChanged(ListSelectionEvent e) {
	
		
	}
}
