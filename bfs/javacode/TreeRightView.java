
import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int x) {
        val = x;
    }
}

class TreeRightView {

    public static List<Integer> findRights(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                // Append element to the result if it is the node of this level
                if (i == n - 1)
                    result.add(node.val);

                // Add children nodes of the current node to the queue
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(9);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(3);
        root.left.right.right = new TreeNode(8);
        List<Integer> result = findRights(root);
        System.out.println("Result: " + result); // Result: [5, 1, 3, 8]

        root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.right = new TreeNode(3);
        result = findRights(root);
        System.out.println("Result: " + result); // Result: [12, 1, 5, 3]

    }
}