package javacode;

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class ConnectLevelOrderSiblings {
    // First solution
    // public static Node connect(Node root) {
    // if(root == null)
    // return null;
    // Queue<Node> queue = new LinkedList<>();
    // queue.offer(root);
    // while(!queue.isEmpty()){
    // int levelSize = queue.size();
    // Node temp = null;
    // for(int i = 0; i < levelSize; i++){
    // Node currentNode = queue.poll();
    // if(temp != null)
    // temp.next = currentNode;
    // temp = currentNode;

    // if(currentNode.left != null)
    // queue.offer(currentNode.left);
    // if(currentNode.right != null)
    // queue.offer(currentNode.right);
    // }
    // }

    // return root;

    // }

    // Second solution
    public static Node connect(Node root) {
        if (root == null)
            return null;

        Node previous = root;
        Node current;
        while (previous.left != null) {
            current = previous;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null)
                    current.right.next = current.next.left;
                current = current.next;
            }
            previous = previous.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.left.right = new Node(2);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        connect(root);
    }
}
