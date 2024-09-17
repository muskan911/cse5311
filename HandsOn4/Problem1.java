package HandsOn4;

import java.util.PriorityQueue;
import java.util.Arrays;

public class Problem1 {

    static class ArrayEntry implements Comparable<ArrayEntry> {
        int value, arrayIndex, elementIndex;

        public ArrayEntry(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }

        public int compareTo(ArrayEntry other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static int[] mergeKSortedArrays(int[][] arrays) {
        PriorityQueue<ArrayEntry> pq = new PriorityQueue<>();
        int totalSize = 0;

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                pq.add(new ArrayEntry(arrays[i][0], i, 0));
                totalSize += arrays[i].length;
            }
        }

        int[] result = new int[totalSize];
        int index = 0;

        while (!pq.isEmpty()) {
            ArrayEntry entry = pq.poll();
            result[index++] = entry.value;

            if (entry.elementIndex + 1 < arrays[entry.arrayIndex].length) {
                pq.add(new ArrayEntry(
                        arrays[entry.arrayIndex][entry.elementIndex + 1],
                        entry.arrayIndex, entry.elementIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays1 = {
                { 1, 3, 5, 7 },
                { 2, 4, 6, 8 },
                { 0, 9, 10, 11 }
        };

        int[][] arrays2 = {
                { 1, 3, 7 },
                { 2, 4, 8 },
                { 9, 10, 11 }
        };

        int[] mergedArray1 = mergeKSortedArrays(arrays1);
        System.out.println("Merged array for case 1: " + Arrays.toString(mergedArray1));

        int[] mergedArray2 = mergeKSortedArrays(arrays2);
        System.out.println("Merged array for case 2: " + Arrays.toString(mergedArray2));
    }
}
