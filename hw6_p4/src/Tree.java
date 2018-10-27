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
		}
	}

	void remove(int k) {
		Node temp = head;

		while (temp != null){
			if(temp.getValue() == k){

				if(temp.getRightCh() == null && temp.getLeftCh() == null){
					if(temp.getChildType() == Node.CHILD_TYPE.left)
						temp.getParent().setLeftCh(null);
					else if(temp.getChildType() == Node.CHILD_TYPE.right)
						temp.getParent().setRightCh(null);

					break;
				}else if (temp.getLeftCh() == null){
					if(temp.getColor() == Node.COLOR.red || temp.getRightCh().getColor() == Node.COLOR.red)
						temp.getRightCh().setColor(Node.COLOR.black);

					if(temp.getChildType() == Node.CHILD_TYPE.left)
						temp.getParent().setLeftCh(temp.getRightCh());
					else if(temp.getChildType() == Node.CHILD_TYPE.right)
						temp.getParent().setRightCh(temp.getRightCh());

					break;
				}else{
					if(temp.getColor() == Node.COLOR.red || temp.getLeftCh().getColor() == Node.COLOR.red)
						temp.getLeftCh().setColor(Node.COLOR.black);

					if(temp.getChildType() == Node.CHILD_TYPE.left)
						temp.getParent().setLeftCh(temp.getLeftCh());
					else if(temp.getChildType() == Node.CHILD_TYPE.right)
						temp.getParent().setRightCh(temp.getLeftCh());

					break;
				}
			}else if(k > temp.getValue()){
				temp = temp.getRightCh();
			}else
				temp = temp.getLeftCh();

		}
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
				restructure(n, p, g);
		} else if (p.getChildType() == Node.CHILD_TYPE.right) {
			if (g.getLeftCh() != null && g.getLeftCh().getColor() == Node.COLOR.red) {
				p.setColor(Node.COLOR.black);
				g.getLeftCh().setColor(Node.COLOR.black);
				if (g.getChildType() == Node.CHILD_TYPE.root)
					blackHeight++;
				else
					g.setColor(Node.COLOR.red);
			} else
				restructure(n, p, g);
		}

		if(g.getColor() == Node.COLOR.red && g.getParent().getColor() == Node.COLOR.red)
			restructure(g, g.getParent(), g.getParent().getParent());
	}

	private void restructure(Node n, Node p, Node g) {
		if (n.getChildType() == Node.CHILD_TYPE.left) {
			if (p.getChildType() == Node.CHILD_TYPE.left) {			//Left left
				g.setLeftCh(p.getRightCh());

				if(g.getChildType() == Node.CHILD_TYPE.left)
					g.getParent().setLeftCh(p);
				else if(g.getChildType() == Node.CHILD_TYPE.right)
					g.getParent().setRightCh(p);
				else {
					p.setChildType(Node.CHILD_TYPE.root);
					p.setParent(null);
				}

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
				else {
					n.setChildType(Node.CHILD_TYPE.root);
					n.setParent(null);
				}

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
				else {
					n.setChildType(Node.CHILD_TYPE.root);
					n.setParent(null);
				}

				n.setRightCh(g);

				g.setColor(Node.COLOR.red);
				n.setColor(Node.COLOR.black);
			} else if (p.getChildType() == Node.CHILD_TYPE.right) {	//Right Right
				g.setRightCh(p.getLeftCh());

				if(g.getChildType() == Node.CHILD_TYPE.left)
					g.getParent().setLeftCh(p);
				else if(g.getChildType() == Node.CHILD_TYPE.right)
					g.getParent().setRightCh(p);
				else {
					p.setChildType(Node.CHILD_TYPE.root);
					p.setParent(null);
				}

				p.setLeftCh(g);

				g.setColor(Node.COLOR.red);
				p.setColor(Node.COLOR.black);
			}


		}

		if(head == g){
			if(g.getParent() == n)
				head = n;
			else if(g.getParent() == p)
				head = p;
		}
	}

	void printTree() {
		System.out.println("Black Height: " + blackHeight);
		printTree(head);
		System.out.println();
	}

	private void printTree(Node n) {
//		if(n.getLeftCh() != null)
//			printTree(n.getLeftCh());
//		if(n.getChildType() == Node.CHILD_TYPE.root)
//			System.out.print("ROOT:");
//		System.out.print(n.getValue() + "(" + n.getColor().toString() + ") ");
//		if(n.getRightCh() != null)
//			printTree(n.getRightCh());


		if(n.getChildType() == Node.CHILD_TYPE.root)
			System.out.print("ROOT:");
		System.out.print(n.getValue() + "(" + n.getColor().toString() + ") ");
		if(n.getLeftCh() != null)
			printTree(n.getLeftCh());
		if(n.getRightCh() != null)
			printTree(n.getRightCh());
	}
}
