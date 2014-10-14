
public class Queue {

	private String[] queueArray;
	private int size;
	
	private int first, last, numberOfItems = 0;
	
	Queue(int size) {
		this.size = size;
		queueArray = new String[size];
	}
	
	public void insert(String input){
		if(numberOfItems +1 <= size){
			queueArray[last] = input;
			last++;
			numberOfItems++;
		} else
			System.out.println("Full");
	}
	
	public void priorityInsert(String input){
		int i;
		if(numberOfItems == 0){
			insert(input);
		} else{
			for (i = numberOfItems -1; i >= 0; i--){
				if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])){
					queueArray[i+1] = queueArray[i];
				} else break;
			}
			queueArray[i+1] = input;
			last++;
			numberOfItems++;
		}		
	}
	
	public void remove(){
		if(numberOfItems > 0){
			queueArray[first] = null;
			first++;
			numberOfItems--;
		} else
			System.out.println("Empty");
	}
	
	public String peek(){
		return queueArray[first];
	}
}
