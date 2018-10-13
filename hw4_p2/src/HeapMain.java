public class HeapMain {
    public static void main(String[] args) {
        HeapEdit heap = new HeapEdit(10);
        heap.in(35);
        heap.in(33);
        heap.in(42);
        heap.in(10);
        heap.in(14);
        heap.in(19);
        heap.in(27);
        heap.in(44);
        heap.in(26);
        heap.in(31);
        heap.del();

        heap.printHeap("pre");
        heap.printHeap("post");
        heap.printHeap("in");
    }
}
