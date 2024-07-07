// package javacode;

public class SearchMinimumDifferenceElement {
    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key > arr[mid]) {
                start = mid + 1;
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                return arr[mid];
            }
        }

        if ((arr[start] - key) > key - arr[end])
            return arr[end];
        return arr[start];
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 6, 10 };
        int result = search(arr, 7);
        System.out.println("Result: " + result);
        result = search(arr, 4);
        System.out.println("Result: " + result);

        arr = new int[] { 1, 3, 8, 10, 15 };
        result = search(arr, 12);
        System.out.println("Result: " + result);
    }
}
