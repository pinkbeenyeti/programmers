class Solution {
    long nrm = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        long dp[] = new long[n+1];
        for (int i=0; i<=n; i++) dp[i] = 0;
        
        for (int coin : money) {
            dp[coin] += 1;
            for (int i=coin; i<=n; i++) {
                dp[i] =  (dp[i] + dp[i-coin]) % nrm; 
            }
        }
        
        return (int) dp[n];
    }
}