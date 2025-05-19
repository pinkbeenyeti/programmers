import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    class Process {
        int priority;
        int index;
        
        public Process(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> qu = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i=0; i<priorities.length; i++) {
            qu.offer(new Process(priorities[i], i));
            pq.offer(priorities[i]);
        }
        
        while(true) {
            Process process = qu.poll();
            
            if (process.priority < pq.peek()) {
                qu.offer(process);
            } else {
                answer++;
                if (process.index == location) return answer;
                pq.poll();
            }
        }
    }
}