import java.util.*;

class Solution {
    private long getTime(int diff, int level, int time_prev, int time_cur) {
        if (diff <= level) return (long) time_cur;
        
        return 0L + (diff - level) * (time_prev + time_cur) + time_cur;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1, right = 100_000;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            long time = times[0];
            
            for (int i=1; i<diffs.length; i++) {
                time += getTime(diffs[i], mid, times[i-1], times[i]);
                if (time > limit) break;
            }
            
            if (time > limit) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}