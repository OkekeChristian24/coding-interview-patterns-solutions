
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v, TreeNode l, TreeNode r){
        this.value = v;
        this.left = l;
        this.right = r;
    }

    public TreeNode(int v){
        this.value = v;
        this.left = null;
        this.right = null;
    }

    
}

class TreePathSum {

    public static boolean hasPath(TreeNode node, int sum){
        if(node == null)
            return false;
        
        if(node.value == sum && node.left == null && node.right == null)
            return true;
        
        return hasPath(node.left, (sum - node.value)) || hasPath(node.right, (sum - node.value));

    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path: " + hasPath(root, 23)); // true
        System.out.println("Tree has path: " + hasPath(root, 16)); // false

    }
}