
public class Stack {
	private String[] stackArray;
	private int size;
	
	private int topOfStack = -1;
	
	Stack(int size){
		this.size = size;
		stackArray = new String[size];
	}
	
	public void push(String input){
		if(topOfStack+1 < size){
			topOfStack++;
			stackArray[topOfStack] = input;
		} else System.out.println("Full");
	}
	
	public String pop(){
		if(topOfStack >= 0){
			stackArray[topOfStack] = null;
			return stackArray[topOfStack--];
		} else {
			System.out.println("Empty");
			return null;
		}
	}
	
	public String peek(){
		return stackArray[topOfStack];
	}
}
