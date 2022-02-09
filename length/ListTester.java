package length;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class ListTester {
	public static ArrayList<String> arlist = new ArrayList<String>();
	public static List<Integer> lilist = new LinkedList<Integer>();
	public static List<String> addArray(String[] nums){
		List<String> out = new LinkedList<String>();
		for(int i = 0;i<nums.length;i++) {
			out.add(nums[i]);
		}
		return out;
	}
	public static void main(String[] args) {
		arlist.addAll(addArray(new String[]{"mom","lincon","Bob","Abe","dad","cub"}));
	    Collections.reverse(arlist);
		Collections.sort(arlist);
	    for(int i = 0;i<arlist.size();i++) {
		System.out.println(arlist.get(i));
	    }
	}
}
