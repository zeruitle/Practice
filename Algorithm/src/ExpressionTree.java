import java.util.Stack;


public class ExpressionTree {

	/**
	 * @param args
	 */
	
	class Node {
		String data;
		Node left, right;
		
		public Node(String data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	class Expression{
		Node root;
	}
	
	private Stack NodeStack = new Stack();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "a?b?c:f:d?e:g";
	}
	
	public static void parse(String[] input){
		//find the last ?
		for(int i = input.length - 1; i > 0; i--){
			if(input[i].equals("?")){
				
			}
		}
	}
}
