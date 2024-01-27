package javacode;

public class MaxInBitonicArray {

    public static int findMax(int[] arr) {
        int start = 0, end = arr.length - 1, mid;

        while (start < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }

        return arr[start];
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 8, 13, 12, 4, 2 };
        System.out.println("Result: " + findMax(arr)); // Result: 13

        arr = new int[] { 3, 8, 3, 1 };
        System.out.println("Result: " + findMax(arr)); // Result: 8
    }
}
