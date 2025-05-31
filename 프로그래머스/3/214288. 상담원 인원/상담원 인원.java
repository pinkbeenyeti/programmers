import java.util.*;

class Solution {
    class Consel {
        int clock, time;
        
        public Consel(int clock, int time) {
            this.clock = clock;
            this.time = time;
        }
    }
    
    private int getTime(int mentorsNumber, ArrayList<Consel> consels) {
        PriorityQueue<Integer> mentorsTime = new PriorityQueue<>();
        for (int i=0; i<mentorsNumber; i++) mentorsTime.offer(0);
        
        int waitTime = 0;
        for (Consel consel : consels) {
            if (consel.clock >= mentorsTime.peek()) {
                mentorsTime.poll();
                mentorsTime.offer(consel.clock + consel.time);
            } else {
                waitTime += mentorsTime.peek() - consel.clock;
                int time = mentorsTime.poll();
                mentorsTime.offer(time + consel.time);
            }
        }
        
        return waitTime;
    }
    
    public int solution(int k, int n, int[][] reqs) {
        HashMap<Integer, ArrayList<Consel>> requests = new HashMap<>();
        int[] mentors = new int[k+1];
        for (int i=1; i<=k; i++) { 
            requests.put(i, new ArrayList<Consel>()); 
            mentors[i] = 1;
        }
        for (int[] req : reqs) { 
            ArrayList<Consel> consels = requests.get(req[2]);
            consels.add(new Consel(req[0], req[1]));
        }
        
        n -= k;
        while (n-- > 0) {
            int maxReduce = -1;
            int bestType = -1;
    
            for (int i = 1; i <= k; i++) {
                int before = getTime(mentors[i], requests.get(i));
                int after = getTime(mentors[i] + 1, requests.get(i));
                int reduce = before - after;

                if (reduce > maxReduce) {
                    maxReduce = reduce;
                    bestType = i;
                }
            }

            mentors[bestType]++;
        }
        
        int sum = 0;
        for (int i=1; i<=k; i++) { 
            sum += getTime(mentors[i], requests.get(i));
        }
        return sum;
    }
}