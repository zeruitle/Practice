import java.util.Scanner;

/*
 * Subset Sum
	Given a target value and a list of numbers to pick from, pick numbers from the list such that the 
	numbers picked add up to the target value.
	For example, if given a target value of 150 and a list of numbers to pick from consisting of 1, 2, 100, 22 
	and 28, the correct answer would be 100, 22 and 28 because 100 + 22 + 28 =150. If given a target value 
	of 30 and the sample numbers to pick from were 1, 2, 100, 22 and 28, the correct answer would be 28 
	and 2 because 28 + 2 = 30.
	NOTE: Once you use a number from the list you cannot pick it again.
	NOTE: If no combination of numbers adds up to the requested value, the correct answer is "No 
	combination matches".
	NOTE: There can be more than one correct answer. For example, for target value 3 and list 1, 2 and 3
	the correct answer would be either: 1, 2 or 3. You only need to return 1 correct answer not all of them.
	Write a program that takes a list of numbers from the command line. The first number is the target
	value and the reminder of the numbers (however many there may be) is the set of numbers you have to
	pick from. The program should either output a subset whose sum equals the target or "No combination 
	matches" if no such subset exists. We would prefer you use Java or C# on this program, but you can use 
	another procedural language if you don't know Java or C#.
	For example, the following inputs should yield the following results:
	SubsetSum 15 1 2 3 5 7 10
	{3,7,5}
	SubsetSum 9 1 2 3 5 7 10
	{2,7}
	SubsetSum 100 1 2 3 5 7 10
	No combination matches
 */

//author: Fengrui Yang

public class Denim {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Please enter target number: ");
		int target = scan1.nextInt(); 
		System.out.println("Please enter subset, separate with spaces: ");
		String subset = scan2.nextLine();
		//int target = 8; String subset = "2 3 4 5";
		String Strsubsets[] = subset.split("\\s+");
		int subsets[] = new int[Strsubsets.length];
		for(int i = 0; i < subsets.length; i ++){
			subsets[i] = Integer.parseInt(Strsubsets[i]);
		}
		quickSort(subsets,0,subsets.length-1);
		SubsetSum(target,subsets);
	}
	
	//Knapsack approach, DP
	public static void SubsetSum(int target, int[] subsets){
		int n = subsets.length;
		table V = new table(n+1,target+1);
		//bottom up manner
		for(int i = 0; i <= n; i++){
			for(int w = 0; w <= target; w++){
				if(i == 0 || w == 0) {
					V.set(i,w,0);
				} else if(subsets[i-1] <= w) {
					int a = subsets[i-1] + V.get(i-1,w-subsets[i-1]);
					int b = V.get(i-1,w);
					V.set(i,w,max(a,b));
					if(max(a,b) == a){
						V.setcurrent(i, w, subsets[i-1]);
						V.setprevious(i, w, V.getNode(i-1,w-subsets[i-1]));
					} else {
						V.setprevious(i,w,V.getNode(i-1,w));
					}
				} else {
					//this is the case "2 3 4 5", 6: the last i, 5 is not going to be used
					V.set(i,w,V.get(i-1, w));
					V.setprevious(i,w,V.getNode(i-1,w));
				}
			}
		}
		if(V.get(n,target) != target){
			System.out.println("No combination matches");
		} else {
			table.Node last = V.getNode(n, target);
			while(last != null){
				if(last.current != -1)
					System.out.print(last.current+" ");
				last = last.previous;
			}
		}
	}
	
	public static int max(int a, int b) {
		return (a > b)? a: b;
	}
	
	public static void quickSort(int[] input, int low, int high) {
		int i = low, j = high;
		int pivot = input[low+(high-low)/2];
		while(i <= j) {
			while(input[i] < pivot){
				i++;
			}
			while(input[j] > pivot){
				j--;
			}
			if(i <= j) {
				int tmp = input[i];
				input[i] = input[j];
				input[j] = tmp;
				i++;
				j--;
			}
		}
		if(low < j)
			quickSort(input,low,j);
		if(i < high)
			quickSort(input,i,high);
	}
}
