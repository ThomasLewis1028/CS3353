public class Tree {
	private Node head;
	private int blackHeight = 1;

	void insert(int k) {
		Node node = new Node(k);

		if (head == null) {
			node.setColor(Node.COLOR.black);
			head = node;
			head.setChildType(Node.CHILD_TYPE.root);
			blackHeight++;
		} else {
			node.setColor(Node.COLOR.red);
			Node temp = head;

			while (true) {
				if (node.getValue() == temp.getValue()) {
					System.out.println("Value already exists in tree");
					break;
				} else if (node.getValue() > temp.getValue()) {
					if (temp.getRightCh() != null)
						temp = temp.getRightCh();
					else {
						temp.setRightCh(node);
						break;
					}
				} else {
					if (temp.getLeftCh() != null)
						temp = temp.getLeftCh();
					else {
						temp.setLeftCh(node);
						break;
					}
				}
			}

			if (head != node)
				if (node.getParent().getColor() == Node.COLOR.red)
					recolor(node);


			//TODO: Check validity of tree
		}
	}

	void remove() {

	}

	boolean search(int k){
		Node temp = head;
		while(temp != null){
			if(temp.getValue() == k)
				return true;
			else if(temp.getValue() > k)
				temp = temp.getLeftCh();
			else
				temp = temp.getRightCh();
		}

		return false;
	}

	private void recolor(Node n) {
		Node p = n.getParent();
		Node g = p.getParent();

		//Follow instructions for a red uncle
		if (p.getChildType() == Node.CHILD_TYPE.left) {
			//Check if uncle is red or black
			if (g.getRightCh() != null && g.getRightCh().getColor() == Node.COLOR.red) {
				p.setColor(Node.COLOR.black);
				g.getRightCh().setColor(Node.COLOR.black);

				//Check if uncle is root
				if (g.getChildType() == Node.CHILD_TYPE.root)
					blackHeight++;
				else
					g.setColor(Node.COLOR.red);

			} else //Restructure if black
				restructure(n, p, g, g.getRightCh());
		} else if (p.getChildType() == Node.CHILD_TYPE.right) {
			if (g.getLeftCh() != null && g.getLeftCh().getColor() == Node.COLOR.red) {
				p.setColor(Node.COLOR.black);
				g.getLeftCh().setColor(Node.COLOR.black);
				if (g.getChildType() == Node.CHILD_TYPE.root)
					blackHeight++;
				else
					g.setColor(Node.COLOR.red);
			} else
				restructure(n, p, g, g.getLeftCh());
		}
	}

	private void restructure(Node n, Node p, Node g, Node u) {
		if (n.getChildType() == Node.CHILD_TYPE.left) {
			if (p.getChildType() == Node.CHILD_TYPE.left) {			//Left left
				g.setLeftCh(p.getRightCh());
				g.getParent().setLeftCh(p);
				p.setRightCh(g);

				g.setColor(Node.COLOR.red);
				p.setColor(Node.COLOR.black);
			} else if (p.getChildType() == Node.CHILD_TYPE.right) { //Right left
				p.setLeftCh(n.getRightCh());
				n.setRightCh(p);
				g.setRightCh(n);

				g.setRightCh(n.getLeftCh());
				if(g.getChildType() == Node.CHILD_TYPE.left)
					g.getParent().setLeftCh(n);
				else if(g.getChildType() == Node.CHILD_TYPE.right)
					g.getParent().setRightCh(n);
				else
					n.setChildType(Node.CHILD_TYPE.root);
				n.setLeftCh(p);

				g.setColor(Node.COLOR.red);
				n.setColor(Node.COLOR.black);
			}
		} else if (n.getChildType() == Node.CHILD_TYPE.right) {
			if (p.getChildType() == Node.CHILD_TYPE.left) {			//Left right
				p.setRightCh(n.getLeftCh());
				n.setLeftCh(p);
				g.setLeftCh(n);

				g.setLeftCh(n.getRightCh());
				if(g.getChildType() == Node.CHILD_TYPE.left)
					g.getParent().setLeftCh(n);
				else if(g.getChildType() == Node.CHILD_TYPE.right)
					g.getParent().setRightCh(n);
				else
					n.setChildType(Node.CHILD_TYPE.root);

				n.setRightCh(g);

				g.setColor(Node.COLOR.red);
				n.setColor(Node.COLOR.black);
			} else if (p.getChildType() == Node.CHILD_TYPE.right) {	//Right Right
				g.setRightCh(p.getLeftCh());
				g.getParent().setRightCh(p);
				p.setLeftCh(g);

				g.setColor(Node.COLOR.red);
				p.setColor(Node.COLOR.black);
			}

			if(head == g){
				head = n;
				n.setChildType(Node.CHILD_TYPE.root);
			}
		}
	}

	private void swap(Node t, Node n) {
		if (n.getValue() > t.getValue()) {
			if (t == head) {
				swapChildren(t, n);
				head = n;
				n.setParent(null);
			} else {
				n.setParent(t.getParent());

				if (t.getParent().getRightCh() == t) {
					t.getParent().setRightCh(n);
					swapChildren(t, n);
				} else {
					t.getParent().setLeftCh(n);
					swapChildren(t, n);
				}
			}

			int td = t.getDepth();
			t.setDepth(n.getDepth());
			n.setDepth(td);

			if (n.getParent() != null && n.getValue() > n.getParent().getValue()) {
				swap(n.getParent(), n);
			}
		}
	}

	private void swapChildren(Node t, Node n) {
		Node temp;
		if (t.getLeftCh() == n) {
			temp = t.getRightCh();
			t.setLeftCh(n.getLeftCh());
			n.setLeftCh(t);
			t.setRightCh(n.getRightCh());
			n.setRightCh(temp);
		} else {
			temp = t.getLeftCh();
			t.setRightCh(n.getRightCh());
			n.setRightCh(t);
			t.setLeftCh(n.getLeftCh());
			n.setLeftCh(temp);
		}
	}

	void printTree() {
		System.out.println("Black Height: " + blackHeight);
		printTree(head);
		System.out.println();
	}

	private void printTree(Node n) {
		if(n.getLeftCh() != null)
			printTree(n.getLeftCh());
		if(n.getChildType() == Node.CHILD_TYPE.root)
			System.out.print("ROOT:");
		System.out.print(n.getValue() + "(" + n.getColor().toString() + ") ");
		if(n.getRightCh() != null)
			printTree(n.getRightCh());
	}
}
