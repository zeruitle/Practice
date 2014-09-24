
public class BST2 {
	private class Node {
	    public int data;
	    public Node left,right;

	    public Node(Node left,int data,Node right) {
	      this.left = left;
	      this.data = data;
	      this.right = right;
	    }
	  }

	  private Node root;
	  private int size;

	  public BST2() {
	    root = null;  size = 0;
	  }

	  public boolean ifind(int desire) {
	    Node c = root;
	    while (c != null) {
	      if (c.data == desire)
	        return true;
	      if (desire < c.data)
	        c = c.left;
	      else c = c.right;
	    }

	    return false;
	  }

	  public boolean rfind(int desire) {
	    return findAux(desire,root);
	  }

	  private boolean findAux(int desire, Node c) {
	    if (c==null) return false;
	    return (c.data == desire
	        || desire < c.data && findAux(desire,c.left)
	        || desire > c.data && findAux(desire,c.right));
	  }

	  public void add(int foo) {
	    Node c = root;
	    while (c != null) {
	      if (c.data == foo) return;
	      if (foo < c.data)
	        if (c.left == null) {
	          c.left = new Node(null,foo,null);
	          return;
	        } else
	          c = c.left;
	      else 
	        if (c.right == null) {
	          c.right = new Node(null,foo,null);
	          return;
	        } else
	          c = c.right;
	    }
	  }

	  public Node addf(int foo, Node c) {
	    if (c.data == foo) return c;
	    if (c == null) return new Node(null,foo,null);
	    if (foo < c.data)
	      return new Node(addf(foo,c.left),c.data,c.right);
	    else
	      return new Node(c.left,c.data,addf(foo,c.right));
	  }

	  public void delete(int victim) {
	    Node c = root;
	    Node p = null;
	    while (c != null) {
	      if (c.data == victim) {
	        if (c.left == null && c.right == null) {
	          if (p==null) 
	            root = null;
	          else if (victim < p.data)
	            p.left = null;
	          else p.right = null;
	          return;
	        }
	        if (c.left == null) {
	          if (p==null) 
	            root = c.right;
	          else if (victim < p.data)
	            p.left = c.right;
	          else p.right = c.right;
	          return;
	        }
	        // same thing but for c.right

	        pred = goRight(c.left);
	        delete(pred);
	        c.data = pred;
	    }

	    private int goRight(Node c) {
	      if (c.right == null)
	        return c.data;
	      else return goRight(c.right);
	    }

}

	    
	    
	    if ( p.left == null )    // If true, p has a right subtree
	       {
	          /* ========================================
		     Handle special situation: p is the root
		     ========================================= */
	          if ( p == root )
	          {
	             root = root.right;  // After root is deleted, BST = right tree of root
	             return;
	          }

	          parent = myParent;     // myParent was set by findNode(x)....

	          /* ----------------------------------------------
	             Link p's RIGHT subtree to the parent node
	             ---------------------------------------------- */
	          if ( parent.left == p )
	          {  // Hang p's RIGHT tree to parent.left

	             parent.left  = p.right;   // Link p's right subtree to parent left
	          }
	          else
	          {  // Hang p's RIGHT tree to parent.right

	             parent.right = p.right;   // Link p's right subtree to parent right   
		  }

	          return;
	       }

	       /* ==================================================
	          We must do the same when p has a LEFT subtree

	          Case 1b: p has a left subtree
		  ================================================== */
	       if ( p.right == null )                 // If true, p has a left child
	       {
	          if ( p == root )
	          {
	             root = root.left;
	             return;
	          }

	          parent = myParent;     // myParent was set by findNode(x)....

	          /* ----------------------------------------------
	             Link p's left child as p's parent child
	             ---------------------------------------------- */
	          if ( parent.left == p )
	             parent.left = p.left;
	          else
	             parent.right = p.left;

	          return;
	       }