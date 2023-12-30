import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (vertices <= 0)
            return sortedOrder;

        // Init the graph
        HashMap<Integer, Integer> inDegrees = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            inDegrees.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // Build the graph
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            inDegrees.put(child, inDegrees.get(child) + 1);
            graph.get(parent).add(child);
        }

        // Find first set of sources
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        // Sort the graph by adding the sources to the sortedOrder list
        while (!sources.isEmpty()) {
            int entry = sources.poll();
            sortedOrder.add(entry);
            List<Integer> children = graph.get(entry);
            for (int child : children) {
                inDegrees.put(child, inDegrees.get(child) - 1);
                if (inDegrees.get(child) == 0)
                    sources.add(child);
            }
        }

        // If the graph is cyclic, topological sort is not possible
        if (sortedOrder.size() != vertices)
            return new ArrayList<>();

        return sortedOrder;

    }

    public static void main(String[] args) {
        List<Integer> result = sort(4, new int[][] {
                new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 }
        });
        System.out.println("Result 1: " + result); // [3, 2, 0, 1]
        result = sort(5, new int[][] {
                new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 }, new int[] { 2, 1 }, new int[] { 3, 1 }
        });
        System.out.println("Result 2: " + result); // [4, 2, 3, 0, 1]
    }
}