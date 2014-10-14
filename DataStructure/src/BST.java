
public class BST {
	private class BSTNode {
		public int data;
		public BSTNode left,right;
		
		public BSTNode(BSTNode left, int data, BSTNode right) {
			this.left = left;
			this.data = data;
			this.right = right;
		}
	}
	
	private BSTNode root;
	private int size;
	
	//initialize
	public BST() {
		root = null;
		size = 0;
	}
	
	//iterative lookup
	public boolean ifind(int key) {
		BSTNode auxRoot = root;
		while (auxRoot != null) {
			if (auxRoot.data == key)
				return true;
			if (key < auxRoot.data)
				auxRoot = auxRoot.left;
			else auxRoot = auxRoot.right;
		}
		return false;
	}
	
	//recursion lookup
	public boolean rfind(int key) {
		return rfindAux(key, root);
	}
	
	private boolean rfindAux(int key, BSTNode auxRoot) {
		if (auxRoot==null) return false;
		return (auxRoot.data == key
				|| key <auxRoot.data && rfindAux(key, auxRoot.left)
				|| key >auxRoot.data && rfindAux(key, auxRoot.right));
	}
	
	//return node
	public BSTNode returnfind(int key) {
		BSTNode auxRoot = root;
		while (auxRoot != null) {
			if (auxRoot.data == key)
				return auxRoot;
			if (key < auxRoot.data)
				auxRoot = auxRoot.left;
			else auxRoot = auxRoot.right;
		}
		return null;
	}
	
	//return parent
	public BSTNode findp(BSTNode child) {
		BSTNode parent = null;
		BSTNode auxRoot = root;
		while (auxRoot != null) {
			if (auxRoot.data == child.data)
				return parent;
			if (child.data < auxRoot.data) {
				parent = auxRoot;
				auxRoot = auxRoot.left;
			}
			else {
				parent = auxRoot;
				auxRoot = auxRoot.right;
			}
		}
		return null;
	}
	
	//add
	public void add(int foo) {
		BSTNode auxRoot = root;
		while (auxRoot != null) {
			if (auxRoot.data == foo) {
				System.out.println("repeat input");
				return;
			}
			if (foo < auxRoot.data)
				if (auxRoot.left == null) {
					auxRoot.left = new BSTNode(null,foo,null);
					return;
				} else
					auxRoot = auxRoot.left;
			else
				if (auxRoot.right == null) {
					auxRoot.right = new BSTNode(null,foo,null);
					return;
				} else
					auxRoot = auxRoot.right;
		}
	}
	
	//recursion add
	public BSTNode radd(int foo, BSTNode auxRoot) {
		if (auxRoot.data == foo) return auxRoot;
		if (auxRoot == null) return new BSTNode(null,foo,null);
		if (foo < auxRoot.data)
			return new BSTNode(radd(foo,auxRoot.left),auxRoot.data,auxRoot.right);
		else
			return new BSTNode(auxRoot.left,auxRoot.data,radd(foo,auxRoot.right));
	}
	
	//deletion
	//http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/BST-delete.html
	//http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/BST-delete2.html
	public void delete(int key) {
		BSTNode parent = null;
		BSTNode successor = null;
		BSTNode victim = returnfind(key);
		//if not found
		if (victim == null)
			return;
		//case1: no subtree
		if (victim.left == null && victim.right == null) {
			//if root
			if (victim == root){
				root = null;
				return;
			}
			//not root
			parent = findp(victim);
			if(parent.left == victim)
				parent.left = null;
			else
				parent.right = null;
			return;
		}
		//case2: one subtree
		//right subtree
		if (victim.left == null) {
			//if root
			if (victim == root) {
				root = root.right;
				return;
			}
			parent = findp(victim);
			if (parent.left == victim)
				parent.left = victim.right;
			else
				parent.right = victim.right;
			return;
		}
		//left subtree
		if (victim.right == null) {
			//if root
			if(victim == root) {
				root = root.left;
				return;
			}
			parent = findp(victim);
			if (parent.left == victim)
				parent.left = victim.left;
			else
				parent.right = victim.left;
			return;
		}
		//case3: two subtree
		if (victim.right.left == null) {
			//special case, right node of victim is the successor
			victim.data = victim.right.data;
			victim.right = victim.right.right;
			return;
		}
		successor = victim.right;
		BSTNode succP = victim;
		
		//find successor node of node victim
		while (successor.left != null) {
			succP = successor;
			successor = successor.left;
		}
		victim.data = successor.data;
		succP.left = successor.right;
	}
	
	
	
	
	
	
}
