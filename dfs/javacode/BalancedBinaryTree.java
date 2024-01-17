/*

Given a binary tree, determine if it is 
height-balanced.
A height-balanced binary tree is a binary tree in which the depth of the two 
subtrees of every node never differs by more than one.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true


*/

class Pair<T, S> {
    private T key;
    private S value;

    Pair(T key, S value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return this.key;
    }

    public S getValue() {
        return this.value;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

class BalancedBinaryTree {

    // Time complexity = O(N)
    // Space complexity = O(N)
    public boolean isBalanced(TreeNode root) {
        // Bottom Up approach
        if (root == null)
            return true;
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);

        // DFS approach
        // return dfs(root).getKey();
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        return (1 + Math.max(lh, rh));
    }

    // Time complexity = O(N)
    // Space complexity = O(N)
    private Pair<Boolean, Integer> dfs(TreeNode root) {
        if (root == null)
            return new Pair<Boolean, Integer>(true, 0);

        var left = dfs(root.left);
        var right = dfs(root.right);
        boolean balanced = left.getKey() && right.getKey() && (Math.abs(left.getValue() - right.getValue()) <= 1);

        return new Pair<Boolean, Integer>(balanced, (1 + Math.max(left.getValue(), right.getValue())));
    }
}
