import java.util.Random;

import cse5311.BubbleSort;
import cse5311.InsertionSort;
import cse5311.SelectionSort;

public class Benchmark {
    public static void main(String[] args) {
        int[] sizes = { 0, 5, 10, 20, 50, 100, 500, 1000, 5000, 10000, 50000 };
        Random rand = new Random();

        System.out.println("Input Size,Insertion Sort,Selection Sort,Bubble Sort");

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(10000);
            }

            int[] arr1 = arr.clone();
            int[] arr2 = arr.clone();
            int[] arr3 = arr.clone();

            // Insertion Sort
            long startTime = System.nanoTime();
            InsertionSort.insertionSort(arr1);
            long endTime = System.nanoTime();
            long durationInsertion = (endTime - startTime);

            // Selection Sort
            startTime = System.nanoTime();
            SelectionSort.selectionSort(arr2);
            endTime = System.nanoTime();
            long durationSelection = (endTime - startTime);

            // Bubble Sort
            startTime = System.nanoTime();
            BubbleSort.bubbleSort(arr3);
            endTime = System.nanoTime();
            long durationBubble = (endTime - startTime);

            System.out.printf("%d,%d,%d,%d%n", size, durationInsertion, durationSelection, durationBubble);
        }
    }
}
