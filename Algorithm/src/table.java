import java.util.Arrays;

public class table {

	/**
	 * @param args
	 */
	//this is not a tree, its a table with a pointer to the previous value
	//Using Knapsack formula V[i,w] = max(V[i-1,w], vi + V[i-1,w - wi]
	//current = vi, previous = V[i-1,w - wi]
			public class Node {
				int data, current;
				Node previous;
				
				public Node(int current, int data, Node previous){
					this.current = current;
					this.data = data;
					this.previous = previous;
				}
			}
			
			Node v[][];
			
			public table(int n, int target){
				v = new Node[n][target];
			}
			
			public void set(int i, int w, int value){
				v[i][w] = new Node(-1,value,null);
			}
			
			public void setcurrent(int i, int w, int current){
				if(v[i][w] != null)
					v[i][w].current = current;
			}
			
			public void setprevious(int i, int w, Node previous){
				if(v[i][w] != null)
					v[i][w].previous = previous;
			}
			
			public int get(int i, int w){
				return v[i][w].data;
			}
			
			public Node getNode(int i, int w){
				return v[i][w];
			}		
}
