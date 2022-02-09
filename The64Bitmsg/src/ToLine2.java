
import java.util.*;
public class ToLine2 {
	
	public static int[] intToArray(int in) {
		int[] out= new int[length(in)];
		for(int i = out.length; in < 0;i--) {
			int digit = in % 10;
			out[i] = digit;
			in /= 10;
		}
		return out;
	}
	public static int length(int in) {
		int out = 0;
		while(in > 0) {
			out += 1;
			in /= 10;
		}
		return out;
	}
	public static int cToInt(char in) {
		if((in >= 48)&&(in <= 57)) {
		return in - 48;
		}else if((in >= 97)&&(in <= 122)) {
			return in - 96;
		}else if((in >= 65)&&(in <= 90)) {
			return in - 64;
		}else if(in == (32)) {
			return in - 32;
		}
		else {
			return in;
		}
		
	}
	public static int cToInt2(char in) {
		if((in >= 48)&&(in <= 57)) {
		return (in - 48) + 27;
		}else if((in >= 97)&&(in <= 122)) {
			return in - 96;
		}else if((in >= 65)&&(in <= 90)) {
			return in - 64;
		}else if(in == (32)){
			return 0;
		}else {
			return in;
		}
		
	}
	
public static String[] arSum(String[] a,String[] b) {
	String[] out = new String[(a.length)+(b.length)];
	for(int i = 0; i < (a.length+(b.length));i++) {
		if(i > (a.length - 1)){
			out[i] = b[i - a.length];
		}else {
			out[i] = a[i];
		}
	}
	return out;
}
 public static int ToInt(String in) {
	 int out = 0;
	 for(int i = 0;i < in.length();i++) {
		 double l = Math.pow(10,in.length() - i - 1);
		 out += l * cToInt(in.charAt(i));
	 }
	 return out;
 }
 public static int ToIntc(String in) {
	 int out = 0;
	 for(int i = 0;i < in.length();i++) {
		 double l = Math.pow(10,in.length() - i - 1);
		 out += l * in.charAt(i);
	 }
	 return out;
 }
 public static int bToInt(String in) {
	 int out = 0;
	 for(int i = 0;i < in.length();i++) {
		 double l = Math.pow(2,in.length() - i -1);
		 out += l * cToInt(in.charAt(i));
	 }
	 return out;
 }
 public static void printArString(String[] in) {
	 for(int i = 0;i<in.length;i++) {
			System.out.println(i + " " + in[i]);
			}
 }
 public static String bToString(String in) {
	 char[] out = new char[in.length()];
	 int ta = 0;
	int inl = in.length();
	 String outn = "";
	 for(int i = 0;i < inl;i++) {
		 if(in.indexOf(" ") != -1) {
			 int len = in.length();
			 String ouad = in.substring(in.indexOf(" ")+1);
			 if(ouad.indexOf(" ") != -1) {
				 len = ouad.indexOf(" ");
			 }else {
				 len = ouad.length();
			 }
	 out[i] = (char)bToInt(in.substring(0,len));
	 in = in.substring(in.indexOf(" ")+1);
		 }else if((in.indexOf(" ") == -1)&&(ta == 0)){
			 out[i] = (char)bToInt(in);
			 ta = 1;
		 }
	 }
	 for(int i = 0;i < inl;i++) {
		 outn = outn + "" + out[i];
	 }
	 return outn;
 }
 public static String sToBinary(String in) {
	 String out = "";
	 int p = 0;
	 int ol = 0;
	 int[] ou = new int[in.length()];
	 for(int i = 0;i < in.length();i++) {
		 if((in.charAt(i) >= 48)&&(in.charAt(i) <= 57)) {
			 ou[i] = cToInt(in.charAt(i));
			 p++;
			 ol = 1;
		 }
			 if(((i >= in.length()-1)||((in.charAt(i+1) < 48)&&!(in.charAt(i+1) > 57)))&&(p > 0)) {
				 int ina = 0;
				 for(int k = 0;k < p;k++) { 
					 double l = Math.pow(10,p - k - 1);
					ina += (int)l * ou[(i-p)+k+1];
				 }
				 out = out + "" + Integer.toBinaryString(ina);
			 }else if((in.charAt(i) < 48)||(in.charAt(i) > 57)){
				 out = out + Integer.toBinaryString(in.charAt(i)) + " ";
			 }
			
		 
	 }
	 return out;
 }
 public static String sToBinary2(String in) {
	 String out = "";
	 for(int i = 0;i < in.length();i++) {
				 out = out + Integer.toBinaryString(in.charAt(i)) + " ";
	 }
	 return out;
 }
 public static String tillenter(Scanner in) {
	 String out = in.next();
	 int done = 0;
	 String next ="";
	 while( !(next.equals(".."))) {
		 next = in.next();
		 if(!(next.equals(".."))){
		out= out +  " " + next; 
		 }
		done++;
	 }
	 return out;
 }
 public static int aMax(int[] in) {
	 int out = 0;
	 int ma = 0;
	 int sa = 0;
	for(int i = 0;i<in.length;i++) {
		for(int l = 0;l<in.length;l++) {
			if (in[i] > in[l]) {
				ma += 1;
				if( ma >= in.length -1) {
					out = in[i];
				}
			}
			if (in[i] == in[l]) {
				if(sa < in[i]) {
             sa = in[i];	
				}
			}
		}
		ma = 0;
	}
	if((sa != 0)&&(out == 0)) {
		return sa;
	}else {
	return out;
	}
 }
 public static String tillenter2(Scanner in) {
	 String out = in.next();
	 int done = 0;
	 String next ="";
	 while( !(next.equals(",,"))) {
		 next = in.next();
		 if(!(next.equals(",,"))){
		out= out +  " " + next; 
		 }
		done++;
	 }
	 return out;
 }
 public static String sscambel(int code,String in) {
	 String out = "";
	 if(code > in.length()) {
	 for(int i = 0;i < in.length();i++) {
				 out = out + (char)((code-i) + in.charAt(i));
	 }
	 }else { 
		 for(int i = 0;i < in.length();i++) {
			 out = out + (char)((in.length()+4-i ) + in.charAt(i));
 } 
	 }
	 return out;
 }
 public static String dscambel(int code,String in) {
	 String out = "";
	 if(code > in.length()) {
	 for(int i = 0;i < in.length();i++) {
				 out = out + (char)(in.charAt(i) - (code-i));
	 }
	 }else { 
		 for(int i = 0;i < in.length();i++) {
			 out = out + (char)(in.charAt(i) - (in.length()+4-i ));
 } 
	 }
	 return out;
 }
 public static String sToMorse(String in,String[] codes) {
	 String out = "";
 in = in.toLowerCase();
for(int i = 0;i < in.length();i++) {
	int num = cToInt2(in.charAt(i));
	if(i == 0) {
		out = codes[num];
	}else {
		out = out + " " + codes[num];
	}
}
return out;
 }
 public static String mToString(String in,String[] codes) {
	 String out = "";
 in = in.toLowerCase();
 int ln = in.length();
for(int i = 0;i < ln;i++) {
	if(in.indexOf(" ") == -1) {
		for(int l = 0;l < codes.length;l++) {
			if(codes[l].equals(in)&&(l == 0)) {
				out = out + " ";
			}
			else if(codes[l].equals(in)&&(l < 27)) {
				out = out + (char)(l+64);
			}
			else if(codes[l].equals(in)&&(l >= 27)) {
				out = out + (char)(l+48 -27);
			}
		}
		in = "";
	}
	if((in.indexOf(" ") != -1)){
		for(int l = 0;l < codes.length;l++) {
			if(codes[l].equals(in.substring(0,in.indexOf(" ")))&&(l == 0)) {
				out = out + " ";
			}
			else if(codes[l].equals(in.substring(0,in.indexOf(" ")))&&(l < 27)) {
				out = out + (char)(l+64);
			}
			else if(codes[l].equals(in.substring(0,in.indexOf(" ")))&&(l >= 27)) {
				out = out + (char)(l+48 - 27);
			}
		}	

		in = in.substring(in.indexOf(" ")+1);
	}
}
return out;
 }
 public static long sToInt(String in) {
	 long out = 0;
	 for(int i = 0;i < in.length();i++) {
		 double l = Math.pow(10,in.length()*2 -(2*i)-2);
		 out += (l) * cToInt(in.charAt(i));
	 	}
	 return out;
 }
 public static int[] arrev(int[] in) {
		for(int i = 0;i < (int)(in.length/2);i++) {
			int old = in[((in.length-1) - i)];
			in[(in.length-1) - i] = in[i];
			in[i] = old;
		}
		return in;
	}
 public static String arrayToString(int[] in) {
	 String out = "";
	 out+=("{");
		for(int i = 0;i < in.length; i++) {
			out+=(in[i]);
		if(i != (in.length - 1)) {
			out+=(",");
		}
		}
		out+=("}");
		return out;
 }
 public static void main(String[] args) {

 }
}
