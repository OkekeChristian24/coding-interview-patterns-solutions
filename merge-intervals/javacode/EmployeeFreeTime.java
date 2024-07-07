
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    public Interval(int x, int y) {
        start = x;
        end = y;
    }
}

class EmployeeInterval {
    // Interval representing the employee's working hour
    Interval interval;
    // Index of a particular employ
    int employeeIndex;
    // Index of the particular employee's work interval
    int elementIndex;

    public EmployeeInterval(Interval x, int y, int z) {
        interval = x;
        employeeIndex = y;
        elementIndex = z;
    }
}

class EmployeeFreeTime {
    public static List<Interval> findFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        // Heap to sort the interval of an employee
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>((a, b) -> a.interval.start - b.interval.start);

        for (int i = 0; i < schedule.size(); i++)
            if (schedule.get(i) != null)
                minHeap.add(new EmployeeInterval(schedule.get(i).get(0), i, 0));

        Interval previousInterval = minHeap.peek().interval;
        while (!minHeap.isEmpty()) {
            EmployeeInterval queueTop = minHeap.poll();

            // Create a free time if previous interval does not overlap current interval
            if (previousInterval.end < queueTop.interval.start) {
                result.add(new Interval(previousInterval.end, queueTop.interval.start));
                // Update the previous interval
                previousInterval = queueTop.interval;
            } else {
                // Update the previous interval for the overlapping intervals
                if (previousInterval.end < queueTop.interval.end) {
                    previousInterval = queueTop.interval;
                }
            }

            // If the current interval has next interval, add to the heap
            List<Interval> employeeSchedule = schedule.get(queueTop.employeeIndex);
            if (employeeSchedule.size() > queueTop.elementIndex + 1) {
                minHeap.add(new EmployeeInterval(employeeSchedule.get(queueTop.elementIndex + 1),
                        queueTop.employeeIndex, queueTop.elementIndex + 1));
            }

        }
        return result;

    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = findFreeTime(input);
        System.out.print("Free interval: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "]");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = findFreeTime(input);
        System.out.print("Free interval: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "]");
        System.out.println();

    }
}