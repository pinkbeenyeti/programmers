class Solution {
    private int answer = 0;
    
    private void isNotDestroyed(int[][] preSum, int[][] board) {
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                board[r][c] += preSum[r][c];
                if (board[r][c] > 0) answer++;
            }
        }
    }
    
    private void applyPrefixSum(int[][] preSum, int[][] board) {
        for (int r=0; r<board.length; r++) {
            for (int c=1; c<board[0].length; c++) {
                preSum[r][c] += preSum[r][c - 1];
            }
        }
        
        for (int c=0; c<board[0].length; c++) {
            for (int r=1; r<board.length; r++) {
                preSum[r][c] += preSum[r - 1][c];
            }
        }
    } 
    
    private void prefixSum(int[][] preSum, int type, int r1, int c1, int r2, int c2, int degree) {
        int cost = (type == 1) ? (-degree) : degree;
        
        preSum[r1][c1] += cost;
        preSum[r1][c2 + 1] -= cost;
        preSum[r2 + 1][c1] -= cost;
        preSum[r2 + 1][c2 + 1] += cost;
    }
    
    public int solution(int[][] board, int[][] skills) {
        int[][] preSum = new int[board.length + 1][board[0].length + 1];
        
        for (int[] skill : skills) {
            prefixSum(preSum, skill[0], skill[1], skill[2], skill[3], skill[4], skill[5]);
        }
        
        applyPrefixSum(preSum, board);
        isNotDestroyed(preSum, board);
        
        return answer;
    }
}