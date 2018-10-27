public class Node {
	enum COLOR {red, black}

	enum CHILD_TYPE {left, right, root}

	private COLOR color;
	private CHILD_TYPE childType;
	private Node parent;
	private Node leftCh;
	private Node rightCh;
	private int value;
	private int depth;

	Node(int k) {
		this.value = k;
	}

	COLOR getColor() {
		return color;
	}

	void setColor(COLOR color) {
		this.color = color;
	}

	CHILD_TYPE getChildType() {
		return childType;
	}

	void setChildType(CHILD_TYPE childType) {
		this.childType = childType;
	}

	Node getParent() {
		return parent;
	}

	void setParent(Node parent) {
		this.parent = parent;
	}

	Node getLeftCh() {
		return leftCh;
	}

	void setLeftCh(Node leftCh) {
		this.leftCh = leftCh;
		this.leftCh.setParent(this);
		this.leftCh.setChildType(CHILD_TYPE.left);
	}

	Node getRightCh() {
		return rightCh;
	}

	void setRightCh(Node rightCh) {
		this.rightCh = rightCh;
		this.rightCh.setParent(this);
		this.rightCh.setChildType(CHILD_TYPE.right);
	}

	int getValue() {
		return value;
	}

	void setValue(int value) {
		this.value = value;
	}

	int getDepth() {
		return depth;
	}

	void setDepth(int depth) {
		this.depth = depth;
	}
}
