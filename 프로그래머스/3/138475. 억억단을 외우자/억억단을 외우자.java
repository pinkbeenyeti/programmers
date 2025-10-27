import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] counts = new int[e + 1], maxCount = new int[e + 1], answer = new int[starts.length];
        Arrays.fill(counts, 1);
        
        for (int i=2; i<=e; i++) {
            int multiple = 1;
            
            while (i * multiple <= e) {
                counts[i * multiple]++;
                multiple++;
            }
        }
        
        maxCount[e] = e;
        
        for (int i=(e - 1); i>0; i--) {
            if (counts[maxCount[i + 1]] > counts[i]) maxCount[i] = maxCount[i + 1];
            else maxCount[i] = i;
        }
        
        for (int i=0; i<starts.length; i++) {
            answer[i] = maxCount[starts[i]];
        }
        
        return answer;
    }
}