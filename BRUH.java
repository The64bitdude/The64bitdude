package length;

import allgamesinone.Binary;

public class BRUH {
	public static String only2(int ix, String str){

		return str.substring(ix,ix+2);
		}
	public static void only1(int ix, String str){

		System.out.println(str.substring(ix,ix+2));
		}

	public static void main(String[] args) {
		only1(1,"bob");
		System.out.println(only2(1,"bob"));
	}
}
