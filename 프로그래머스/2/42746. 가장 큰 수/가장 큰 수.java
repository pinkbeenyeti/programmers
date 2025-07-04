import java.util.*;

class Solution {
    class NumberInfo implements Comparable<NumberInfo>{
        String number;
        
        public NumberInfo(String number) {
            this.number = number;
        }
        
        public int compareTo(NumberInfo other) {
            String a = number + other.number;
            String b = other.number + number;
            return b.compareTo(a);
        }
    }
    public String solution(int[] numbers) {
        PriorityQueue<NumberInfo> pq = new PriorityQueue<>();
        for (int number : numbers) {
            pq.offer(new NumberInfo("" + number));
        }
        
        StringBuilder answer = new StringBuilder();
        while (!pq.isEmpty()) {
            NumberInfo value = pq.poll();
            answer.append(value.number);
        }
        
        if (answer.charAt(0) == '0') return "0";
        
        return answer.toString();
    }
}