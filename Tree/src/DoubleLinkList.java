
public class DoubleLinkList {
	public class Link {
		public String data;
		
		public Link next;
		public Link previous;
		
		public Link(Link previous, String data, Link next){
			this.previous = previous;
			this.data = data;
			this.next = next;
		}
		
		public void display(){
			System.out.println("data: "+data);
		}
		
		public String toString(){
			return data;
		}
	}
	
	public class Iterator{
		Link cursor;
		boolean valid;
		
		public Iterator(DoubleLinkList theList){
			valid = true;
			cursor = sentinel;
			next();
		}
		
		public void next(){
			if(valid){
				cursor = cursor.next;
				if (cursor == sentinel)
					valid = false;
			}
		}
		
		public boolean hasNext(){
			return valid;
		}
	}
	
	public int size = 0;
	public Link sentinel;
	
	public DoubleLinkList(){
		size = 0;
		sentinel = new Link(null, null, null);
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
	}
	
	public void insertFirst(String data) {
		sentinel.next = new Link(sentinel, data, sentinel.next);
		sentinel.next.next.previous = sentinel.next;
		size++;
	}
	
	public void insertLast(String data) {
		sentinel.previous = new Link(sentinel.previous, data, sentinel);
		sentinel.previous.previous.next = sentinel.previous;
		size++;
	}
	
	public void delete(Link victim){
		victim.next.previous = victim.previous;
		victim.previous.next = victim.next;
		size--;
	}
	
	public void delete(String data){
		Link victim = find(data);
		victim.next.previous = victim.previous;
		victim.previous.next = victim.next;
		size--;
	}
	
	public Link find(String data){
		Link linkReference = sentinel;
		if(size > 0){
			while(linkReference.data != data){
				if(linkReference.next == sentinel){
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
}
