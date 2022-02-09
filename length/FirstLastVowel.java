package length;

public class FirstLastVowel {

	public static String firstLastVowel(String in) {
		String vowels =  "aeiouAEIOU";
		if(vowels.indexOf(in.substring(0,1))!=-1){
			return "yes";
		}
		if(vowels.indexOf(in.substring(in.length()-1))!=-1){
			return "yes";
		}
		else {return "no";}
	}
	public static void main(String[] args) {
		String[] in = {"dog#cat#pigaplus","pigs#apluscompsci#food","##catgiraffeapluscompscI","apluscatsanddogsaplus###","###","Aplusdog#13337#pigaplusprogram","code#H00P#code1234","##wowgira77##eplus","catsandaplusdogsaplus###","7","A","E","9AEIOUaeiou@"};
		for( int i = 0; i < 13; i++) {
		System.out.println(firstLastVowel(in[i]));
		}
	}
}
