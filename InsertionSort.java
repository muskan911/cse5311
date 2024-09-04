package cse5311;

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        System.out.println("Insertion sort test case 1");
        int[] arr1 = new int[] { 64, 34, 25, 12, 22, 11, 90 };
        printArray(insertionSort(arr1));

        System.out.println("Insertion sort test case 2");
        int[] arr2 = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        printArray(insertionSort(arr2));

        System.out.println("Insertion sort test case 3");
        int[] arr3 = new int[] { 1, 2, 3, 4, 5 };
        printArray(insertionSort(arr3));

        System.out.println("Insertion sort test case 4");
        int[] arr4 = new int[] { 5, 5, 5, 5, 5 };
        printArray(insertionSort(arr4));

        System.out.println("Insertion sort test case 5");
        int[] arr5 = new int[] { 42 };
        printArray(insertionSort(arr5));

        System.out.println("Insertion sort test case 6");
        int[] arr6 = new int[] { 20, 10 };
        printArray(insertionSort(arr6));

        System.out.println("Insertion sort test case 7");
        int[] arr7 = new int[] { 3, -2, -1, 10, 0 };
        printArray(insertionSort(arr7));

        System.out.println("Insertion sort test case 8");
        int[] arr8 = new int[] { -5, -10, -3, -1 };
        printArray(insertionSort(arr8));
    }
}
