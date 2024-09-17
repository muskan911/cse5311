package HandsOn4;

import java.util.Arrays;

public class Problem2 {

    public static int[] removeDuplicates(int[] array) {
        if (array.length == 0)
            return new int[0];

        int uniqueIndex = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                array[uniqueIndex++] = array[i];
            }
        }

        return Arrays.copyOf(array, uniqueIndex);
    }

    public static void main(String[] args) {
        int[] array = { 2, 2, 2, 2, 2 };
        int[] newArray = removeDuplicates(array);
        System.out.println(Arrays.toString(newArray));
        int[] array1 = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
        int[] newArray1 = removeDuplicates(array1);
        System.out.println(Arrays.toString(newArray1));
    }
}