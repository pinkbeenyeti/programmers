class Solution {
    private char[] cmds = {'d', 'l', 'r', 'u'};
    private int[][] dicts = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    
    private boolean dfs(StringBuilder stb, int k, int n, int m, int[] curr, int[] dest) {
        int remainDist = Math.abs(curr[0] - dest[0]) + Math.abs(curr[1] - dest[1]), remainMove = k - stb.length();
        
        if ((remainMove - remainDist) % 2 != 0 || remainDist > remainMove) {
            return false;
        }
        
        if (stb.length() == k) {
            if (curr[0] == dest[0] && curr[1] == dest[1]) return true;
            else return false;
        }
        
        for (int i=0; i<4; i++) {
            int row = curr[0] + dicts[i][0], col = curr[1] + dicts[i][1];
            
            if (row > 0 && row <= n && col > 0 && col <= m) {
                stb.append(cmds[i]);
                curr[0] = row;
                curr[1] = col;
                
                if (dfs(stb, k, n, m, curr, dest)) return true;
                
                stb.delete(stb.length() - 1, stb.length());
                curr[0] -= dicts[i][0];
                curr[1] -= dicts[i][1];
            }
        }
        
        return false;
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder answer = new StringBuilder();
        
        if (dfs(answer, k, n, m, new int[]{x, y}, new int[]{r, c})) return answer.toString();
        else return "impossible";
    }
}