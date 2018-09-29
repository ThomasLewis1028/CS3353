class NodeEdit {
    Node head;
    private int size = 0;

    void in(int e) {
        if (schB(e)) {
            System.out.println(e + " already exists in the list");
            return;
        }

        Node node = new Node(e);
        node.setPrev(null);
        node.setNext(head);

        if (head != null) {
            head.setPrev(node);
        }
        head = node;
        size++;
    }

    void in(int e, int link) {
        if (schB(e)) {
            System.out.println(e + " already exists in the list");
            return;
        }
        Node node = new Node(e);
        Node temp = head;

        while (temp.getElement() != link) {
            temp = temp.getNext();

            if (temp == null) {
                System.out.println(link + " does not exist in the list");
                return;
            }
        }

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

        while (del.getElement() != num)
            del = del.getNext();

        if (head == del)
            head = del.getNext();
        if (del.getNext() != null)
            del.getNext().setPrev(del.getPrev());
        if (del.getPrev() != null)
            del.getPrev().setNext(del.getNext());

        size--;
    }

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

    void printList(Node node) {
        System.out.println("List of size " + size + " from left to right");
        while (node != null) {
            System.out.print(node.getElement() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}