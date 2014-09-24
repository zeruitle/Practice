
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
	
	//find parent
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
	public void delete(int key) {
		BSTNode auxRoot = root;
		BSTNode parent = null;
		while (auxRoot != null) {
			//case1: no subtree
			if (auxRoot.left == null && auxRoot.right == null) {
				//if root
				if (root.data == key){
					root = null;
					return;
				}
				//not root
				if (auxRoot.data == key){
					parent = findp(auxRoot);
					if (key < parent.data) {
						parent.left = null;
						return;
					}
					else parent.right = null;
				}
			}
			//case2: one subtree
			//right subtree
			if (auxRoot.left == null) {
				//if root
				if (root.data == key) {
					root = root.right;
					return;
				}
			}
			//case3:
		}
	}
	
	
	
	
	
	
}
