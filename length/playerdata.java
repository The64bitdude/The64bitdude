package length;

public class playerdata {
	public static String pname = "";
	public static String in = "";
	public static String filname = "";
	public playerdata(){
		
	}
	public static void save(String pname,String ino) {
		filname = pname+".txt";
		in = ino;
		saves sv = new saves(filname,in);
	}
	public static void saveAppend(String pname,String ino)
	{
		filname = pname+".txt";
		in = read(pname) +" *next* "+ ino;
		saves sv = new saves(filname,in);
	}
	public static String read(String pname) {
		filname = pname + ".txt";
		ReadFile rd = new ReadFile(filname);
		return rd.toString();
	}
	public static String delete(String pname) {
		filname = pname+".txt";
		DeleteFile rd = new DeleteFile(filname);
		return rd.toString();
	}
}
