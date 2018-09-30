class NodeEdit {
    Node head;
    private int size = 0;

    void in(int e) {
        //Search for item in list to avoid duplicates
        if (schB(e)) {
            System.out.println(e + " already exists in the list");
            return;
        }

        //Set new node at head and add to size
        Node node = new Node(e);
        node.setPrev(null);
        node.setNext(head);

        if (head != null) {
            head.setPrev(node);
        }
        head = node;
        size++;
    }

    //Insert item on node
    void in(int e, int link) {

        //Search for item to avoid duplicates
        if (schB(e)) {
            System.out.println(e + " already exists in the list");
            return;
        }

        //Create new node and temp node head
        Node node = new Node(e);
        Node temp = head;

        //Search for node to link
        while (temp.getElement() != link) {
            temp = temp.getNext();

            //Check to not reach of of list and get array out of bounds
            if (temp == null) {
                System.out.println(link + " does not exist in the list");
                return;
            }
        }

        //Change links for previous and next nodes to include new node
        Node tempNext = temp.getNext();
        temp.setNext(node);
        node.setPrev(temp);
        if (tempNext != null)
            tempNext.setPrev(node);
        node.setNext(tempNext);

        size++;
    }

    void del(int num) {
        Node del = head;

        //Iterate through to find node and check for out of bounds
        while (del.getElement() != num) {
            del = del.getNext();

            if (del == null){
                System.out.println(num + " not found in list");
            }
        }

        //Set new links to old nodes without deleted node
        if (head == del)
            head = del.getNext();
        if (del.getNext() != null)
            del.getNext().setPrev(del.getPrev());
        if (del.getPrev() != null)
            del.getPrev().setNext(del.getNext());

        size--;
    }

    //Search for elements in list and print location
    void sch(int num) {
        Node temp = head;
        int loc = 1;

        while (temp.getElement() != num) {
            temp = temp.getNext();

            if (temp == null) {
                System.out.println(num + " does not exist in the list");
                return;
            }
            loc++;
        }

        System.out.println(num + " is stored at " + loc);
    }

    //Search for elements in list and return boolean for found
    private boolean schB(int num) {
        Node temp = head;

        if (temp == null)
            return false;

        while (temp.getElement() != num) {
            temp = temp.getNext();

            if (temp == null)
                return false;
        }
        return true;
    }

    //Iterate through and print each element
    void printList(Node node) {
        System.out.println("List values: ");
        while (node != null) {
            System.out.print(node.getElement() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}