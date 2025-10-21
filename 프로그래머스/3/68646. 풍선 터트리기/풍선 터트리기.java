import java.util.*;

class Solution {
    public int solution(int[] a) {
        int[][] mins = new int[2][a.length];
        int answer = 0;
        
        mins[0][0] = Integer.MAX_VALUE;
        mins[1][a.length - 1] = Integer.MAX_VALUE;
        
        for (int i=1; i<a.length; i++) {
            mins[0][i] = Math.min(mins[0][i - 1], a[i - 1]);
            mins[1][a.length - 1 - i] = Math.min(mins[1][a.length - i], a[a.length - i]);
        }
        
        for (int i=0; i<a.length; i++) {
            if (a[i] < mins[0][i] || a[i] < mins[1][i]) answer++;
        }
        
        return answer;
    }
}