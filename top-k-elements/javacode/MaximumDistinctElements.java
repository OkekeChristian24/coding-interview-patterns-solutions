package javacode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair<T, V> {
    private T key;
    private V value;

    public Pair(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getKey() {
        return this.key;
    }
}

/*
 * Question: Given an array of numbers and a number ‘K’, we need to remove ‘K’
 * numbers from the array such that we are left with maximum distinct numbers.
 * 
 * Example 1:
 * Input: [7, 3, 5, 8, 5, 3, 3], and K=2
 * Output: 3
 * Explanation: We can remove two occurrences of 3 to be left with 3 distinct
 * numbers [7, 3, 8], we have
 * to skip 5 because it is not distinct and occurred twice.
 * Another solution could be to remove one instance of '5' and '3' each to be
 * left with three
 * distinct numbers [7, 5, 8], in this case, we have to skip 3 because it
 * occurred twice.
 * 
 * Example 2:
 * Input: [3, 5, 12, 11, 12], and K=3
 * Output: 2
 * Explanation: We can remove one occurrence of 12, after which all numbers will
 * become distinct. Then
 * we can delete any two numbers which will leave us 2 distinct numbers in the
 * result.
 * 
 * Example 3:
 * Input: [1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5], and K=2
 * Output: 3
 * Explanation: We can remove one occurrence of '4' to get three distinct
 * numbers.
 */

public class MaximumDistinctElements {

    // Time complexity: O(N*logN + KlogN)
    // Space complexity: O(N)
    public static int findMaximumDistinctElements(int[] nums, int k) {
        int count = 0;
        if (nums.length <= k)
            return 0;

        Map<Integer, Integer> numsFreq = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (int n : nums) {
            int f = numsFreq.getOrDefault(n, 0);
            numsFreq.put(n, f + 1);
        }
        for (Map.Entry<Integer, Integer> m : numsFreq.entrySet()) {
            if (m.getValue() == 1)
                count++;
            else
                minHeap.offer(new Pair<Integer, Integer>(m.getKey(), m.getValue()));
        }

        while (k > 0 && !minHeap.isEmpty()) {
            Pair<Integer, Integer> pair = minHeap.poll();
            int pairValue = pair.getValue() - 1;
            k = k - pairValue;
            if (k >= 0) {
                count++;
            }

        }
        if (k > 0)
            count -= k;
        return count;
    }

    public static void main(String[] args) {
        int[] nums;
        int k;
        nums = new int[] { 7, 3, 5, 8, 5, 3, 3 };
        k = 2;
        System.out.println("Result: " + findMaximumDistinctElements(nums, k));

        nums = new int[] { 3, 5, 12, 11, 12 };
        k = 3;
        System.out.println("Result: " + findMaximumDistinctElements(nums, k));

        nums = new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 };
        k = 2;
        System.out.println("Result: " + findMaximumDistinctElements(nums, k));
    }
}
