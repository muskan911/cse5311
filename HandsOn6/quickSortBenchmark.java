package HandsOn6;

import java.util.Random;

public class quickSortBenchmark {

    // Non-random pivot quicksort implementation
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Method to generate the best case (already sorted array)
    public static int[] generateBestCase(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    // Method to generate the worst case (reverse sorted array)
    public static int[] generateWorstCase(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = n - i;
        }
        return array;
    }

    // Method to generate random array for the average case
    public static int[] generateAverageCase(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n);
        }
        return array;
    }

    public static void runBenchmark(int[] array, String caseType) {
        long startTime = System.nanoTime();
        quickSort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(caseType + " case for n=" + array.length + ": " + duration + " nanoseconds");
    }

    public static void main(String[] args) {
        int[] sizes = { 100, 500, 1000, 5000, 10000 }; // Input sizes

        for (int size : sizes) {
            // Best case
            int[] bestCaseArray = generateBestCase(size);
            runBenchmark(bestCaseArray, "Best");

            // Worst case
            int[] worstCaseArray = generateWorstCase(size);
            runBenchmark(worstCaseArray, "Worst");

            // Average case
            int[] averageCaseArray = generateAverageCase(size);
            runBenchmark(averageCaseArray, "Average");
        }
    }
}