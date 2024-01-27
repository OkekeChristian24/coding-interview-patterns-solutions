package javacode;

class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}

class SearchInfiniteSortedArray {
    public int searchArray(ArrayReader reader, int key) {
        int start = 0, end = 1;
        while (key > reader.get(end)) {
            int newStart = end + 1;
            int range = (end - start + 1) * 2;
            start = newStart;
            end = newStart + range;
        }

        return binarySearch(reader, start, end, key);
    }

    private int binarySearch(ArrayReader reader, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key > reader.get(mid))
                start = mid + 1;
            else if (key < reader.get(mid))
                end = mid - 1;
            else
                return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInfiniteSortedArray searchInfiniteSortedArray = new SearchInfiniteSortedArray();

        int[] arr = new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 };
        ArrayReader reader = new ArrayReader(arr);

        int result = searchInfiniteSortedArray.searchArray(reader, 16);
        System.out.println("Result: " + result);

        result = searchInfiniteSortedArray.searchArray(reader, 11);
        System.out.println("Result: " + result);

        arr = new int[] { 1, 3, 8, 10, 15 };
        reader = new ArrayReader(arr);
        result = searchInfiniteSortedArray.searchArray(reader, 15);
        System.out.println("Result: " + result);
    }
}