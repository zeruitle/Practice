
public class LinkList {
	
	public class Link {
		
		public String data;
		
		public Link (String data) {
			this.data = data;
		}
		
		public Link next;
		
		public void display() {
			System.out.println("data: "+data);
		}
		
		public String toString() {
			return data;
		}
	}
	
	public Link first;
	
	public LinkList () {
		first = null;
	}
	
	public boolean isEmpty() {
		return(first == null);
	}
	
	public void insert(String data){
		Link newLink = new Link(data);
		newLink.next = first;
		first = newLink;
	}
	
	//remove first
	public Link remove(){
		Link linkReference = first;
		if(!isEmpty()) {
			first = first.next;
		} else {
			System.out.println("Empty LinkedList");
		}
		
		return linkReference;
	}
	
	public void display() {
		Link linkReference = first;
		while(linkReference != null){
			linkReference.display();
			System.out.println("Next Link: "+linkReference.next);
			linkReference = linkReference.next;
			System.out.println();
		}
	}
	
	//find exact link
	public Link find(String data) {
		Link linkReference = first;
		if(!isEmpty()){
			while(linkReference.data != data){
				if(linkReference.next == null){
					return null;
				} else {
					linkReference = linkReference.next;
				}
			}
		} else {
			System.out.println("Empty LinkedList");
		}
		return linkReference;
	}

	//remove exact link
	public Link remove(String data) {
		Link current = first;
		Link previous = first;
		while(current.data != data){
			if (current.next == null){
				return null;
			} else{
				previous = current;
				current = current.next;
			}
		}
		//situation 1, first is the one need to remove
		if(current == first){
			first = first.next;
		} else {
			//situation 2, other link need to remove
			previous.next = current.next;
		}
		return current;
	}	
}
