public class NodeEdit {
    Node head;
    private int size = 1;

    void in(int newElement) {
        if (schB(newElement)) {
            System.out.println(newElement + " already exists in the list");
            return;
        }

        Node new_node = new Node(newElement);
        new_node.setPrev(null);
        new_node.setNext(head);

        if (head != null) {
            head.setPrev(new_node);
        }
        head = new_node;
        size++;
    }

    void in(int newElement, int link) {
        if (schB(newElement)) {
            System.out.println(newElement + " already exists in the list");
            return;
        }
        Node new_node = new Node(newElement);
        Node temp = head;


        while (temp.getElement() != link) {
            temp = temp.getNext();

            if (temp == null) {
                System.out.println(link + " does not exist in the list");
                return;
            }
        }

        Node tempNext = temp.getNext();
        temp.setNext(new_node);
        new_node.setPrev(temp);
        tempNext.setPrev(new_node);
        new_node.setNext(tempNext);

        size++;
    }


    void del(int num) {
        Node delElement = head;

        while (delElement.getElement() != num) {
            delElement = delElement.getNext();
        }

        if (head == delElement) {
            head = delElement.getNext();
        }

        if (delElement.getNext() != null) {
            delElement.getNext().setNext(delElement.getPrev());
        }


        if (delElement.getPrev() != null) {
            delElement.getPrev().setNext(delElement.getNext());
        }
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
        System.out.println("Traversal from L to R");
        while (node != null) {
            System.out.print(node.getElement() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
