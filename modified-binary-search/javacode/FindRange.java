package javacode;

/* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class FindRange {
    private static int getIndex(int[] nums, int target, boolean findMaxIndex) {
        int targetIndex = -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target)
                end = mid - 1;
            else if (nums[mid] < target)
                start = mid + 1;
            else { // found target
                targetIndex = mid;
                if (findMaxIndex)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return targetIndex;
    }

    // Time = O(logN); Space = O(1)
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        result[0] = getIndex(nums, target, false);
        if (result[0] != -1)
            result[1] = getIndex(nums, target, true);

        return result;
    }

    // Time = O(N); Space = O(1)
    public static int[] searchRange2(int[] nums, int target) {
        int[] targetRange = new int[] { -1, -1 };
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                int j = i;
                while (nums[j] == target) {
                    j++;
                }
                i = j;
                targetRange[1] = j - 1;
            }
        }

        return targetRange;
    }

    public static void main(String[] args) {
        int[] result = searchRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");

        result = searchRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");

        result = searchRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }

}