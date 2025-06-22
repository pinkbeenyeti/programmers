class Solution {
    int normalize = 1_000_000_007;
    
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[2] = 3;
        dp[4] = 11;
        
        for (int i=6; i<=n; i+=2) {
            dp[i] = (int) (((4L*dp[i-2] - dp[i-4]) % normalize + normalize) % normalize);
        }
        
        return dp[n];
    }
}