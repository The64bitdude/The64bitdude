package Main;
//Author the64bitdude made in jan 9 2022 
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ImageServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(2000);
		Socket s = server.accept();
		ObjectOutputStream dos = new ObjectOutputStream(s.getOutputStream());
		
		String FileName = "/Users/s214714/Desktop/ciara_for.jpg";
		File file = new File(FileName);
		dos.writeUTF("AMesAgeGoiNGTrough1!#&T$@%");
		dos.writeUTF("test");
		dos.writeUTF("ImageGoingThrough1515%34189%");
		dos.writeObject(file);
		dos.writeUTF("AMesAgeGoiNGTrough1!#&T$@%");
		dos.writeUTF("test");
	}
}
