public class HeapNode {
    private HeapNode parent;
    private HeapNode leftChild;
    private HeapNode rightChild;
    private int element;
    private int depth;

    public HeapNode(){

    }


    public HeapNode(int e) {
        this.element = e;
        this.leftChild = this.rightChild = null;
    }

    public HeapNode getParent() {
        return parent;
    }

    public void setParent(HeapNode parent) {
        this.parent = parent;
    }

    public HeapNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(HeapNode leftChild) {
        this.leftChild = leftChild;
        if(leftChild != null)
            leftChild.setParent(this);
    }

    public HeapNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(HeapNode rightChild) {
        this.rightChild = rightChild;
        if(rightChild != null)
            rightChild.setParent(this);
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public boolean hasLeft(){
        return leftChild !=  null;
    }

    public boolean hasRight(){
        return rightChild != null;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
