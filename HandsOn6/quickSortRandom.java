package HandsOn6;

import java.util.Arrays;
import java.util.Random;

public class quickSortRandom {
    // Function to perform quicksort on an array
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = randomPartition(array, low, high);
            quickSort(array, low, pivotIndex - 1); // Recursively sort left subarray
            quickSort(array, pivotIndex + 1, high); // Recursively sort right subarray
        }
    }

    // Function to partition the array with a random pivot
    public static int randomPartition(int[] array, int low, int high) {
        Random rand = new Random();
        int randomPivotIndex = rand.nextInt(high - low + 1) + low;

        // Swap random pivot with the last element
        int temp = array[randomPivotIndex];
        array[randomPivotIndex] = array[high];
        array[high] = temp;

        return partition(array, low, high);
    }

    // Function to partition the array
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Last element as pivot
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i + 1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Return the partitioning index
    }

    // Main function to test the random quicksort
    public static void main(String[] args) {
        int[] array = { 10, 80, 30, 90, 40, 50, 70 };
        System.out.println("Original array: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array (random pivot): " + Arrays.toString(array));
    }
}