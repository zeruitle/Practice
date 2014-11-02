import java.util.HashMap;

//No parent pointer, no repeat value
public class LCA {

	/**
	 * @param args
	 */
	//key: node value, value: position
	//HashMap<Integer,Integer> inHash = new HashMap<Integer, Integer>();
	//HashMap<Integer,Integer> postHash = new HashMap<Integer, Integer>();
	int size = 0;
	Node[] inHash, postHash;
	
	public class Node {
		int data;
		Node left,right;
	}
	
	private void preorder(Node x) {
		if(x == null) return;;
		size++;
		preorder(x.left);
		preorder(x.right);
	}
	
	private void inorder(Node x, int position){
		if(x == null) return;
		inorder(x.left, position++);
		inHash[position] = x;
		inorder(x.right, position++);
	}
	
	private void postorder(Node x, int position){
		if(x == null) return;
		postorder(x.left, position++);
		postorder(x.right, position++);
		inHash[position] = x;
	}
	
	public Node commonAncestor(Node root, Node p, Node q){
		preorder(root);
		inHash = new Node[size];
		postHash = new Node[size];
		inorder(root, 0);
		postorder(root, 0);
		int inP=0, inQ=0, postP=0, postQ=0;
		for(int i = 0; i < inHash.length; i++){
			if(inHash[i].equals(p))
				inP = i;
			if(inHash[i].equals(q))
				inQ = i;
			if(postHash[i].equals(p))
				postP = i;
			if(postHash[i].equals(p))
				postQ = i;
		}
		int inCandidate = 0, postCandidate = 0;
		int[] in = new int[inQ - inP];
		int[] post = new int[postHash.length - postQ];
		if(inP < inQ && postP < postQ){
			
		}
		
		if(inP < inQ && postP < postQ){
			if(inP == inQ -1)
				return inHash[inQ];
			for(inCandidate = inQ -1; inCandidate > inP; inCandidate--){
				for(postCandidate = postHash.length-1; postCandidate > postQ; postCandidate--){
					if(inHash[inCandidate].equals(postHash[postCandidate]))
						return inHash[inCandidate];
				}
			}
		}
		if(inP < inQ && postP > postQ){
			if(inP == inQ -1)
				return inHash[inQ];
			for(inCandidate = inQ -1; inCandidate > inP; inCandidate--){
				for(postCandidate = postHash.length-1; postCandidate >postP; postCandidate--){
					if(inHash[inCandidate].equals(postHash[postCandidate]))
						return inHash[inCandidate];
				}
			}
		}
		if(inP > inQ && postP < postQ){
			if(inQ == inP -1)
				return inHash[inP];
			for(inCandidate = inP -1; inCandidate > inQ; inCandidate--){
				for(postCandidate = postHash.length-1; postCandidate > postQ; postCandidate--){
					if(inHash[inCandidate].equals(postHash[postCandidate]))
						return inHash[inCandidate];
				}
			}
		}
		if(inP > inQ && postP > postQ){
			if(inQ == inP -1)
				return inHash[inP];
			for(inCandidate = inP -1; inCandidate > inQ; inCandidate--){
				for(postCandidate = postHash.length-1; postCandidate >postP; postCandidate--){
					if(inHash[inCandidate].equals(postHash[postCandidate]))
						return inHash[inCandidate];
				}
			}
		}
		return null;
	}
}
