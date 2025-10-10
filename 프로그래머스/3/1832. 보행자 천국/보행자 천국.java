class Solution {
    int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[2][m][n];
        
        dp[0][0][0] = 1; // 0은 아래
        dp[1][0][0] = 1; // 1은 오른쪽
        
        for (int col = 1; col < n; col++) {
            if (cityMap[0][col] == 1) continue;
            dp[1][0][col] = dp[1][0][col - 1];
        }

        for (int row = 1; row < m; row++) {
            if (cityMap[row][0] == 1) continue;
            dp[0][row][0] = dp[0][row - 1][0];
        }

        
        for (int row=1; row<m; row++) {
            for (int col=1; col<n; col++) {
                if (cityMap[row][col] == 1) {
                    continue;   
                }
                
                if (row > 0) {
                    if (cityMap[row - 1][col] == 2) dp[0][row][col] = dp[0][row - 1][col];
                    else if (cityMap[row - 1][col] == 0) dp[0][row][col] = (dp[0][row - 1][col] + dp[1][row - 1][col]) % MOD;
                }
                
                if (col > 0) {
                    if (cityMap[row][col - 1] == 2) dp[1][row][col] = dp[1][row][col - 1];
                    else if (cityMap[row][col - 1] == 0) dp[1][row][col] = (dp[1][row][col - 1] + dp[0][row][col - 1]) % MOD;
                }
            }
        }
        
        return (dp[0][m - 1][n - 1] + dp[1][m - 1][n - 1]) % MOD;
     }
}