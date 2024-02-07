package javacode;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class Pair<T, V> {
    final T key;
    final V value;

    public Pair(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

}

class KClosestNumbers {

    public static List<Integer> findClosest(int[] nums, int k, int x) {
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int n : nums) {
            maxHeap.add(new Pair<Integer, Integer>(n, Math.abs(n - x)));
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        List<Integer> result = new ArrayList<Integer>(maxHeap.size());
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums;
        int k, x;
        nums = new int[] { 5, 6, 7, 8, 9 };
        k = 3;
        x = 7;
        System.out.println("Result: " + findClosest(nums, k, x)); // Result: [6, 8, 7]

    }

}