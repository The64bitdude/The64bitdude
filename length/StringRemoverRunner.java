package length;
import java.util.*;
public class StringRemoverRunner
{
	public static void main( String args[] )
	{
		Scanner ina = new Scanner(System.in);
		String sen = ina.next();
		String rem = ina.next();
		StringRemover in = new StringRemover(sen,rem);
		System.out.println(sen +" - String to remove "+rem);
		System.out.println(in.toString());
	}
}
