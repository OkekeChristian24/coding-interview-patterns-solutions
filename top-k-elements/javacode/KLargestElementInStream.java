package javacode;

import java.util.PriorityQueue;

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

1. KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
2. int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

Example 1:
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
 
*/
class KLargestElementInStream {
    final int k;
    final PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    public KLargestElementInStream(int k, int[] nums) {
        this.k = k;
        for (int n : nums)
            add(n);
    }

    // Time complexity: O(log k)
    // Space complexity: O(k)
    public int add(int val) {
        this.minHeap.add(val);
        if (this.minHeap.size() > this.k)
            this.minHeap.poll();

        return this.minHeap.peek();
    }
}