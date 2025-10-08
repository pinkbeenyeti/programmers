import java.util.*;

class Solution {
    private int[][] dicts = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private long[][][] costs;
    private int[] answer = new int[2];
    
    private class Info implements Comparable<Info> {
        int row, col, count;
        long cost;
        
        public Info(int row, int col, int count, long cost) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Info other) {
            if (this.count != other.count) return this.count - other.count;
            return Long.compare(this.cost, other.cost);
        }
    }
    
    public int[] solution(int m, int n, int s, int[][] time_map) {
        costs = new long[m * n][m][n];
        
        for (int count=0; count<(m * n); count++) {
            long[][] array = costs[count];
            for (long[] row : array) Arrays.fill(row, Long.MAX_VALUE);
        }
        
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(0, 0, 0, time_map[0][0]));
        
        while (!pq.isEmpty()) {
            Info info = pq.poll();
            
            if ((info.count + 1) >= (m * n)) {
                continue;
            }
            
            for (int[] dict : dicts) {
                int row = info.row + dict[0], col = info.col + dict[1];
                
                if (costs[info.count][info.row][info.col] < info.cost) {
                    continue;
                } 
                
                if (row >= 0 && row < m && col >= 0 && col < n && time_map[row][col] != -1) {
                    if (info.cost + time_map[row][col] > s) {
                        continue;
                    }
                    
                    if (costs[info.count + 1][row][col] > info.cost + time_map[row][col]) {
                        costs[info.count + 1][row][col] = info.cost + time_map[row][col];
                        pq.offer(new Info(row, col, info.count + 1, costs[info.count + 1][row][col]));
                    }
                }
            }
        }
        
        for (int i=0; i<(m * n); i++) {
            if (costs[i][m - 1][n - 1] != Long.MAX_VALUE) {
                answer[0] = i;
                answer[1] = (int) costs[i][m - 1][n - 1];
                break;
            }
        }
        
        return answer;
    }
}