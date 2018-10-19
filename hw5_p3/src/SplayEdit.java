public class SplayEdit {
	private SplayNode head;

	public SplayEdit() {
		head = null;
	}

	private void Splay(SplayNode x) {
		while (x.getParent() != null) {
			SplayNode Parent = x.getParent();
			SplayNode GrandParent = Parent.getParent();
			if (GrandParent == null) {
				if (x == Parent.getLeftCh())
					makeLeftChildParent(x, Parent);
				else
					makeRightChildParent(x, Parent);
			} else {
				if (x == Parent.getLeftCh()) {
					if (Parent == GrandParent.getLeftCh()) {
						makeLeftChildParent(Parent, GrandParent);
						makeLeftChildParent(x, Parent);
					} else {
						makeLeftChildParent(x, x.getParent());
						makeRightChildParent(x, x.getParent());
					}
				} else {
					if (Parent == GrandParent.getLeftCh()) {
						makeRightChildParent(x, x.getParent());
						makeLeftChildParent(x, x.getParent());
					} else {
						makeRightChildParent(Parent, GrandParent);
						makeRightChildParent(x, Parent);
					}
				}
			}
		}
		head = x;
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

	void delete(int num) {
		SplayNode temp = isDuplicate(num);
		deleteNum(temp);
	}

	boolean search(int key) {
		return isDuplicate(key) != null;
	}

	private void makeLeftChildParent(SplayNode c, SplayNode p) {
		if ((c == null) || (p == null) || (p.getLeftCh() != c) || (c.getParent() != p))
			throw new RuntimeException("WRONG");

		if (p.getParent() != null) {
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

	private void makeRightChildParent(SplayNode c, SplayNode p) {
		if ((c == null) || (p == null) || (p.getRightCh() != c) || (c.getParent() != p))
			throw new RuntimeException("WRONG");
		if (p.getParent() != null) {
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

	private void deleteNum(SplayNode node) {
		if (node == null)
			return;

		Splay(node);
		if ((node.getLeftCh() != null) && (node.getRightCh() != null)) {
			SplayNode min = node.getLeftCh();
			while (min.getRightCh() != null)
				min = min.getRightCh();

			min.setRightCh(node.getRightCh());
			node.getRightCh().setParent(min);
			node.getLeftCh().setParent(null);
			head = node.getLeftCh();
		} else if (node.getRightCh() != null) {
			node.getRightCh().setParent(null);
			head = node.getRightCh();
		} else if (node.getLeftCh() != null) {
			node.getLeftCh().setParent(null);
			head = node.getLeftCh();
		} else {
			head = null;
		}
		node.setParent(null);
		node.setLeftCh(null);
		node.setRightCh(null);
	}

	private SplayNode isDuplicate(int key) {
		SplayNode temp = head;
		while (temp != null) {
			if (key < temp.getKey()) {
				temp = temp.getLeftCh();
			} else if (key > temp.getKey()) {
				temp = temp.getLeftCh();
			} else {
				return temp;
			}
		}
		return null;
	}

	void printSplay() {
		printSplay(head);
	}

	private void printSplay(SplayNode root) {
		if (root != null) {
			printSplay(root.getLeftCh());
			System.out.print(root.getKey() + " ");

			printSplay(root.getRightCh());
		}
	}
}

