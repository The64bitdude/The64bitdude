package multiconnectiontest;

import java.awt.Image;
import java.awt.TextArea;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import multiconnectiontest.MainServer;

import javax.imageio.ImageIO;

import client.JImage;

public class ConnectionManager implements Runnable{
	public Socket s;
	public ObjectOutputStream dos;
	public ObjectInputStream dis;
	public TextArea txa;
	public Thread thread;
	public List<Object> out;
	public List<Object> in;
	public ConnectionManager(ServerSocket si) {
		try {
			s = si.accept();
			run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int dcount;
	public void run() {
     try {
		dos = new ObjectOutputStream(s.getOutputStream());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     try {
		dis = new ObjectInputStream(s.getInputStream());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     while(thread != null) {
    	 try {
    		 Object thing = dis.readObject();
    		 if(thing != null) {
			out.add(dis.readObject());
    		 }
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 try {
    		 if((in.get(0) != null)&&(in.get(0) != "")) {
    				dos.writeObject(in.get(0));
    				in.remove(0);
    		 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
	}

}
