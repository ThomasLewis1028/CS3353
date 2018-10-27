public class Tree {
	private Node head;
	private int size;
	private int blackHeight = 0;

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

			if(head != node)
				if (node.getParent().getColor() == Node.COLOR.red)
					recolor(node);


			//TODO: Check validity of tree
		}
	}

	void remove() {

	}

	void recolor(Node n) {
		Node p = n.getParent();
		Node g = p.getParent();

		//Follow instructions for a red uncle
		if (p.getChildType() == Node.CHILD_TYPE.left) {
			//Check if uncle is red or black
			if (g.getRightCh().getColor() == Node.COLOR.red) {
				p.setColor(Node.COLOR.black);
				g.getRightCh().setColor(Node.COLOR.black);

				//Check if uncle is root
				if (g.getChildType() == Node.CHILD_TYPE.root)
					blackHeight++;
				else
					g.setColor(Node.COLOR.red);

			} //else //Restructure if black
//				restructure(n, p, g, g.getRightCh());
		} else if (p.getChildType() == Node.CHILD_TYPE.right) {
			if (g.getLeftCh().getColor() == Node.COLOR.red) {
				p.setColor(Node.COLOR.black);
				g.getLeftCh().setColor(Node.COLOR.black);
				if (g.getChildType() == Node.CHILD_TYPE.root)
					blackHeight++;
				else
					g.setColor(Node.COLOR.red);
			} //else
//				restructure(n, p, g, g.getLeftCh());
		}
	}

	void restructure(Node n, Node p, Node g, Node u) {


		if (n.getChildType() == Node.CHILD_TYPE.left) {
			if (n.getParent().getChildType() == Node.CHILD_TYPE.left) {

			} else if (n.getParent().getChildType() == Node.CHILD_TYPE.right) {

			}
		} else if (n.getChildType() == Node.CHILD_TYPE.right) {
			if (n.getParent().getChildType() == Node.CHILD_TYPE.left) {

			} else if (n.getParent().getChildType() == Node.CHILD_TYPE.right) {

			}
		}


	}

	void swap(Node t, Node n) {
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

	void swapChildren(Node t, Node n) {
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
		printTree(head);
		System.out.println();
	}

	void printTree(Node n) {
		System.out.print(n.getValue() + "(" + n.getColor().toString() + ")");
		if (n.getLeftCh() != null)
			printTree(n.getLeftCh());
		if (n.getRightCh() != null)
			printTree(n.getRightCh());
	}
}
