import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class HeapPriorityQueue<K, V> {
    protected ArrayList<Map.Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
        super();
    }

    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    protected int parents(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    protected void swap(int i, int j) {
        Map.Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    protected void unheap(int j) {
        while (j > 0) {
            int p = parents(j);
            if (compare(heap.get(j), heap.get(p)) >= 0)
                break;
            swap(j, p);
            j = p;
        }
    }

    protected void downheap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;
            }
            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
                break;
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    public int size() {
        return heap.size();
    }

    public Map.Entry<K, V> min() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    public Map.Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(Key);
        Map.Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        unheap(heap.size() - 1);
        return newest;
    }

    public Map.Entry<K, V> removeMin() {
        if ((heap.isEmpty())) return null;
        Map.Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        return answer;
    }
}
