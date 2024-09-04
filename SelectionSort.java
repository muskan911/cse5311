package cse5311;

public class SelectionSort {
    public static int[] selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
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
        System.out.println("Selection sort test case 1");
        int[] arr1 = new int[] { 64, 34, 25, 12, 22, 11, 90 };
        printArray(selectionSort(arr1));

        System.out.println("Selection sort test case 2");
        int[] arr2 = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        printArray(selectionSort(arr2));

        System.out.println("Selection sort test case 3");
        int[] arr3 = new int[] { 1, 2, 3, 4, 5 };
        printArray(selectionSort(arr3));

        System.out.println("Selection sort test case 4");
        int[] arr4 = new int[] { 5, 5, 5, 5, 5 };
        printArray(selectionSort(arr4));

        System.out.println("Selection sort test case 5");
        int[] arr5 = new int[] { 42 };
        printArray(selectionSort(arr5));

        System.out.println("Selection sort test case 6");
        int[] arr6 = new int[] { 20, 10 };
        printArray(selectionSort(arr6));

        System.out.println("Selection sort test case 7");
        int[] arr7 = new int[] { 3, -2, -1, 10, 0 };
        printArray(selectionSort(arr7));

        System.out.println("Selection sort test case 8");
        int[] arr8 = new int[] { -5, -10, -3, -1 };
        printArray(selectionSort(arr8));
    }
}
