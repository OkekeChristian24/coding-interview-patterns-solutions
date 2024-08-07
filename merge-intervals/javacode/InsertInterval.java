import java.util.List;
import java.util.ArrayList;

class Interval {
    int start;
    int end;

    Interval(int x, int y) {
        start = x;
        end = y;
    }
}

/*
 * Question: Given a list of non-overlapping intervals sorted by their start
 * time, insert a given interval at the correct position and merge all necessary
 * intervals to produce a list that has only mutually exclusive intervals.
 * 
 * Example 1:
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them
 * into one [4,7].
 * 
 * Example 2:
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
 * Output: [[1,3], [4,12]]
 * Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we
 * merged them into [4,12].
 * 
 * Example 3:
 * Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
 * Output: [[1,4], [5,7]]
 * Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them
 * into one [1,4].
 * 
 */
class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        for (; i < intervals.size() && intervals.get(i).end < newInterval.start; i++) {
            result.add(intervals.get(i));
        }
        for (; i < intervals.size() && intervals.get(i).start <= newInterval.end; i++) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
        }
        result.add(newInterval);
        for (; i < intervals.size(); i++) {
            result.add(intervals.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 12));
        List<Interval> result = insert(intervals, new Interval(4, 10));
        System.out.print("Result: ");
        for (Interval interval : result) {
            System.out.print("[" + interval.start + ", " + interval.end + "], "); // Result: [1, 3], [4, 12],
        }
        System.out.println();

        intervals = new ArrayList<>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(5, 7));
        result = insert(intervals, new Interval(1, 4));
        System.out.print("Result: ");
        for (Interval interval : result) {
            System.out.print("[" + interval.start + ", " + interval.end + "], "); // Result: [1, 4], [5, 7],
        }
        System.out.println();

    }

}