import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> sortedCourses = new ArrayList<>();
        HashMap<Integer, Integer> reqCourses = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        // Initialize
        for (int i = 0; i < numCourses; i++) {
            reqCourses.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // Build
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1], child = prerequisites[i][0];
            reqCourses.put(child, reqCourses.get(child) + 1);
            graph.get(parent).add(child);
        }

        // Init sources
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : reqCourses.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        while (!sources.isEmpty()) {
            int course = sources.poll();
            sortedCourses.add(course);
            List<Integer> prereqCourses = graph.get(course);
            for (int c : prereqCourses) {
                reqCourses.put(c, reqCourses.get(c) - 1);
                if (reqCourses.get(c) == 0)
                    sources.add(c);
            }
        }

        if (sortedCourses.size() != numCourses)
            return false;

        return true;
    }

    public static void main(String[] args) {
        boolean result = canFinish(4, new int[][] {
                new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 }
        });
        System.out.println("Result 1: " + result); // true
        result = canFinish(5, new int[][] {
                new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 }, new int[] { 2, 1 }, new int[] { 3, 1 }
        });
        System.out.println("Result 2: " + result); // true

        result = canFinish(2, new int[][] {
                new int[] { 1, 0 }, new int[] { 0, 1 }
        });
        System.out.println("Result 3: " + result); // false
    }
}
