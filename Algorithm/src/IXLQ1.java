import java.util.Arrays;


public class IXLQ1 {

	/**
	 * QUESTION #1:

		Write a Java method that takes an array of "sets" of String objects,
		and determines whether _all_ sets in the array are equivalent.

		Each "set" in the input array is represented as an array of String objects, in 
		no particular order, and possibly containing duplicates. Nevertheless, when
		determining whether two of these "sets" are equivalent, you should disregard
		order and duplicates. For example, the sets represented by these arrays are
		all equivalent:

		{"a", "b"}
		{"b", "a"}
		{"a", "b", "a"}

		The signature for your method should be:

		public static boolean allStringSetsIdentical(String[ ][ ] sets)

		Examples of the method in operation:

		allStringSetsIdentical(new String[][] {{"a","b"},{"b","b","a"},{"b","a"}})
		returns true

		allStringSetsIdentical(new String[][] {{"a","b"},{"a"},{"b"}}) returns false
	 */
	
	//Author: Fengrui Yang
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] testcase = new String[][] {{"a","b"},{"b","b","a"},{"a","a","b"}};
		System.out.println(allStringSetsIdentical(testcase));
	}
	
	public static boolean allStringSetsIdentical(String[][] sets){
		String[] newsets = removeDuplicate(sets);
		for(int i = 0; i < newsets.length-1; i++){
			if(newsets[i].length() != newsets[i+1].length())
				return false;
			if(!newsets[i].equals(newsets[i+1]))
				return false;
		}
		return true;
	}
	
	//use ASCII as hash function, remove duplicates and arrage orders
	public static String[] removeDuplicate(String[][] sets){
		String[] result = new String[sets.length];
		Arrays.fill(result,"");
		for(int i = 0; i < sets.length; i++){
			//ASCII
			int[] hash = new int[128];
			for(int j = 0; j <sets[i].length; j++){
				hash[sets[i][j].charAt(0)]++;
			}
			for(int j = 0; j < hash.length; j++){
				if(hash[j] > 0){
					result[i] = result[i] + (char)j;
				}
			}
		}
		return result;
	}

}
