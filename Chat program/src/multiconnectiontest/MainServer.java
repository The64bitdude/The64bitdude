//Author the64bitdude made in jan 9 2022 
package multiconnectiontest;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.HashMap;
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
import client.client;
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
public class MainServer extends JFrame implements ActionListener,KeyListener{
	public JPanel pnl = new JPanel();
	public TextArea txa = new TextArea();
	public TextField txp = new TextField(28);
	public JButton btn = new JButton("enter");
	public JButton itn = new JButton("image");
	public JButton Ntn = new JButton("net image");
	public String username = "";
	public TextField Picp = new TextField(28);
	public TextField NPicp = new TextField(28);
	public static int port = 0;
	public String ip;
	public String Tusername;
	public MainServer(String userna,String ipe,int porte) throws IOException, ClassNotFoundException {
		
		super("chat " +Inet4Address.getLocalHost().getHostAddress());
		System.setProperty("java.net.preferIPv4Stack", "true");
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
		String name;
		Tusername = userna;
		if(porte == 0) {
		if(MultiJOptionPane.showButtonOptions(2,new String[] {"use your ip as host","pick host ip"})== 0) {
		String[] selections = MultiJOptionPane.showInputOptions(2,new String[]{"username","port"});
		name = selections[0];
		ip = Inet4Address.getLocalHost().getHostAddress();
		int Port = (int)ToLine.SToDouble(selections[1]);
		port = Port;
		}else {
			String[] selections = MultiJOptionPane.showInputOptions(3,new String[]{"username","ip","port"});
			name = selections[0];
			ip = selections[1];
			int Port = (int)ToLine.SToDouble(selections[2]);
			port = Port;
			
		}
		}else {
			port = porte;
			ip = ipe;
			name = JOptionPane.showInputDialog("whats your username");
		}
		txp.setText("your host ip is " +ip + " : and your port is : "+port);
		setTitle( name + " : " +ip + " : "+ port);
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
			String pass = receiveString();
		if(pass.equals("FileGoingThrough1515%34189%")) {
			String filename = receiveString();
			txa.setText(txa.getText() +"file " +filename+" recived" + "\n");
		byte[] fileData = receiveByte();
		FileOutputStream fos = new FileOutputStream(filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write(fileData, 0, fileData.length);
		File file = new File(filename);
		if(isImage(file)) {
		Image img = ImageIO.read(file);
		JImage test = new JImage(img,filename);
		}else if(pass.equals("TXTFileGoingThrough1515%34189%")) {
			String filenam = receiveString();
			try {
			FileWriter fw = new FileWriter(filenam);
			fw.write(receiveString());
			fw.close();
			}catch(FileNotFoundException e) {

			}
		}
		}else {
		txa.setText(txa.getText() +pass + "\n");
		client.therest(ip,port,Tusername,"servers.dat");
		}
		dcount = 0;
		}catch(EOFException e) {
			if(dcount < 1) {
			txa.setText(txa.getText() +"disconnected" + "\n");
			
			}
			s.close();
			connect(port);
			dcount++;
		}
		}
	}
	int dcount = 0;
	public MulticastSocket s;
	InetAddress group;
	public void connect(int port) throws UnknownHostException, IOException, ClassNotFoundException {
		String u = username +" : has joined";
		group = InetAddress.getByName("230"+ip.substring(ip.indexOf(".")));
		 s = new MulticastSocket(port);
		 s.joinGroup(group);
		 // get their responses!
		 // OK, I'm done talking - leave the group...
		 // s.leaveGroup(group);
	
		 sendString(u);
		String msga = receiveString();
		txa.setText(txa.getText() + msga + "\n");
		Picp.setText("");
	}
	public void sendString(String st) {
		 DatagramPacket hi = new DatagramPacket(st.getBytes(), st.length(),group, port);
		 try {
			s.send(hi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendBytes(byte[] st) {
		 DatagramPacket hi = new DatagramPacket(st, st.length,group, port);
		 try {
			s.send(hi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String receiveString() {
		 byte[] buf = new byte[1000];
		 DatagramPacket recv = new DatagramPacket(buf, buf.length);
		 try {
			s.receive(recv);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return new String(recv.getData());
	}
	public byte[] receiveByte() {
		 byte[] buf = new byte[1000];
		 DatagramPacket recv = new DatagramPacket(buf, buf.length);
		 try {
			s.receive(recv);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return recv.getData();
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
		sendString(u);
		txp.setText("");
		
	}
	public void img() throws IOException {
		String FileName = Picp.getText();
		File file = new File(FileName);
		byte[] bitar = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		bis.read(bitar,0,bitar.length);
		sendString("FileGoingThrough1515%34189%");
		sendString(file.getName());
		sendBytes(bitar);
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
		sendString("TXTFileGoingThrough1515%34189%");
		sendString(file.getName());
		sendString(out);
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
		System.setProperty("java.net.preferIPv4Stack", "true");
		JFrame frm = new JFrame("name");
		frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		String filedata;
		int ports = 0;
		String ips = "";
		HashMap<String,Integer> olds;
		try {
			File pa = new File("servers.dat");
			filedata = client.readFile(pa);
			olds =  client.getPort(filedata);
		}catch(FileNotFoundException awd) {
			FileWriter filewrtier = new FileWriter("servers.dat");
			filewrtier.write(Inet4Address.getLocalHost().getHostAddress()+":"+2222 + ":"+"server:");
			filewrtier.close();
			File pa = new File("servers.dat");
			filedata =  client.readFile(pa);
			olds =  client.getPort(filedata);
		}
		String name = "";
		if(JOptionPane.showConfirmDialog(frm,"do you wabt to pick from past connections?")!= 0) {
			name = JOptionPane.showInputDialog("whats the new servers name");
			ports = 0;
		}else {
			String out = (String) JOptionPane.showInputDialog(frm, "do it", "pick one", JOptionPane.PLAIN_MESSAGE, null, client.getNames(filedata).toArray(),  client.getNames(filedata).toArray()[0]);
			name = out;
			ips= client.getHashNames(filedata).get(out);
			ports = olds.get(ips);
		}
		frm.setVisible(true);
		frm.dispose();
		MainServer e = new MainServer(name,ips,ports);
	}

	}
