package main;


import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChatSiteLogin")
public class ChatSiteLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String lastName = req.getParameter("lastName");
        String emailId = req.getParameter("emailId");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<form>\n" + " <input type=\"button\" value=\"HOME\" onclick=\"history.back()\">\n" + "</form>");
        printWriter.print("<h1>Your Login info</h1>");
        printWriter.print("<p> username :: " + username + "</p>");
        printWriter.print("<p> lastName :: " + lastName + "</p>");
        printWriter.print("<p> emailId :: " + emailId + "</p>");
        printWriter.print("<p> password :: " + password + "</p>");
        switch(username) {
        
        case "KFC" :printWriter.print("<img src=\"images/KFC.png\" alt=\"KFC\">");break;
        case "PEPSI" :printWriter.print("<img src=\"images/PEPSI.png\" alt=\"PEPSI\">");break;
        }
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
        resp.setContentType("image/html");

        System.out.println("username :: " + username);
        System.out.println("lastName :: " + lastName);
        System.out.println("emailId :: " + emailId);
        System.out.println("password :: " + password);
    }
}