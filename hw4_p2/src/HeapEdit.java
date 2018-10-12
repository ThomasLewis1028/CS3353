import com.sun.javafx.scene.NodeHelper;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.util.ArrayList;

public class HeapEdit {
    //    private Object Heap[];
    HeapNode head, last;
    private int size = 0;
    private int maxSize;

    public HeapEdit(int cap) {
//        Heap = new Object[cap];
        maxSize = cap;
    }

    public void in(int e) {
        if (size == maxSize) {
            System.out.println("Heap Full");
            return;
        }
        HeapNode node = new HeapNode(e);
        if (size == 0) {
            head = node;
            head.setDepth(0);
        } else {
            HeapNode temp = findDeepest(head);
            node.setDepth(temp.getDepth() + 1);

            if (temp.hasLeft())
                temp.setRightChild(node);
            else
                temp.setLeftChild(node);

            if (node.getElement() < temp.getElement())
                swap(temp, node);
        }

        //last = node;
        size++;
    }

    public void swap(HeapNode t, HeapNode n) {
        if (n.getElement() < t.getElement()) {
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

            if (n.getParent() != null && n.getElement() < n.getParent().getElement()) {
                swap(n.getParent(), n);
            }

        } else {
            System.out.println("No swap needed");
        }
    }

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

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void printHeap(HeapNode node) {
        System.out.println(node.getElement() + " ");

        if (node.hasLeft())
            printHeap(node.getLeftChild());
        if (node.hasRight())
            printHeap(node.getRightChild());
    }

    public void printHeap() {
        printHeap(head);
    }
}
