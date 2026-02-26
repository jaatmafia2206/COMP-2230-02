import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Get parent index
    private int parent(int i) { return (i - 1) / 2; }

    // Get left child index
    private int left(int i) { return 2 * i + 1; }

    // Get right child index
    private int right(int i) { return 2 * i + 2; }

    // Swap elements
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert element
    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        heap[size] = key;
        int i = size;
        size++;

        // Heapify up
        while (i != 0 && heap[parent(i)] > heap[i]) { // Min-heap
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Heapify down
    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if (l < size && heap[l] < heap[smallest])
            smallest = l;
        if (r < size && heap[r] < heap[smallest])
            smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Extract min
    public int extractMin() {
        if (size <= 0) return Integer.MAX_VALUE;
        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return root;
    }

    // Delete key
    public void deleteKey(int key) {
        int i;
        for (i = 0; i < size; i++) {
            if (heap[i] == key) break;
        }
        if (i == size) return; // key not found

        heap[i] = heap[size - 1];
        size--;
        heapify(i);
    }

    // Print heap
    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    // Main method
    public static void main(String[] args) {
        Heap h = new Heap(10);
        h.insert(3);
        h.insert(2);
        h.insert(15);
        h.insert(5);
        h.insert(4);

        System.out.print("Heap array: ");
        h.printHeap();

        System.out.println("Extract min: " + h.extractMin());
        System.out.print("Heap after extraction: ");
        h.printHeap();

        System.out.println("Deleting 4");
        h.deleteKey(4);
        System.out.print("Heap after deletion: ");
        h.printHeap();
    }
}
