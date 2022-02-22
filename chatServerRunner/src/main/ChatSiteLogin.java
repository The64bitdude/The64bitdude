package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.imageio.ImageWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChatClientLogin")
public class ChatSiteLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String yes = req.getParameter("yes");
		if(yes !=null) {
		/*try {
			chatProgramWeb e = new chatProgramWeb();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		}
		String entry = req.getParameter("entry");
		String old = "";
		String htmlcon = "";
		if(yes != null) {
		try {
			File f = new File("/Users/s214714/eclipse-workspace/chatServerRunner/WebContent/textchat.txt");
		Scanner r = new Scanner(f);
		while(r.hasNextLine()) {
			String line = r.nextLine();
			old+= line +"\n";
			htmlcon += "<p>"+line+"<p>";
			switch(line) {
	        
	        case "KFC" :htmlcon+="<img src=\"images/KFC.png\" alt=\"KFC\">";break;
	        case "PEPSI" :htmlcon+="<img src=\"images/PEPSI.png\" alt=\"PEPSI\">";break;
	        }
		}
		if(entry != "") {
		FileWriter w = new FileWriter(f);
		w.write(old +entry+"\n");
		w.close();
		r.close();
		}
		}catch(FileNotFoundException e) {
			if(entry != "") {
		FileWriter w = new FileWriter("/Users/s214714/eclipse-workspace/chatServerRunner/WebContent/textchat.txt");
		w.write(entry + "\n");
		w.close();
			}
		}
		}else {
			if(entry != "") {
			FileWriter w = new FileWriter("/Users/s214714/eclipse-workspace/chatServerRunner/WebContent/textchat.txt");
			w.write(entry + "\n");
			w.close();
			}
		}
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html>");
		printWriter.print(htmlcon + "<p>" + entry + "<p>");
		printWriter.print(" <meta http-equiv=\"refresh\" content=\"5; url =\n" + 
				"    http://10.209.59.116:4242/websitetest/ChatClientLogin?entry=&yes=yes\" />");
		printWriter.print("<form action=\"http://10.209.59.116:4242/websitetest\">\n" + 
				"    <input type=\"submit\" value=\"go back\" />\n" + 
				"</form>");
		printWriter.print("</html>");
		printWriter.close();
	}
}