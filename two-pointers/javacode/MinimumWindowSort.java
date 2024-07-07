package javacode;

/*
 * Given an array, find the length of the smallest 
 * subarray in it which when sorted will sort the whole array.
 * 
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 * 
 * Input: [1, 3, 2, 0, -1, 7, 10]
 * Output: 5
 * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 * 
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 * 
 * Input: [1, 2, 3]
 * Output: 0
 * Explanation: The array is already sorted
 * 
 * Input: [3, 2, 1]
 * Output: 3
 * Explanation: The whole array needs to be sorted
 * 
 */
class MinimumWindowSort {

    public static int sort(int[] nums) {
        int numsLen = nums.length;
        int low = 0, high = numsLen - 1;

        // Find the first number out of sort order from the beginning
        while (low < (numsLen - 1) && nums[low] <= nums[low + 1])
            low++;

        // If the array is completely sorted, return 0
        if (low == (numsLen - 1))
            return 0;

        // Find the first number out of the sort order from the end
        while (high > 0 && nums[high] >= nums[high - 1])
            high--;

        int subMax = Integer.MIN_VALUE, subMin = Integer.MAX_VALUE;
        // Find the min & max values in the sub-array (btw low & high)
        for (int i = low; i <= high; i++) {
            subMax = Math.max(subMax, nums[i]);
            subMin = Math.min(subMin, nums[i]);
        }

        // Include any value bigger than the minimum value of the sub-array
        while (low > 0 && nums[low - 1] > subMin)
            low--;

        // Include any value smaller than the maximum value of the sub-array
        while (high < (numsLen - 1) && nums[high + 1] < subMax)
            high++;

        return (high - low + 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 2, 0, -1, 7, 10 };
        int res = sort(nums);
        System.out.println("Result: " + res); // Result: 5

        nums = new int[] { 1, 2, 3 };
        res = sort(nums);
        System.out.println("Result: " + res); // Result: 0

        nums = new int[] { 1, 2, 5, 3, 7, 10, 9, 12 };
        res = sort(nums);
        System.out.println("Result: " + res); // Result: 5
    }

}