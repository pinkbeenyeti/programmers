import java.util.*;

class Solution {
    private int answer = 0, time = 0;
    private PriorityQueue<Job> pq = new PriorityQueue<>();
    
    private class Job implements Comparable<Job> {
        int processTime, requestTime, index;
        
        public Job(int processTime, int requestTime, int index) {
            this.processTime = processTime;
            this.requestTime = requestTime;
            this.index = index;
        }
        
        @Override
        public int compareTo(Job other) {
            if (this.processTime != other.processTime) return this.processTime - other.processTime;
            if (this.requestTime != other.requestTime) return this.requestTime - other.requestTime;
            return this.index - other.index;
        }
    }
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a1, a2) -> (a1[0] - a2[0]));
        
        for (int i=0; i<jobs.length; i++) {
            if (time >= jobs[i][0]) pq.offer(new Job(jobs[i][1], jobs[i][0], i));
            else {
                while (!pq.isEmpty() && time < jobs[i][0]) {
                    Job job = pq.poll();
                    time += job.processTime;
                    answer += (time - job.requestTime);
                }
                
                if (time < jobs[i][0]) {
                    time = jobs[i][0];
                }
                
                pq.offer(new Job(jobs[i][1], jobs[i][0], i));
            }
        }
        
        while (!pq.isEmpty()) {
            Job job = pq.poll();
            time += job.processTime;
            answer += (time - job.requestTime);
        }
        
        return answer / jobs.length;
    }
}