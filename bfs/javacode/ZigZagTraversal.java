import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Question: Given a binary tree, populate an array to represent its zigzag level order traversal. You should populate the values of all nodes of the first level from left to right, then right to left for the next level and keep alternating in the same manner for the following levels.
 * 
 * Leetcode link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 */
class ZigZagTraversal {

    public static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean invert = false;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();

                if(invert)
                    currentLevel.add(0, currentNode.value);
                else
                    currentLevel.add(currentNode.value);
                
                
                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }

            result.add(currentLevel);
            invert = !invert;
        }

        return result;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Zigzag level order traversal: " + traverse(root));
    }
}