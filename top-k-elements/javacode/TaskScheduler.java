package javacode;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

class Pair {
    final private int key;
    final private int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }
}

public class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        Map<Character, Integer> taskFreqMap = new HashMap<>();
        for (char c : tasks)
            taskFreqMap.put(c, taskFreqMap.getOrDefault(c, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> b - a);
        maxHeap.addAll(taskFreqMap.values());

        Queue<Pair> queue = new LinkedList<>();
        int cpuIntervals = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            cpuIntervals++;
            if (!maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                task--;
                if (task > 0)
                    queue.offer(new Pair(task, cpuIntervals + k));
            }

            if (!queue.isEmpty() && queue.peek().getValue() == cpuIntervals) {
                Pair t = queue.poll();
                if (t.getKey() > 0)
                    maxHeap.add(t.getKey());
            }
        }

        return cpuIntervals;
    }

    public static void main(String[] args) {
        char[] tasks = { 'a', 'a', 'a', 'b', 'c', 'c' };
        int k = 2;
        System.out.println("CPU interval: " + scheduleTasks(tasks, k));

        tasks = new char[] { 'a', 'b', 'a' };
        k = 3;
        System.out.println("CPU interval: " + scheduleTasks(tasks, k));

        tasks = new char[] { 'm', 'm', 'p', 'p' };
        k = 2;
        System.out.println("CPU interval: " + scheduleTasks(tasks, k));

    }
}
