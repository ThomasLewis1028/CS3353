public class Tree {
	private Node head;
	private int size;

	void insert(int k){
		Node node = new Node(k);
		if(head == null){
			node.setColor(Node.COLOR.black);
			head = node;
		}else{
			node.setColor(Node.COLOR.red);
			Node temp = head;

			//TODO: Add search function

			while(temp != null){
				if(node.getValue() > temp.getValue())
					temp = temp.getRightCh();
				else
					temp = temp.getLeftCh();


			}
		}
	}

	void remove(){

	}

}
