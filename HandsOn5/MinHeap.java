package HandsOn5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
    private List<T> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) >> 1;
    }

    private int left(int i) {
        return (i << 1) + 1;
    }

    private int right(int i) {
        return (i << 1) + 2;
    }

    // Function to build a min-heap from an array
    public void build_min_heap(List<T> array) {
        heap = new ArrayList<>(array);
        for (int i = parent(heap.size() - 1); i >= 0; i--) {
            min_heapify(i);
        }
    }

    // Function to heapify at index i
    private void min_heapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            min_heapify(smallest);
        }
    }

    // Function to pop the root (minimum) element from the heap
    public T pop() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty!");
        }

        T root = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            min_heapify(0);
        }

        return root;
    }

    // Function to insert a new element into the heap
    public void insert(T value) {
        heap.add(value);
        int i = heap.size() - 1;

        while (i > 0 && heap.get(parent(i)).compareTo(heap.get(i)) > 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Function to swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Function to print the current heap as a list
    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();

        // Example 1: Build heap from array
        List<Integer> array = Arrays.asList(5, 3, 8, 4, 1, 2);
        System.out.println("Building heap from array: " + array);
        minHeap.build_min_heap(array);
        minHeap.printHeap();

        // Example 2: Insert new elements into the heap
        System.out.println("Inserting elements 0 and 6 into the heap.");
        minHeap.insert(0);
        minHeap.insert(6);
        minHeap.printHeap(); // Should print the updated min heap

        // Example 3: Pop the root (minimum element) from the heap
        System.out.println("Popping the root element (minimum): " + minHeap.pop());
        minHeap.printHeap(); // Should print the heap after popping the root

        System.out.println("Popping the root element (minimum): " + minHeap.pop());
        minHeap.printHeap(); // Should print the heap after popping the root

        // Example 4: Demonstrating heapify on a specific index
        System.out.println("After modifying element at index 1 (forcing heapify):");
        minHeap.heap.set(1, 10); // Force an incorrect value in the heap
        minHeap.printHeap(); // Print the invalid heap

        System.out.println("Heapifying at index 1...");
        minHeap.min_heapify(1); // Manually heapify at index 1
        minHeap.printHeap();

        // Example 5: Using Float Data Type
        floatExample();

        // Example 6: Using Custom Data Type
        customDataExample();

    }

    public static void floatExample() {
        MinHeap<Float> floatHeap = new MinHeap<>();

        List<Float> floatArray = Arrays.asList(2.5f, 1.1f, 3.3f, 0.9f, 4.4f);
        System.out.println("Building heap from float array: " + floatArray);
        floatHeap.build_min_heap(floatArray);
        floatHeap.printHeap(); // Should print the min heap with floats

        System.out.println("Popping the root element (minimum): " + floatHeap.pop());
        floatHeap.printHeap(); // Should print the heap after popping the root
    }

    public static void customDataExample() {
        MinHeap<CustomData> customHeap = new MinHeap<>();

        List<CustomData> customArray = Arrays.asList(
                new CustomData(5, "Five"),
                new CustomData(1, "One"),
                new CustomData(3, "Three"),
                new CustomData(2, "Two"),
                new CustomData(4, "Four"));

        System.out.println("Building heap from custom data array: " + customArray);
        customHeap.build_min_heap(customArray);
        customHeap.printHeap(); // Should print the min heap with custom data

        System.out.println("Popping the root element (minimum): " + customHeap.pop());
        customHeap.printHeap(); // Should print the heap after popping the root
    }

}

class CustomData implements Comparable<CustomData> {
    int key;
    String value;

    public CustomData(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(CustomData other) {
        return Integer.compare(this.key, other.key);
    }

    @Override
    public String toString() {
        return "{" + key + ", " + value + "}";
    }
}
