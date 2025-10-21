import java.util.*;

class Solution {
    private int answer = Integer.MAX_VALUE;
    private int[][][] numberPads = new int[12][4][3];
    private int[][] dicts = {{-1, 0, 2}, {1, 0, 2}, {0, -1, 2},
                             {0, 1, 2}, {1, 1, 3}, {1, -1, 3},
                             {-1, 1, 3}, {-1, -1, 3}};
    
    private Map<Character, int[]> positions = Map.ofEntries(
        Map.entry('1', new int[]{0, 0}), Map.entry('2', new int[]{0, 1}), Map.entry('3', new int[]{0, 2}),
        Map.entry('4', new int[]{1, 0}), Map.entry('5', new int[]{1, 1}), Map.entry('6', new int[]{1, 2}),
        Map.entry('7', new int[]{2, 0}), Map.entry('8', new int[]{2, 1}), Map.entry('9', new int[]{2, 2}),
        Map.entry('*', new int[]{3, 0}), Map.entry('0', new int[]{3, 1}), Map.entry('#', new int[]{3, 2})
    );
    
    private class Info implements Comparable<Info> {
        int row, col, cost;
        
        public Info(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Info other) {
            return this.cost - other.cost;
        }
    }
    
    private void preProcess() {
        for (int[][] numberPad : numberPads) {
            for (int[] row : numberPad) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        
        for (int start=0; start<12; start++) {
            PriorityQueue<Info> pq = new PriorityQueue<>();
            pq.offer(new Info(start / 3, start % 3, 0));
            numberPads[start][start / 3][start % 3] = 0;
            
            while (!pq.isEmpty()) {
                Info current = pq.poll();
                
                if (current.cost > numberPads[start][current.row][current.col]) {
                    continue;
                }
                
                for (int[] dict : dicts) {
                    int row = current.row + dict[0], col = current.col + dict[1];
                    
                    if (row >= 0 && row < 4 && col >= 0 && col < 3 && current.cost + dict[2] <= numberPads[start][row][col]) {
                        numberPads[start][row][col] = current.cost + dict[2];
                        pq.offer(new Info(row, col, numberPads[start][row][col]));
                    }
                }
            }
            
            numberPads[start][start / 3][start % 3] = 1;
        }
    }
    
    private void process(String number) {
        int[][][] dp = new int[number.length() + 1][12][12];
        
        for (int[][] numberPad : dp) {
            for (int[] row : numberPad) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        
        dp[0][3][5] = 0;
        
        for (int order=0; order<number.length(); order++) {
            int[] target = positions.get(number.charAt(order));
            int goal = target[0] * 3 + target[1];
            
            for (int l=0; l<12; l++) {
                for (int r=0; r<12; r++) {
                    if (dp[order][l][r] != Integer.MAX_VALUE) {
                        if (goal != r) {
                            dp[order + 1][goal][r] = Math.min(dp[order + 1][goal][r], dp[order][l][r] + numberPads[l][target[0]][target[1]]);
                        }
                        
                        if (goal != l) {
                            dp[order + 1][l][goal] = Math.min(dp[order + 1][l][goal], dp[order][l][r] + numberPads[r][target[0]][target[1]]);
                        }
                    }
                }
            }
        }
        
        for (int l=0; l<12; l++) {
            for (int r=0; r<12; r++) {
                answer = Math.min(answer, dp[number.length()][l][r]);
            }
        }
    }
    
    public int solution(String numbers) {
        preProcess();
        process(numbers);
        
        return answer;
    }
}