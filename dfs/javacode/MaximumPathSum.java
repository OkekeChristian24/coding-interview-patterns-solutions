
/**
 * Question: Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum. A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.
 * Leetcode link: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
class MaximumPathSum {
    private static int globalMaxSum;
    private static int findMaxSum(TreeNode node){
        if(node == null)
            return 0;
        
        int leftNodeMaxSum = Math.max(findMaxSum(node.left), 0);
        int rightNodeMaxSum = Math.max(findMaxSum(node.right), 0);
        int nodePathSum = node.value + leftNodeMaxSum + rightNodeMaxSum;
        globalMaxSum = Math.max(globalMaxSum, nodePathSum);

        return Math.max(leftNodeMaxSum, rightNodeMaxSum) + node.value;
    }

    public static int findMaxPathSum(TreeNode root){
        globalMaxSum = Integer.MIN_VALUE;
        findMaxSum(root);
        return globalMaxSum;

    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum path sum: " + findMaxPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum path sum: " + findMaxPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum path sum: " + findMaxPathSum(root));

    }
}