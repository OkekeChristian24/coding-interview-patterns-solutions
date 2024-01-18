package javacode;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int val) {
        this.val = val;
    }
}

class ConnectAllSiblings {
    public static TreeNode connect(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode previous = null;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (previous != null)
                    previous.next = node;
                previous = node;

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);

            }

        }
        return root;
    }

    public static void printTree(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        printTree(connect(root));
    }

}