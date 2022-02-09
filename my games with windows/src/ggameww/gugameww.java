package ggameww;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class gugameww extends JFrame implements ActionListener{
public JPanel pnl = new JPanel();
public JPanel pnl2 = new JPanel();
public JButton rad1 = new JButton("1");
public JButton rad2 = new JButton("2");
public JButton rad3 = new JButton("3");
public JButton rad4 = new JButton("4");
public JButton rad5 = new JButton("5");
public JButton rad6 = new JButton("6");
public JButton rad7 = new JButton("7");
public JButton rad8 = new JButton("8");
public JButton rad9 = new JButton("9");
public JButton radc = new JButton("clear");
public JButton rad0 = new JButton("0");
public JButton rade = new JButton("enter");
public JButton rade2 = new JButton("enter");
public JButton rade3 = new JButton("enter");
public JTextArea txtArea = new JTextArea(3,19);
public JTextArea txtArea2 = new JTextArea(1,19);
public JTextArea txtArea3 = new JTextArea(5,38);
public Scanner in = new Scanner(System.in);
public int bob = 0;
public int password;
public gugameww() {
	super("Password");
	System.out.print("set password : ");
	password = in.nextInt();
	setSize(250,242);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	add(pnl);
	txtArea2.setText("PASSWORD");
	pnl.add(txtArea2);
	pnl.add(rad7);
	pnl.add(rad8);
	pnl.add(rad9);
	pnl.add(rad4);
	pnl.add(rad5);
	pnl.add(rad6);
	pnl.add(rad1);
	pnl.add(rad2);
	pnl.add(rad3);
	pnl.add(radc);
	radc.setEnabled(false);
	pnl.add(rad0);
	pnl.add(rade);
	pnl.add(txtArea);
	rad1.addActionListener(this);
	rad2.addActionListener(this);
	rad3.addActionListener(this);
	rad4.addActionListener(this);
	rad5.addActionListener(this);
	rad6.addActionListener(this);
	rad7.addActionListener(this);
	rad8.addActionListener(this);
	rad9.addActionListener(this);
	radc.addActionListener(this);
	rad0.addActionListener(this);
	rade.addActionListener(this);
	setVisible(true);
	
}
public void actionPerformed(ActionEvent event) {

	if(event.getSource() == rad1) {
		txtArea.append("1");

	}
	if(event.getSource() == rad2) {
		txtArea.append("2");
		

	}
	if(event.getSource() == rad3) {
		txtArea.append("3");
		
	}
	if(event.getSource() == rad4) {
		txtArea.append("4");
		

	}
	if(event.getSource() == rad5) {
		txtArea.append("5");
		
	}
	if(event.getSource() == rad6) {
		txtArea.append("6");
		

	}
	if(event.getSource() == rad7) {
		txtArea.append("7");
		
	}
	if(event.getSource() == rad8) {
		txtArea.append("8");
		

	}
	if(event.getSource() == rad9) {
		txtArea.append("9");
		
	}
	if(event.getSource() == radc) {
		txtArea.setText("");
		radc.setEnabled(false);

	}
	if(event.getSource() == rad0) {
		txtArea.append("0");

	}
	if(event.getSource() == rade) {

		if(txtArea.getText().equals("" + password)) {
			System.out.println("correct " + txtArea.getText());
			txtArea.append("\npassword is correct " + txtArea.getText());
			txtArea.append("\nHello mr bond");
			
			screen2();
		}else {
			System.out.println("incorrect " + txtArea.getText());
			txtArea.append("\npassword is incorrect " + txtArea.getText());
			radc.setEnabled(true);
		}
		

	}
	if(event.getSource() == rade2) {
		pnl2.add(txtArea);
		txtArea.setText("get good");
		pnl2.add(rade3);
		rade3.addActionListener(this);
		if(bob == 1) {
		pnl2.remove(txtArea);
		bob = 0;
		}else {
			bob = 1;	
		}

	}
	if(event.getSource() == rade3) {
		pnl2.add(txtArea);
		txtArea.setText("get good stop trying");
		if(bob == 1) {
		pnl2.remove(txtArea);
		bob = 0;
		}else {
			bob = 1;	
		}
	}
}
public void screen2() {
	remove(pnl);
	add(pnl2);
	pnl2.add(txtArea3);
	pnl2.add(rade2);
	rade2.addActionListener(this);
	setSize(500,500);
	txtArea3.append("I like your password , " + password + " it just works");
	if(("" + password).equals("69420")){
		txtArea3.append("\nnice...");
	}
	txtArea3.append("\nthis is a test of your abilitys");
	
}
	public static void main(String[] args) {
		
		gugameww bob = new gugameww();
	}
}
