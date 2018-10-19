/* The Splay Tree is a variation of the Binary Search Tree
 * IE the leftCh child is smaller and the rightCh child is greater
 * leftCh most item would necessarily be the smallest and the rightCh
 * most will be the biggest item.
 */

public class SplayEdit {

	// BST helper node data type
	private SplayNode head;   // head of the BST

	public SplayEdit() {
		head = null;
	}

	void insert(int num) {

		SplayNode tempRoot = head;
		SplayNode p = null;
		while (tempRoot != null) {
			p = tempRoot;
			if (num < p.getKey()) {
				tempRoot = tempRoot.getLeftCh();
			} else {
				tempRoot = tempRoot.getRightCh();
			}
		}
		tempRoot = new SplayNode();
		tempRoot.setKey(num);
		tempRoot.setParent(p);

		if (p == null) {
			head = tempRoot;
		} else if (num < p.getKey()) {
			p.setLeftCh(tempRoot);
		} else {
			p.setRightCh(tempRoot);
		}
		Splay(tempRoot);
	}

	/* Rotates the node with the parent node rotating it leftCh. */
	private void makeLeftChildParent(SplayNode c, SplayNode p)
	{
		if ((c == null) || (p == null) || (p.getLeftCh() != c) || (c.getParent() != p))
			throw new RuntimeException("WRONG");

		if (p.getParent() != null)
		{
			if (p == p.getParent().getLeftCh())
				p.getParent().setLeftCh(c);
			else
				p.getParent().setRightCh(c);
		}
		if (c.getRightCh() != null)
			c.getRightCh().setParent(p);

		c.setParent(p.getParent());
		p.setParent(c);
		p.setLeftCh(c.getRightCh());
		c.setRightCh(p);
	}

	/* Rotates the node with the parent node rotating it rightCh. */
	private void makeRightChildParent(SplayNode c, SplayNode p)
	{
		if ((c == null) || (p == null) || (p.getRightCh() != c) || (c.getParent() != p))
			throw new RuntimeException("WRONG");
		if (p.getParent() != null)
		{
			if (p == p.getParent().getLeftCh())
				p.getParent().setLeftCh(c);
			else
				p.getParent().setRightCh(c);
		}
		if (c.getLeftCh() != null)
			c.getLeftCh().setParent(p);
		c.setParent(p.getParent());
		p.setParent(c);
		p.setRightCh(c.getLeftCh());
		c.setLeftCh(p);
	}

	/* Splay Function that calls upon the zig, zigzag or zigzig function. */
	private void Splay(SplayNode x)
	{
		while (x.getParent() != null)
		{
			SplayNode Parent = x.getParent();
			SplayNode GrandParent = Parent.getParent();
			if (GrandParent == null)
			{
				if (x == Parent.getLeftCh())
					makeLeftChildParent(x, Parent);
				else
					makeRightChildParent(x, Parent);
			}
			else
			{
				if (x == Parent.getLeftCh())
				{
					if (Parent == GrandParent.getLeftCh())
					{
						makeLeftChildParent(Parent, GrandParent);
						makeLeftChildParent(x, Parent);
					}
					else
					{
						makeLeftChildParent(x, x.getParent());
						makeRightChildParent(x, x.getParent());
					}
				}
				else
				{
					if (Parent == GrandParent.getLeftCh())
					{
						makeRightChildParent(x, x.getParent());
						makeLeftChildParent(x, x.getParent());
					}
					else
					{
						makeRightChildParent(Parent, GrandParent);
						makeRightChildParent(x, Parent);
					}
				}
			}
		}
		head = x;
	}

	/* Function that initializes the function to delete the element
	 * we are wanting to delete from the Splay Tree. */
	void delete(int num)
	{
		SplayNode temp = isDuplicate(num);
		deleteNum(temp);
	}

	/* Function that traverses through the Splay tree to delete the
	 * element. */
	private void deleteNum(SplayNode node)
	{
		// Checks if Splay Tree is empty.
		if (node == null)
			return;

		Splay(node);
		if( (node.getLeftCh() != null) && (node.getRightCh() !=null))
		{
			SplayNode min = node.getLeftCh();
			while(min.getRightCh() !=null)
				min = min.getRightCh();

			min.setRightCh(node.getRightCh());
			node.getRightCh().setParent(min);
			node.getLeftCh().setParent(null);
			head = node.getLeftCh();
		}
		else if (node.getRightCh() != null)
		{
			node.getRightCh().setParent(null);
			head = node.getRightCh();
		}
		else if( node.getLeftCh() !=null)
		{
			node.getLeftCh().setParent(null);
			head = node.getLeftCh();
		}
		else
		{
			head = null;
		}
		node.setParent(null);
		node.setLeftCh(null);
		node.setRightCh(null);
	}

	/* Boolean Function that calls the isDuplicate function to check if our
	 * key we are looking for is in the Tree*/
	boolean search(int key)
	{
		return isDuplicate(key) != null;
	}

	/* Checks to see if the Integer being inserted into the Splay Tree is a duplicate
	 * of an element that is already in the Splay Tree */
	private SplayNode isDuplicate(int key)
	{
		SplayNode temp = head;
		while (temp != null) {
			if (key < temp.getKey()) {
				temp = temp.getLeftCh();
			}
			else if (key > temp.getKey()) {
				temp = temp.getLeftCh();
			}
			else {
				return temp;
			}
		}
		return null;
	}

	/* Function that calls the inorder Print function*/
	void inorder()
	{
		inorderPrint(head);
	}

	/* Function that prints out the nodes in the Splay Tree
	 * in - order from rightCh to leftCh. */
	private void inorderPrint(SplayNode root)
	{
		if (root != null)
		{
			//recursive call to check the rightCh side of the tree first.
			inorderPrint(root.getLeftCh());
			System.out.print(root.getKey() + " ");

			// recursive call to the function to check the leftCh side of the tree.
			inorderPrint(root.getRightCh());
		}
	}
}

