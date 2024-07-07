package javacode;

import java.util.PriorityQueue;

/*
Question: Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.---------------------------------------

Example 1:
Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
Output: 23
Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum of numbers coming
between 5 and 15 is 23 (11+12).

Example 2:
Input: [3, 5, 8, 7], and K1=1, K2=4
Output: 12
Explanation: The sum of the numbers between the 1st smallest number (3) and the 4th smallest 
number (8) is 12 (5+7).


 */
public class SumOfElements {

    // Time complexity: O(N * logN)
    // Space complexity: O(N)
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

    // Time complexity: O(N * logK2)
    // Space complexity: O(K2)
    public static int findSumOfElements2(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length; i++) {
            if (i < k2 - 1)
                maxHeap.add(nums[i]);
            else if (maxHeap.peek() > nums[i]) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < (k2 - k1 - 1); i++)
            sum += maxHeap.poll();

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
