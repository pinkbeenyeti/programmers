import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;
        for(int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        
        alp = Math.min(maxAlp, alp);
        cop = Math.min(maxCop, cop);
        
        int[][] dp = new int[maxAlp+2][maxCop+2];
        for(int i=0; i<maxAlp+2; i++) {
            for (int j=0; j<maxCop+2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        for(int i=alp; i<=maxAlp; i++) {
            for(int j=cop; j<=maxCop; j++) {
                if(dp[i][j] == Integer.MAX_VALUE) continue;
                if(i+1 <= maxAlp) dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                if(j+1 <= maxCop) dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for(int[] problem : problems) {
                    if (i >= problem[0] && j >= problem[1]) {
                        int nextAlp = Math.min(maxAlp, i+problem[2]);
                        int nextCop = Math.min(maxCop, j+problem[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j]+problem[4]);
                    }
                }
            }
        }
        
        return dp[maxAlp][maxCop];
    }
}