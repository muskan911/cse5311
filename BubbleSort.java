package cse5311;

public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        System.out.println("Bubble sort test case 1");
        int[] arr1 = new int[] { 64, 34, 25, 12, 22, 11, 90 };
        printArray(bubbleSort(arr1));

        System.out.println("Bubble sort test case 2");
        int[] arr2 = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        printArray(bubbleSort(arr2));

        System.out.println("Bubble sort test case 3");
        int[] arr3 = new int[] { 1, 2, 3, 4, 5 };
        printArray(bubbleSort(arr3));

        System.out.println("Bubble sort test case 4");
        int[] arr4 = new int[] { 5, 5, 5, 5, 5 };
        printArray(bubbleSort(arr4));

        System.out.println("Bubble sort test case 5");
        int[] arr5 = new int[] { 42 };
        printArray(bubbleSort(arr5));

        System.out.println("Bubble sort test case 6");
        int[] arr6 = new int[] { 20, 10 };
        printArray(bubbleSort(arr6));

        System.out.println("Bubble sort test case 7");
        int[] arr7 = new int[] { 3, -2, -1, 10, 0 };
        printArray(bubbleSort(arr7));

        System.out.println("Bubble sort test case 8");
        int[] arr8 = new int[] { -5, -10, -3, -1 };
        printArray(bubbleSort(arr8));
    }
}
