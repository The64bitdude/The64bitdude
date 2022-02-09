package length;

import java.util.Scanner;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter 1st monster's name : ");
		String n1 = keyboard.next();
		System.out.print("Enter 1st monster's size : ");
		int s1 = keyboard.nextInt();
		System.out.print("Enter 2nd monster's name : ");
		String n2 = keyboard.next();
		System.out.print("Enter 2nd monster's size : ");
		int s2 = keyboard.nextInt();
		Monster m1 = new Monster(n1,s1);
		Monster m2 = new Monster(n2,s2);
		System.out.println();
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		if(m1.isBigger(m2)) {
			System.out.println("Monster one is bigger than Monster two");
		}
		else if(m1.isSmaller(m2)) {
			System.out.println("Monster one is smaller than Monster two");
		}
		if(m1.namesTheSame(m2)) {
			System.out.println("Monster one has the same name as Monster two");
		}
		
	}
}
