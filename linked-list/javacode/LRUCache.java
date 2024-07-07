package javacode;

import java.util.HashMap;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. 
Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity. 


Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

*/

class Node {
    int key;
    int value;
    Node previous;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.previous = this.left;

    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            remove(this.cache.get(key));
        }
        this.cache.put(key, new Node(key, value));
        insert(this.cache.get(key));

        if (this.cache.size() > this.capacity) {
            Node lru = this.left.next;
            remove(lru);
            this.cache.remove(lru.key);
        }
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    // Insert node at right
    private void insert(Node node) {
        Node previous = this.right.previous;
        Node next = this.right;
        previous.next = node;
        node.previous = previous;

        node.next = next;
        next.previous = node;
    }

    private void remove(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        previous.next = next;
        next.previous = previous;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        int answer = lRUCache.get(1); // 1
        System.out.println("Correct answer: " + (answer == 1));
        lRUCache.put(3, 3);
        answer = lRUCache.get(2); // -1
        System.out.println("Correct answer: " + (answer == -1));
    }
}