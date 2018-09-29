public class NodeEdit {
    Node head;
    int size = 1;

    void in(int newElement)
    {
        Node new_node = new Node(newElement);

        new_node.prev = null;
        new_node.next = head;

        if(head != null)
        {
            head.prev = new_node;
        }
        head = new_node;
        size++;
    }

    void in(int newElement, int link)
    {
        Node new_node = new Node(newElement);

        new_node.prev = null;
        new_node.next = head;

        if(head != null)
        {
            head.prev = new_node;
        }
        head = new_node;
        size++;
    }


    void del(int num)
    {
        Node delElement = head;
        Node temp = null;

        while(delElement.element != num)
        {
            // System.out.println(delElement.element);
            delElement = delElement.next;
        }
        // System.out.println();
        //System.out.println(delElement.element);

        if (head == delElement) {
            head = delElement.next;
        }
        /* Change next only if node to be deleted is NOT the last node */
        if (delElement.next != null) {
            delElement.next.prev = delElement.prev;
        }

        /* Change prev only if node to be deleted is NOT the first node */
        if (delElement.prev != null) {
            delElement.prev.next = delElement.next;
        }

        /* Finally, free the memory occupied by del*/
        return;

    }

    public int sch(int num)
    {
        Node temp = head;
        int location = 1;
        while(temp.element != num)
        {
            temp = temp.next;
            location++;
        }
        return location;
    }

    public void printList(Node node)
    {
        Node last = null;
        System.out.println("Traversal from L to R");
        while(node != null)
        {
            System.out.print(node.element + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal from R to L");
        while(last != null)
        {
            System.out.print(last.element + " ");
            last = last.prev;
        }
    }
}
