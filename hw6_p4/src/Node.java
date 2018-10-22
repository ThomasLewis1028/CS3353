public class Node {
	enum COLOR{red, black}
	private COLOR color;
	private Node parent;
	private Node leftCh;
	private Node rightCh;
	private int value;
	private int depth;

	Node (int k){
		this.value = k;
	}

	public COLOR getColor() {
		return color;
	}

	public void setColor(COLOR color) {
		this.color = color;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeftCh() {
		return leftCh;
	}

	public void setLeftCh(Node leftCh) {
		this.leftCh = leftCh;
	}

	public Node getRightCh() {
		return rightCh;
	}

	public void setRightCh(Node rightCh) {
		this.rightCh = rightCh;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
