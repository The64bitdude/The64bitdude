package length;

import java.util.Scanner;

public class autofiledecode {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("say fcode(encode a file) code(encode a new file) or decode[notcasesensetive](decode a file)");
		String awnser = in.next();
		boolean enc = false;
		boolean add = false;
		if(awnser.equals("code")) {
			System.out.println("are you adding to a old file?(disables encrypetion)");
			String e = in.next();
			e = e.toLowerCase();
			if((e.equals("true"))||(e.equals("t"))||(e.equals("yes"))||(e.equals("y"))||(e.equals("greater"))) {
				add = true;
			}else {
			System.out.println("do you want the new file encoded");
			e = in.next();
			e = e.toLowerCase();
			if((e.equals("true"))||(e.equals("t"))||(e.equals("yes"))||(e.equals("y"))||(e.equals("greater"))) {
				enc = true;
			}
			}
			System.out.println("pass");
		int code = ToLine.ToIntc(in.next());
		System.out.println("what is the file name");
		String name = in.next();
		System.out.println("put a dubble period at the end with a space to finish");
		System.out.println("what want to code");
		String message = ToLine.tillenter(in);
		if(add) {
		if(enc) {
		playerdata.saveAppend(name,ToLine.sscambel(code,message));
		}else {
		playerdata.saveAppend(name,message);
		}
		}else {
			if(enc) {
				playerdata.save(name,ToLine.sscambel(code,message));
				}else {
				playerdata.save(name,message);
				}
		}
		System.out.println("it is done");
		}else if(awnser.equals("fcode")){
			System.out.println("pass");
			int code = ToLine.ToIntc(in.next());
			System.out.println("what is the file name");
			String name = in.next();
			playerdata.save(name,ToLine.sscambel(code,playerdata.read(name)));
			System.out.println("it is done");
		}else {
		System.out.println("pass");
		int code = ToLine.ToIntc(in.next());
		System.out.println("what file do you want to uncode");
		String filename = in.next();
		System.out.println(ToLine.dscambel(code,playerdata.read(filename)) + "\n");
		System.out.println(playerdata.delete(filename));
		}
	}
}
	
