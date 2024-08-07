
import java.util.*;

class AllMissingNumbers {
    public static List<Integer> findMissingNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                missingNumbers.add(i + 1);
        }
        return missingNumbers;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 1, 8, 2, 3, 5, 1 };
        List<Integer> missingNumbers = findMissingNumbers(nums);
        System.out.println("Missing numbers: " + missingNumbers);

        nums = new int[] { 2, 4, 1, 2 };
        missingNumbers = findMissingNumbers(nums);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}