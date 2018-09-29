class Node {
    private int element;
    private Node prev;
    private Node next;

    Node(int e) {
        this.element = e;
        this.next = this.prev = null;
    }

    int getElement() {
        return element;
    }

    Node getPrev() {
        return prev;
    }

    void setPrev(Node prev) {
        this.prev = prev;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}