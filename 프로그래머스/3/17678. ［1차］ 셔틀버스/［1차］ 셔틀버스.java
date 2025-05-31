import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> crewTimes = new PriorityQueue<>();
        for (String time : timetable) {
            String[] parts = time.split(":");
            int totalMinutes = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
            crewTimes.offer(totalMinutes);
        }

        int busTime = 9 * 60;
        int lastCrewTime = -1;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (!crewTimes.isEmpty() && crewTimes.peek() <= busTime && cnt < m) {
                lastCrewTime = crewTimes.poll();
                cnt++;
            }

            if (i == n - 1) {
                if (cnt < m) {
                    lastCrewTime = busTime;
                } else {
                    lastCrewTime -= 1;
                }
            }

            busTime += t;
        }

        return String.format("%02d:%02d", lastCrewTime / 60, lastCrewTime % 60);
    }
}
