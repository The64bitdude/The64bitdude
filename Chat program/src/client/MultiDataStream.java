package client;

import java.io.File;
import java.io.InputStream;

public class MultiDataStream {

	public String msg = "";
	public File file;
	public MultiDataStream() {
		
	}
	public void setFile(File flin) {
		file = flin;
	}
	public void setMsg(String msgin) {
		msg = msgin;
	}
	public File getFile() {
		return file;
	}
	public String getMsg() {
		return msg;
	}
}
