package accounts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {

//		System.out.println(romanToInt("MCMXCIV"));
		String []s = {"flower","flow","fight"};
		String []s2={"cir","car"};
		System.out.println(longestCommonPrefix(s));
		System.out.println(longestCommonPrefix(s2));
	}

	 public static String longestCommonPrefix(String[] strs) {
		    Arrays.sort(strs);
	        String s1 = strs[0];
	        String s2 = strs[strs.length-1];
	        int idx = 0;
	        while(idx < s1.length() && idx < s2.length()){
	            if(s1.charAt(idx) == s2.charAt(idx)){
	                idx++;
	            } else {
	                break;
	            }
	        }
	        return s1.substring(0, idx);
			 
	    }

	static int romanToInt(String s) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		
		List<String> sList=Arrays.asList(s.split(""));
		Integer sum=0;
		for (int i = 0; i < sList.size(); i++) {
			if(i!=sList.size()-1&&map.get(sList.get(i))>map.get(sList.get(i+1))) {
				sum+=map.get(sList.get(i))-map.get(sList.get(i+1));
				i=i+1;
			}else {
			sum+=map.get(sList.get(i));
			}
		}
		return sum;
	}
}
