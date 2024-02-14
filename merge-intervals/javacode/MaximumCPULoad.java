import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

class Job {
    int start;
    int end;
    int cpuLoad;

    Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
}

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        int maxLoad = 0;
        Collections.sort(jobs, (a, b) -> a.start - b.start);
        Job job = jobs.get(0);
        Job intersectedJobs = job;
        for (int i = 1; i < jobs.size(); i++) {
            // Check if overlaps
            if (job.end >= jobs.get(i).start) {
                // Check if intersect
                if (intersectedJobs.end < jobs.get(i).start)
                    intersectedJobs = job;

                intersectedJobs.start = Math.max(job.start, jobs.get(i).start);
                intersectedJobs.end = Math.min(job.end, jobs.get(i).end);
                intersectedJobs.cpuLoad += jobs.get(i).cpuLoad;
                maxLoad = Math.max(maxLoad, intersectedJobs.cpuLoad);
            } else {
                maxLoad = Math.max(maxLoad, job.cpuLoad);
            }
            job = jobs.get(i);
        }
        maxLoad = Math.max(maxLoad, job.cpuLoad);

        return maxLoad;
    }

    public static int findMaxCPULoad2(List<Job> jobs) {
        Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
        int maxCPULoad = 0;
        int currentCPULoad = 0;
        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));

        for (Job job : jobs) {
            while (!minHeap.isEmpty() && job.start > minHeap.peek().end) {
                currentCPULoad -= minHeap.poll().cpuLoad;
            }

            minHeap.offer(job);
            currentCPULoad += job.cpuLoad;

            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
        }

        return maxCPULoad;
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 4, 3));
        jobs.add(new Job(2, 5, 4));
        jobs.add(new Job(7, 9, 6));
        System.out.println("Result: " + findMaxCPULoad2(jobs)); // Result: 7

        jobs = new ArrayList<>();
        jobs.add(new Job(6, 7, 10));
        jobs.add(new Job(2, 4, 11));
        jobs.add(new Job(8, 12, 15));
        System.out.println("Result: " + findMaxCPULoad2(jobs)); // Result: 15

        jobs = new ArrayList<>();
        jobs.add(new Job(1, 4, 2));
        jobs.add(new Job(2, 4, 1));
        jobs.add(new Job(3, 6, 5));
        System.out.println("Result: " + findMaxCPULoad2(jobs)); // Result: 8
    }
}