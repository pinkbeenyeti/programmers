class Solution {
    public int solution(int [][]board) {
        int row = board.length, col = board[0].length, answer = 0;
        int[][] dp = new int[row][col];
        
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j] == 1) {
                    if (i==0 || j==0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        
        return answer*answer;
    }
}