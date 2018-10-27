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
		tree.insert(19);
		tree.insert(20);
		tree.insert(4);
//		tree.insert(10);
//		tree.insert(23);
//		tree.insert(18);
//		tree.insert(24);

		tree.printTree();

		tree.remove(2);

		tree.printTree();

		System.out.println(tree.search(9) ? 9 + " found " : 9 + " not found");
		System.out.println(tree.search(7) ? 7 + " found " : 7 + " not found");
	}
}
