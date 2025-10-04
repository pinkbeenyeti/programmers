import java.util.*;
import java.lang.Math;

class Solution {
    private static int result = 0;
    
    private static List<Island>[] graph;
    
    private static class Island implements Comparable<Island> {
        int to, cost;
        
        public Island(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Island other) {
            return this.cost - other.cost;
        }
    }
    
    private static void preProcess(int n, int[][] costs) {
        graph = new List[n];
        
        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] cost : costs) {
            graph[cost[0]].add(new Island(cost[1], cost[2]));
            graph[cost[1]].add(new Island(cost[0], cost[2]));
        }
    }
    
    private static void process(int n) {
        boolean[] visited = new boolean[n];
        
        PriorityQueue<Island> pq = new PriorityQueue<>();
        pq.offer(new Island(0, 0));
        
        while (!pq.isEmpty()) {
            Island current = pq.poll();
            
            if (visited[current.to]) continue;
            else {
                visited[current.to] = true;
                result += current.cost;
            }
            
            for (Island island : graph[current.to]) {
                if (visited[island.to]) continue;
                else {
                    pq.offer(new Island(island.to, island.cost));
                }
            }
        }
    }
    
    public int solution(int n, int[][] costs) {
        preProcess(n, costs);
        process(n);
        
        return result;
    }
}