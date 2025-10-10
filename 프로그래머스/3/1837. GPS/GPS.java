import java.util.*;

class Solution {
    private int result = 0;
    private int[][] dp;
    private List<Integer>[] nearList;
    
    private void preProcess(int k, int node, int startNode, int[][] edge_list) {
        dp = new int[k + 1][node + 1];
        
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        dp[1][startNode] = 0;
        
        nearList = new List[node + 1];
        
        for (int n=1; n<=node; n++) {
            nearList[n] = new LinkedList<>();
        }
        
        for (int[] edge : edge_list) {
            nearList[edge[0]].add(edge[1]);
            nearList[edge[1]].add(edge[0]);
        }
    }
    
    private void process(int n, int[][] edge_list, int k, int[] gps_log) {
        for (int t=1; t<k; t++) {
            for (int node=1; node<=n; node++) {
                if (dp[t][node] != Integer.MAX_VALUE) {
                    for (int nextNode : nearList[node]) {
                        dp[t + 1][nextNode] = Math.min(dp[t + 1][nextNode], (gps_log[t] != nextNode) ? dp[t][node] + 1 : dp[t][node]);
                    }
                }
            }
        }
        
        if (dp[k][gps_log[k - 1]] == Integer.MAX_VALUE) result = -1;
        else result = dp[k][gps_log[k - 1]];
    }
    
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        preProcess(k, n, gps_log[0], edge_list);
        process(n, edge_list, k, gps_log);
        
        return result;
    }
}