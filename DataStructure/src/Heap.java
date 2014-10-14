
public class Heap {
	private String[] heapArray;
	private int items = 0;
	private int size;
	
	public Heap(int size){
		this.size = size;
		heapArray = new String[size];
	}
	
	public void insert(int index, String input){
		heapArray[index] = input;
	}
	
	public void incrementArray(){
		items++;
	}
	
	public void generateFilledArray(int randNum){
		String randomData;
		for (int i = 0; i < this.size; i++) {
			randomData = ""+((Math.random()*randNum) +1);
			this.insert(i, randomData);
			incrementArray();
		}
	}
	
	public String pop() {
		if(items != 0){
			String root = heapArray[0];
			heapArray[0] = heapArray[--items];
			heapTheArray(0);
			return root;
		} else 
			return null;
	}
	
	public void heapTheArray(int index){
		int largestChild;
		String root = heapArray[index];
		while(index < items/2){
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			if(rightChild < items && Integer.parseInt(heapArray[leftChild]) < Integer.parseInt(heapArray[rightChild]))
				largestChild = rightChild;
			else
				largestChild = leftChild;
			if(Integer.parseInt(root) >= Integer.parseInt(heapArray[largestChild]))
			break;
			heapArray[index] = heapArray[largestChild];
			index = largestChild;
		}
		heapArray[index] = root;
	}
	
	public void heapSort() {
		for (int k = size -1; k >= 0; k--){
			String largestNode = pop();
			insert(k,largestNode);
		}
	}
	
}
