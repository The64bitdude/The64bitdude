package length;

import java.awt.Desktop;  
import java.io.*;  
public class openDesktopFile   
{  
	public String fileName = "";
	public static void main(String[] args) {
		openDesktopFile fi = new openDesktopFile();
	}
	public openDesktopFile()   
	{  
		String in = "/Users/s214714/Desktop/ciara_for.jpg";
		fileName = in;
	try  
	{  
	//constructor of file class having file as argument  
	File file = new File(in);   
	if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
	{  
	System.out.println(fileName);  
	return;  
	}  
	Desktop desktop = Desktop.getDesktop();  
	if(file.exists())         //checks file exists or not  
	desktop.open(file);              //opens the specified file  
	}  
	catch(Exception e)  
	{  
	e.printStackTrace();  
	}  
	} 
	
	
	
	
	
	
public openDesktopFile(String in)   
{  
	fileName = in;
try  
{  
//constructor of file class having file as argument  
File file = new File(in);   
if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
{  
System.out.println(fileName);  
return;  
}  
Desktop desktop = Desktop.getDesktop();  
if(file.exists())         //checks file exists or not  
desktop.open(file);              //opens the specified file  
}  
catch(Exception e)  
{  
e.printStackTrace();  
}  
}  
}  