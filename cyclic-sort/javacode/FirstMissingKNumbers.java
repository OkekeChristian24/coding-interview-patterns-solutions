
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class FirstMissingKNumbers {
    public static List<Integer> findMissing(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] - 1, nums);
            } else {
                i++;
            }
        }

        i = 0;
        Set<Integer> contained = new HashSet<>();
        while (true) {
            if (i < nums.length) {
                if (nums[i] != i + 1) {
                    result.add(i + 1);
                    contained.add(nums[i]);
                }
            } else {
                if (result.size() < k) {
                    if (!contained.contains(i + 1))
                        result.add(i + 1);
                }
            }
            if (result.size() == k)
                break;

            i++;
        }
        return result;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, -1, 4, 5, 5 };
        int k = 3;
        System.out.println("Result: " + findMissing(nums, k)); // Result: [1, 2, 6]

        nums = new int[] { 2, 3, 4 };
        k = 3;
        System.out.println("Result: " + findMissing(nums, k)); // Result: [1, 5, 6]

        nums = new int[] { -2, -3, 4 };
        k = 2;
        System.out.println("Result: " + findMissing(nums, k)); // Result: [1, 2]
    }
}