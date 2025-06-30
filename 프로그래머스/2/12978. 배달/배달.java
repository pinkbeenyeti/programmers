import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int idx, weight;
        
        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int[][] weights = new int[N+1][N+1];
        int[] distance = new int[N+1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        for (int[] rd : road) {
            if (weights[rd[0]][rd[1]] == 0 || weights[rd[0]][rd[1]] > rd[2]) {
                weights[rd[0]][rd[1]] = rd[2];
                weights[rd[1]][rd[0]] = rd[2];
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
            
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            
            for (int i=2; i<=N; i++) {
                if (i == node.idx) continue;
                
                int value = weights[node.idx][i];
                
                if (value != 0 && distance[i] >= node.weight + value) {
                    distance[i] = node.weight + value;
                    pq.offer(new Node(i, node.weight + value));
                }
            }
        }
        
        int answer = 0;
        for (int i=1; i<=N; i++) {
            System.out.println(distance[i]);
            if (distance[i] <= K) answer++;
        }
        
        return answer;
    }
}