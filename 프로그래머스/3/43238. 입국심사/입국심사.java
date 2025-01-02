import java.util.Arrays;

class Solution {
    public boolean canTest(int n, long mid, int[] times) {
        long count = 0;
        
        for (int time : times) {
            count += mid / time;
        }
        
        return count >= n;
    }
    
    public long process(int n, int[] times) {
        long L = 1, R = (long) times[times.length - 1] * n;
        long answer = 0;
        
        while (L <= R) {
            long mid = (L + R) / 2;
            
            if (canTest(n, mid, times)) {
                answer = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        
        return answer;
    }
    
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return process(n, times);
    }
}
