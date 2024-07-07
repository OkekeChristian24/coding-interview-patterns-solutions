
/**
 * Question: Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number. Find the total sum of all the numbers represented by all paths.
 * Leetcode link: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */

class SumOfPathNumbers {
    
    public static int findSumOfPathNumbers(TreeNode root){
        return findSum(root, 0);
    }

    private static int findSum(TreeNode node, int parentSum){

        // Return zero if the current node if null
        if(node == null)
            return 0;
        
        // Calculate the sum for the current path
        int sum = (parentSum * 10) + node.value;

        // Return the path sum if the current node is a leaf
        if(node.left == null && node.right == null)
            return sum;

        // Recursively calculate the path sum for the children of the current node
        return findSum(node.left, sum) + findSum(node.right, sum);

    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println("Sum of all paths: " + findSumOfPathNumbers(root));

        root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Sum of all paths: " + findSumOfPathNumbers(root));








    }
}