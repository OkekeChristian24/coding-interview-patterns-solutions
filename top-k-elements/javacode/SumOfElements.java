package javacode;

import java.util.PriorityQueue;

public class SumOfElements {

    public static int findSumOfElements(int[] nums, int k1, int k2) {
        int sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int n : nums)
            minHeap.add(n);

        int heapSize = minHeap.size();
        for (int i = 0; i < heapSize; i++) {
            int val = minHeap.poll();
            if (i >= k1 && i < k2 - 1)
                sum += val;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums;
        int k1;
        int k2;

        nums = new int[] { 1, 3, 12, 5, 15, 11 };
        k1 = 3;
        k2 = 6;
        System.out.println("Result: " + findSumOfElements(nums, k1, k2));

        nums = new int[] { 3, 5, 8, 7 };
        k1 = 1;
        k2 = 4;
        System.out.println("Result: " + findSumOfElements(nums, k1, k2));
    }
}
