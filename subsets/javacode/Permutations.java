import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        
        queue.offer(new ArrayList<>());
        for(int n: nums){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                List<Integer> oldPermutation = queue.poll();
                for(int j = 0; j <= oldPermutation.size(); j++){
                    List<Integer> perm = new ArrayList<>(oldPermutation);
                    perm.add(j, n);
                    if(perm.size() == nums.length)
                        result.add(perm);
                    else
                        queue.offer(perm);

                }
            }

        }
        return result;
    }

    public static List<List<Integer>> findPermutationsRecursively(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        permutationRecursion(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private static void permutationRecursion(int[] nums, int index, List<Integer> currentPermutation, List<List<Integer>> result){
        if(index == nums.length)
            result.add(currentPermutation);
        else {
            for(int i = 0; i <= currentPermutation.size(); i++){
                List<Integer> newPerm = new ArrayList<>(currentPermutation);
                newPerm.add(i, nums[index]);

                permutationRecursion(nums, index + 1, newPerm, result);
            }
        }
    }

    public static void printArray(int[] nums){
        System.out.print("Permutation of [");
        for(int i = 0; i < nums.length; i++){
            if(i == nums.length - 1)
                System.out.print(nums[i]);
            else
                System.out.print(nums[i] + ", ");
        }
        System.out.print("]");
    }

    public static void main(String[] args){
        int[] nums = new int[] {1, 3, 5};
        printArray(nums);
        System.out.println(" is " + findPermutations(nums));

        nums = new int[] {7, 4, 1, 2};
        printArray(nums);
        System.out.println(" is " + findPermutations(nums));


    }
}