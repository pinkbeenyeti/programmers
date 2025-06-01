class Solution {
    final int normal = 1_000_000_007;
    final int block = Integer.MAX_VALUE;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n];
        for(int[] puddle : puddles) {
            dp[puddle[0]-1][puddle[1]-1] = block;
        }
        
        int left, top, value;
        dp[0][0] = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (dp[i][j] == block || (i==0 && j==0)) continue;
                left = (i-1 < 0 || dp[i-1][j] == block) ? 0 : dp[i-1][j];
                top = (j-1 < 0 || dp[i][j-1] == block) ? 0 : dp[i][j-1];
                dp[i][j] = (dp[i][j] + left + top) % normal;
            }
        }
        
        return dp[m-1][n-1];
    }
}