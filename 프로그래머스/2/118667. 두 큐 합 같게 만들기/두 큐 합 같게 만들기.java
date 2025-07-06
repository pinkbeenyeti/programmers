import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();
        
        for (int i=0; i<queue1.length; i++) {
            qu1.offer(queue1[i]);
            qu2.offer(queue2[i]);
        }
        
        int count = 0;
        long sum1 = Arrays.stream(queue1).sum(), sum2 = Arrays.stream(queue2).sum();
        
        if ((sum1 + sum2) % 2 != 0) return -1; 
        
        while (!qu1.isEmpty() && !qu2.isEmpty()) {
            if (count > 300_000) return -1;
            
            if (sum1 > sum2) {
                int number = qu1.poll();
                qu2.offer(number);
                sum1 -= number;
                sum2 += number;
                count++;
            } else if (sum1 < sum2) {
                int number = qu2.poll();
                qu1.offer(number);
                sum2 -= number;
                sum1 += number;
                count++;
            } else {
                return count;
            }
        }
        
        return -1;
    }
}