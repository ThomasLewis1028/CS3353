public class RBTreeMain {
	public static void main(String[] args) {
		Tree tree = new Tree();

		tree.insert(14);
		tree.insert(5);
		tree.insert(22);
		tree.insert(3);
		tree.insert(8);
		tree.insert(1);
		tree.insert(9);
		tree.insert(2);

		tree.printTree();
	}
}
