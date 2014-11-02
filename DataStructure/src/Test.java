import java.util.HashMap;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for (int i = 0; i < 100 ; i++){
		//System.out.println(i+" "+ifPow2(i));}
		//System.out.println(parity(null));
		//countString("asasd!!!!!#######");
		BST tree = new BST();
		for(int i = 0; i< 10; i++){
			tree.add(i);
		}
		tree.delete(3);
		//System.out.println(tree.left().data);
		//System.out.println(tree.root.data+" "+tree.returnfind(4).data+" "+tree.returnfind(1).data);
		//System.out.println((tree.commonAncestor(tree.root,tree.returnfind(4),tree.returnfind(1))).data);
	}
	
	public static HashMap countString(String input){
		//use hashtable for threads
		HashMap<Character, Integer> result = new HashMap<Character, Integer>();
		//128 size for standard ascii code, change size for different coding
		int[] tmp = new int[128];
		for (char c : input.toCharArray()){
			tmp[(int)c]++;
		}
		for(int i = 0; i <tmp.length; i++){
			if(tmp[i] > 1)
				result.put((char)i,tmp[i]);
		}
		return result;
	}
	
	public static int factorial(int input){
		int result = 1;
		for (int i = 1; i <= input; i++){
			result = result * i;
		}
		return result;
	}
	
	//input = n where n!
	public static int trailing(int input){
		int result = 0;
		for(int i = 1; Math.pow(5,i) < input; i++ ){
			result = result + (int) (input/Math.pow(5,i));
		}
		return result;
	}
	
	public static boolean ifPow2(int value){
		return (value != 0 && (value & -value) == value);
	}
	
	public static String parity(String msg){
		if(msg!=null){
		String parityStr = null;
		int n = msg.hashCode();
		System.out.println(n);
		switch(n%2)
		{
			case 0:
				parityStr = "even";
				break;
			case 1:
				parityStr = "odd";
				break;
		}
		return parityStr;} else
			return "no input";
	}

}
