/*
 * Given a binary tree, find the length of its diameter. The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
 * The diameter of a tree may or may not pass through the root.
 * Note: You can always assume that there are at least two leaf nodes in the given tree.  
 * 
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class TreeDiameter {
    static int diameter = 0;

    public static void getDiameter(TreeNode root) {
        getDiameterRecursive(root);
        // calculateHeightRecursive(root);

    }

    /*
     * Time complexity = O(N)
     * Space complexity = O(N)
     */
    private static int getDiameterRecursive(TreeNode currentNode) {
        if (currentNode == null)
            return 0;

        if (currentNode.left == null && currentNode.right == null)
            return 1;

        int leftChildHeight = getDiameterRecursive(currentNode.left);
        int rightChildHeight = getDiameterRecursive(currentNode.right);

        diameter = Math.max(diameter, (leftChildHeight + rightChildHeight + 1));
        
        return Math.max(leftChildHeight, rightChildHeight) + 1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        getDiameter(root);
        System.out.println("Diameter: " + diameter);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.right = new TreeNode(10);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.right = new TreeNode(11);

        getDiameter(root);
        System.out.println("Diameter: " + diameter);
    }
}