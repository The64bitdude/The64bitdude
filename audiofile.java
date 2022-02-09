package length;

import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.TextArea;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.sound.midi.spi.MidiFileReader;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.spi.AudioFileReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class audiofile extends JFrame implements ActionListener{
	JPanel pnl = new JPanel();
	TextArea Picp = new TextArea();
	JButton btn = new JButton("enter");
	public audiofile() {
		super("test");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(pnl);
		pnl.add(Picp);
		pnl.add(btn);
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
		btn.addActionListener(this);
		setVisible(true);
	}
public AudioInputStream ais;
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn) {
			File audiofile = new File(Picp.getText());
			FileInputStream fis;
			try {
				fis = new FileInputStream(audiofile);
				BufferedInputStream bis = new BufferedInputStream(fis);
			audiofile.getName();
			try {
				AudioFileFormat aff = AudioSystem.getAudioFileFormat(audiofile);
				System.out.print(aff.toString());
				System.out.print(AudioSystem.isFileTypeSupported(aff.getType()));
				ais = AudioSystem.getAudioInputStream(audiofile);
				try {
					Clip c = AudioSystem.getClip();
					c.open(ais);
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (UnsupportedAudioFileException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	
		
		
			
		}
		
	}
	public static void main(String[] args) {
		audiofile e = new audiofile();
	}
}
