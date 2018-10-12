public class HeapMain {
    public static void main(String[] args) {
        HeapEdit heap = new HeapEdit(10);
        heap.in(5);
        heap.in(7);
        heap.in(3);
        heap.in(9);
        heap.in(8);
        heap.in(6);
        heap.in(1);


        heap.printHeap();
    }
}
