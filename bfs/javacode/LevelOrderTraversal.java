import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

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


class LevelOrderTraversal {

    public static List<List<Integer>> traverse(TreeNode root){

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.value);

                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);

            }

            result.add(currentLevel);
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
        System.out.println("Level order traversal: " + traverse(root));
    }
}