public class HeapEdit {
    HeapNode head, last;
    private int size = 0;
    private int maxSize;

    public HeapEdit(int cap) {
        maxSize = cap;
    }

    //Insert into heap
    public void in(int e) {
        //Check if heap full
        if (size == maxSize) {
            System.out.println("Heap Full");
            return;
        }
        //Check if adding into head, otherwise add based on deepest node
        HeapNode node = new HeapNode(e);
        if (size == 0) {
            head = node;
            last = node;
            head.setDepth(0);
        } else {
            HeapNode temp = findDeepest(head);
            node.setDepth(temp.getDepth() + 1);

            if (temp.hasLeft())
                temp.setRightChild(node);
            else
                temp.setLeftChild(node);

            last = node;
            if (node.getElement() > temp.getElement())
                swap(temp, node);
        }

        size++;
    }

    //Delete max value
    public void del() {
        //Check if last is left or right child
        if (last.getParent().getLeftChild() == last)
            last.getParent().setLeftChild(null);
        else
            last.getParent().setRightChild(null);

        //Replace head with last
        last.setLeftChild(head.getLeftChild());
        last.setRightChild(head.getRightChild());
        head = last;
        last = findLast(head);

        //Swap new head down towards end
        if(head.getLeftChild() != null && head.getLeftChild().getElement() > head.getRightChild().getElement())
            swapDown(head, head.getLeftChild());
        else
            swapDown(head, head.getRightChild());

        size--;
    }

    //Swap upwards when inserting new node
    public void swap(HeapNode t, HeapNode n) {
        if (n.getElement() > t.getElement()) {
            if (t == head) {
                swapChildren(t, n);
                head = n;
                n.setParent(null);
            } else {
                n.setParent(t.getParent());

                if (t.getParent().getRightChild() == t) {
                    t.getParent().setRightChild(n);
                    swapChildren(t, n);
                } else {
                    t.getParent().setLeftChild(n);
                    swapChildren(t, n);
                }
            }

            int td = t.getDepth();
            t.setDepth(n.getDepth());
            n.setDepth(td);

            if (n.getParent() != null && n.getElement() > n.getParent().getElement()) {
                swap(n.getParent(), n);
            }

            if (n == last)
                last = t;

        }
    }

    //Swap down when deleting node
    public void swapDown(HeapNode n, HeapNode t){
        if(n == head){
            head = t;
            if(n.getLeftChild() == t){
                HeapNode temp = t.getRightChild();
                n.setLeftChild(t.getLeftChild());
                t.setLeftChild(n);
                t.setRightChild(n.getRightChild());
                n.setRightChild(temp);
            }else{
                HeapNode temp = t.getLeftChild();
                n.setRightChild(t.getRightChild());
                t.setRightChild(n);
                t.setLeftChild(n.getLeftChild());
                n.setLeftChild(temp);
            }
            t.setParent(null);
        }else if(t == last){
            swapChildrenDown(n, t);
            last = n;
        }else{
            t.setParent(n.getParent());
            swapChildrenDown(n, t);
        }

        int td = t.getDepth();
        t.setDepth(n.getDepth());
        n.setDepth(td);

        if(n != last) {
            if (n.getLeftChild().getElement() > n.getRightChild().getElement())
                swapDown(n, n.getLeftChild());
            else
                swapDown(n, n.getRightChild());
        }


    }

    //Swap children when swapping down
    public void swapChildrenDown(HeapNode n, HeapNode t){
        if(n.getParent().getLeftChild() == n){
            n.getParent().setLeftChild(t);
            swapChildren(n, t);
        }else{
            n.getParent().setRightChild(t);
            swapChildren(n, t);
        }
    }

    //Swap children when swapping up
    public void swapChildren(HeapNode t, HeapNode n) {
        HeapNode temp;
        if (t.getLeftChild() == n) {
            temp = t.getRightChild();
            t.setLeftChild(n.getLeftChild());
            n.setLeftChild(t);
            t.setRightChild(n.getRightChild());
            n.setRightChild(temp);
        } else {
            temp = t.getLeftChild();
            t.setRightChild(n.getRightChild());
            n.setRightChild(t);
            t.setLeftChild(n.getLeftChild());
            n.setLeftChild(temp);
        }
    }

    //Find deepest node to link onto (name is a bit confusing, this just finds the place to link onto)
    HeapNode findDeepest(HeapNode n) {
        HeapNode r = null;
        HeapNode l = null;

        if (!n.hasLeft() && !n.hasRight() || n.hasLeft() && !n.hasRight())
            return n;

        if (n.hasLeft())
            l = findDeepest(n.getLeftChild());

        if (n.hasRight())
            r = findDeepest(n.getRightChild());

        if (l.getDepth() > r.getDepth())
            return r;
        else
            return l;
    }

    //Find the last node on the entire heap
    HeapNode findLast(HeapNode n){
        HeapNode l= null,
                r = null;

        if (!n.hasLeft() && !n.hasRight() || n.hasLeft() && !n.hasRight())
            return n;

        if (n.hasLeft())
            l = findLast(n.getLeftChild());

        if (n.hasRight())
            r = findLast(n.getRightChild());

        if(l == null && r != null)
            return r;
        else if(l != null && r == null)
            return l;
        else if (l.getElement() > r.getElement())
            return r;
        else return l;
    }


    //Overloaded print heap to call recursively since I don't store the heap in the main class
    public void printHeap(HeapNode node, String arg) {

        if (arg.matches("pre")) {
            System.out.print(node.getElement() + " ");
            if (node.hasLeft())
                printHeap(node.getLeftChild(), arg);
            if (node.hasRight())
                printHeap(node.getRightChild(), arg);
        } else if (arg.matches("in")) {
            if (node.hasLeft())
                printHeap(node.getLeftChild(), arg);
            System.out.print(node.getElement() + " ");
            if (node.hasRight())
                printHeap(node.getRightChild(), arg);
        } else if (arg.matches("post")) {
            if (node.hasLeft())
                printHeap(node.getLeftChild(), arg);
            if (node.hasRight())
                printHeap(node.getRightChild(), arg);
            System.out.print(node.getElement() + " ");
        }
    }

    //Print heap based on input
    public void printHeap(String arg) {
        System.out.print(arg + ": ");
        printHeap(head, arg);
        System.out.println();
    }
}
