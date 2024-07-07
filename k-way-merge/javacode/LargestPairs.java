import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Question: Given two sorted arrays in descending order, find ‘K’ pairs with
 * the largest sum where each pair consists of numbers from both the arrays.
 * 
 * Example 1:
 * Input: L1=[9, 8, 2], L2=[6, 3, 1], K=3
 * Output: [9, 3], [9, 6], [8, 6]
 * Explanation: These 3 pairs have the largest sum. No other pair has a sum
 * larger than any of these.
 * 
 * Example 2:
 * Input: L1=[5, 2, 1], L2=[2, -1], K=3
 * Output: [5, 2], [5, -1], [2, 2]
 * 
 */
class LargestPairs {

    // Time complexity: O(N∗M∗logK)
    // Space complexity: O(K)
    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length && j < k; j++) {
                if (minHeap.size() < k) {
                    minHeap.add(new int[] { nums1[i], nums2[j] });
                } else {
                    if ((nums1[i] + nums2[j]) > (minHeap.peek()[0] + minHeap.peek()[1])) {
                        minHeap.poll();
                        minHeap.add(new int[] { nums1[i], nums2[j] });
                    } else {
                        break;
                    }
                }
            }
        }

        return new ArrayList<>(minHeap);

    }

    public static void main(String[] args) {
        int[] nums1;
        int[] nums2;
        int k;
        List<int[]> result;

        nums1 = new int[] { 9, 8, 2 };
        nums2 = new int[] { 6, 3, 1 };
        k = 3;
        result = findKLargestPairs(nums1, nums2, k);
        System.out.print("[");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "]");
        System.out.print("]");
    }
}