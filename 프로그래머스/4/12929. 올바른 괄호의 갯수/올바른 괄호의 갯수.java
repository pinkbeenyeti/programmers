class Solution {
    private int answer = 0;
    
    private void dfs(int n, int open, int close) {
        if (open > n || close > n) return;
        if (close > open) return;
        if (open == n && close == n) {
            answer++;
            return;
        }

        dfs(n, open + 1, close);
        dfs(n, open, close + 1);
    }
    
    public int solution(int n) {;
        dfs(n, 0, 0);
        
        return answer;
    }
}