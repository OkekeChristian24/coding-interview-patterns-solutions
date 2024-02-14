import java.util.*;

class Meeting {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/**
 * 
 * Title: Minimum Meeting Rooms
 * 
 * Question: Given a list of intervals representing the start and end time of
 * ‘N’ meetings,
 * find the minimum number of rooms required to hold all the meetings.
 * 
 * Example 1:
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these
 * two meetings.
 * [7,9] can occur in any of the two rooms later.
 * 
 * Example 2:
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to
 * hold all meetings.
 * 
 * Example 3:
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for
 * [2,4] and [4,5].
 */
public class MinimumMeetingRooms {

    public static int getMinimumRoom(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0)
            return 0;
        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));
        int minRoom = 0;
        PriorityQueue<Meeting> activeMeetings = new PriorityQueue<>(meetings.size(),
                (a, b) -> Integer.compare(a.end, b.end));
        for (Meeting meeting : meetings) {
            while (!activeMeetings.isEmpty() && meeting.start >= activeMeetings.peek().end)
                activeMeetings.poll();

            activeMeetings.offer(meeting);
            minRoom = Math.max(minRoom, activeMeetings.size());
        }
        return minRoom;
    }

    public static int getMinimumRoom2(List<Meeting> meetings) {
        int n = meetings.size();
        int[] startings = new int[n];
        int[] endings = new int[n];
        for (int i = 0; i < n; i++) {
            startings[i] = meetings.get(i).start;
            endings[i] = meetings.get(i).end;
        }
        Arrays.sort(startings);
        Arrays.sort(endings);

        int s = 0, e = 0;
        int minReq = 0, count = 0;
        while (s < meetings.size()) {
            if (startings[s] < endings[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            minReq = Math.max(minReq, count);
        }
        return minReq;

    }

    public static void main(String[] args) {
        List<Meeting> meetings = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        System.out.println("Result: " + getMinimumRoom(meetings));
        // System.out.println("Result: " + getMinimumRoom2(meetings));

    }
}