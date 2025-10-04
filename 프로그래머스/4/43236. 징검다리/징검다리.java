import java.util.Arrays;
import java.lang.Math;

class Solution {
    private static int process(int distance, int n, int[] distances) {
        int L = 0, R = distance, answer = 0;
        
        while (L <= R) {
            int mid = (L + R) / 2;
            int remove = 0, lastStone = 0;
            
            for (int i=0; i<distances.length - 1; i++) {
                if (distances[i + 1] - lastStone < mid) remove++;
                else lastStone = distances[i + 1];
            }
            
            if (remove > n) {
               R = mid - 1;
            } else {
                answer = mid;
                L = mid + 1;
            }
        }
        
        return answer;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        int[] allDistances = new int[rocks.length + 2];
        
        allDistances[0] = 0;
        allDistances[rocks.length + 1] = distance;
        
        for (int i=1; i<=rocks.length; i++) {
            allDistances[i] = rocks[i - 1];
        }
        
        Arrays.sort(allDistances);
        return process(distance, n, allDistances);
    }
}