class SplayNode {
	private int key;
	private SplayNode parent,
			leftCh,
			rightCh;

	SplayNode() {
		this(0, null, null, null);
	}

	public SplayNode(int n, SplayNode l, SplayNode r, SplayNode p) {
		this.key = n;
		this.leftCh = l;
		this.rightCh = r;
		this.parent = p;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public SplayNode getParent() {
		return parent;
	}

	public void setParent(SplayNode parent) {
		this.parent = parent;
	}

	public SplayNode getLeftCh() {
		return leftCh;
	}

	public void setLeftCh(SplayNode leftCh) {
		this.leftCh = leftCh;
	}

	public SplayNode getRightCh() {
		return rightCh;
	}

	public void setRightCh(SplayNode rightCh) {
		this.rightCh = rightCh;
	}
}