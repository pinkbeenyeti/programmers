import java.util.*;

class Solution {
    private int minCost = Integer.MAX_VALUE, N = 0;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private class State implements Comparable<State> {
        int row, col, dir, cost;
        
        public State(int row, int col, int dir, int cost) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(State other) {
            return this.cost - other.cost;
        }
    }
    
    public int solution(int[][] board) {
        PriorityQueue<State> pq = new PriorityQueue<>();
        N = board.length;
        
        int[][][] costs = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }
        
        if (board[0][1] == 0) {
            costs[0][1][3] = 100;
            pq.offer(new State(0, 1, 3, 100));
        }
        
        if (board[1][0] == 0) {
            costs[1][0][1] = 100;
            pq.offer(new State(1, 0, 1, 100));
        }

        while (!pq.isEmpty()) {
            State current = pq.poll();
            
            if (current.cost > costs[current.row][current.col][current.dir]) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + dirs[i][0];
                int nextCol = current.col + dirs[i][1];
                
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N || board[nextRow][nextCol] == 1) {
                    continue;
                }
                
                int newCost = current.cost + 100;
                if (current.dir != i) {
                    newCost += 500;
                }
                
                if (costs[nextRow][nextCol][i] > newCost) {
                    costs[nextRow][nextCol][i] = newCost;
                    pq.offer(new State(nextRow, nextCol, i, newCost));
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            minCost = Math.min(minCost, costs[N - 1][N - 1][i]);
        }
        
        return minCost;
    }
}