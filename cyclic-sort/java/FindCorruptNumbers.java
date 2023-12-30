public class FindCorruptNumbers {
    public static int[] findNumbers(int[] nums) {
        int[] missing = new int[2];
        missing[0] = -1;
        missing[1] = -1;
        if (nums.length == 0)
            return missing;

        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missing[0] = nums[i];
                missing[1] = i + 1;
            }
        }
        return missing;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // int[] result = findMissingAndDuplicate(new int[] {3, 1, 2, 5, 2});
        // int[] result = findMissingAndDuplicate(new int[] {3, 1, 2, 3, 6, 4});
        int[] result = findMissingAndDuplicate(new int[] { 2, 4, 1, 2 }); //
        System.out.println("Result: [" + result[0] + ", " + result[1] + "]");
    }
}
