import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        for (int i=0; i<book_time.length; i++) {
            String[] startSplited = book_time[i][0].split(":");
            String[] finishSplited = book_time[i][1].split(":");
            
            int startHour = Integer.parseInt(startSplited[0]), startMinute = Integer.parseInt(startSplited[1]);
            times[i][0] = startHour * 60 + startMinute;
            
            int finishHour = Integer.parseInt(finishSplited[0]), finishMinute = Integer.parseInt(finishSplited[1]);
            times[i][1] = finishHour * 60 + finishMinute + 10;
        }
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        
        Queue<int[]> timeQu = new LinkedList<>();
        for (int i=0; i<times.length; i++) {
            if (timeQu.isEmpty()) {
                timeQu.offer(times[i]);
                continue;
            }
            
            int count = 0;
            boolean needMoreRoom = true;
            while (count < timeQu.size()) {
                int[] room = timeQu.poll(), reserve = times[i];
                
                if (room[1] <= reserve[0]) {
                    timeQu.offer(reserve);
                    needMoreRoom = false;
                    break;
                } else {
                    timeQu.offer(room);
                }
                
                count++;
            }
            
            if (needMoreRoom) timeQu.offer(times[i]);
        }
        
        return timeQu.size();
    }
}