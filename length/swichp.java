package length;

public class swichp {

	public static void main(String[] args) {
		int num = (int)(Math.random()*10)+1;
		switch(num) {
		case 1 : System.out.println((num*10) + "% is super failure");break;
		case 2 : System.out.println((num*10) + "% is extra failure");break;
		case 3 : System.out.println((num*10) + "% is very bad, failure");break;
		case 4 : System.out.println((num*10) + "% is not even half, failure");break;
		case 5 : System.out.println((num*10) + "% is only half, failure");break;
		case 6 : System.out.println((num*10) + "% is not 100, failure");break;
		case 7 : System.out.println("failures is basically " + (num*10)+"%");break;
		case 8 : System.out.println("failures get " + (num*10)+"%");break;
		case 9 : System.out.println("failure you only get " + (num*10)+"%");break;
		case 10 : System.out.println("you get " + (num*10)+"%" + " ok but not good enough");
		}
	}
}
