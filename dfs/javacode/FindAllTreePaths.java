import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v){
        this.value = v;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int v, TreeNode l, TreeNode r){
        this.value = v;
        this.left = l;
        this.right = r;
    }
}

class FindAllTreePaths {

    private static void find(TreeNode node, List<List<Integer>> allPaths, List<Integer> path, int sum){
        if(node == null)
            return;

        path.add(node.value);
        
        if(node.value == sum && node.left == null & node.right == null){
            allPaths.add(new ArrayList<>(path));
        }

        find(node.left, allPaths, path, (sum - node.value));
        find(node.right, allPaths, path, (sum - node.value));
        path.remove(path.size() - 1);

    }

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        find(root, allPaths, path, sum);
        return allPaths;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println("All paths: " + findPaths(root, 23)); // 
        System.out.println("All paths: " + findPaths(root, 16)); // 
    }
}