package multiconnectiontest;

import java.awt.Image;
import java.awt.TextArea;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import multiconnectiontest.MainServer;

import javax.imageio.ImageIO;

import client.JImage;

public class ConnectionManager implements Runnable{
	public ServerSocket si;
	public Socket s;
	public ObjectOutputStream dos;
	public ObjectInputStream dis;
	public TextArea txa;
	public boolean connected = false;
	public String username;
	public int port;
	public File filin;
	public File filout;
	Thread t;
	public ConnectionManager(String user,int po) throws IOException {


			port = po;
			username = user;
			filin = new File("inPort" + po+".dat");
			filout = new File("outPort" + po+".dat");
			FileWriter fer = new FileWriter(filin);
			fer.write("");
			fer.close();
			FileWriter fr = new FileWriter(filout);
			fr.write("");
			fr.close();
			run();
	}
	public void close() throws IOException {
		dos.close();
		dis.close();
		s.close();
		si.close();
		
	}
	public int dcount;

	@Override
	public void run() {
		try {
		si = new ServerSocket(port);
		s = si.accept();
		dos = new ObjectOutputStream(s.getOutputStream());
		dis = new ObjectInputStream(s.getInputStream());
		dos.writeObject(username + ": has joined");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			byte[][] indata = null;
			try {
				indata = readDeleteFile(filout);
			}catch(FileNotFoundException awd) {
				try {
				FileWriter filewrtier = new FileWriter(filout);
				filewrtier.write(Inet4Address.getLocalHost().getHostAddress()+":"+2222 + ":"+"server:");
				filewrtier.close();
				indata = readDeleteFile(filout);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				String prev = "";
				for(byte[] al:indata) {
					if(prev.equals("FileGoingThrough1515%34189%")) {
				dos.writeObject(al);
					}else {
						dos.writeObject(new String(al));
					}
					prev = new String(al);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Object ob = dis.readObject();
				if(ob.getClass().equals(String.class)) {
					writeFile(((String)ob).getBytes(),filin);
				}else {
				writeFile( (byte[])ob,filin);
				}
			} catch (IOException | ClassNotFoundException|ClassCastException e) {
				
				e.printStackTrace();
			}
		}
	}
	public static byte[][] readFile(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		List<List<String>> out = new ArrayList<List<String>>();
		int count = 0;
		out.add(new ArrayList<String>());
		while(in.hasNextLine()) {
			String line = in.nextLine();
			if(line.equals("$%&6&%#(^*&^#$&*^#$&#&$^(%*&") ) { 
		out.add(new ArrayList<String>());
			count++;
		}else {
		out.get(count).add(line);
		}
		}
		in.close();
		byte[][] ot = new byte[out.size()][];
		for(int k = 0;k<out.size();k++) {
			ot[k] = new byte[out.get(k).size()];
		 for(int i = 0;i< out.get(k).size();i++) {
		 ot[k][i] = Byte.parseByte(out.get(k).get(i));
		 }
		}
		return ot;
		
	}
	public static byte[][] readDeleteFile(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		List<List<String>> out = new ArrayList<List<String>>();
		int count = 0;
		out.add(new ArrayList<String>());
		while(in.hasNextLine()) {
			String line = in.nextLine();
			if(line.equals("$%&6&%#(^*&^#$&*^#$&#&$^(%*&") ) { 
		out.add(new ArrayList<String>());
			count++;
		}else {
		out.get(count).add(line);
		}
		}
		in.close();
		byte[][] ot = new byte[out.size()][];
		for(int k = 0;k<out.size();k++) {
			ot[k] = new byte[out.get(k).size()];
		 for(int i = 0;i< out.get(k).size();i++) {
		 ot[k][i] = Byte.parseByte(out.get(k).get(i));
		 }
		}
		try {
		FileWriter fileriter = new FileWriter(file);
		fileriter.write("");
		fileriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ot;
		
	}
	public static String readFileString(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		String out = "";
		while(in.hasNextLine()) {
			out += in.nextLine() +"\n";
		}
		in.close();

		return out;
		
	}
	public static void writeFile(byte[] e,File file) throws IOException {
		String oldfile = readFileString(file);
		FileWriter fileriter = new FileWriter(file);
		List<String> in = new ArrayList<String>();
		for(byte a:e) {
		in.add(Byte.toString(a));
		}
		String out = "";
		for(String l:in) {
		out += l+"\n";
		}
		if(oldfile != "") {
		fileriter.write(oldfile+"$%&6&%#(^*&^#$&*^#$&#&$^(%*&\n"+out);
	    }else{
		fileriter.write(out);
	    }
		fileriter.close();
		
	}

}
