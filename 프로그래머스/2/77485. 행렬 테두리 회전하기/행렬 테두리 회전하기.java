
class Solution {
    private int[][] map;
    
    private int rotate(int sr, int sc, int gr, int gc) {
        int[] temps = {map[sr][gc], map[gr][gc], map[gr][sc]};
        int min = Integer.MAX_VALUE;
        
        for (int c=gc; c>sc; c--) map[sr][c] = map[sr][c - 1];
        for (int r=gr; r>sr; r--) map[r][gc] = map[r - 1][gc];
        for (int c=sc; c<gc; c++) map[gr][c] = map[gr][c + 1];
        for (int r=sr; r<gr; r++) map[r][sc] = map[r + 1][sc];
        
        map[sr + 1][gc] = temps[0];
        map[gr][gc - 1] = temps[1];
        map[gr - 1][sc] = temps[2];
        
        for (int c=sc; c<=gc; c++) min = Math.min(min, Math.min(map[sr][c], map[gr][c]));
        for (int r=sr; r<=gr; r++) min = Math.min(min, Math.min(map[r][sc], map[r][gc]));
        
        return min;
    }
    
    private void preProcess(int rows, int columns) {
        map = new int[rows + 1][columns + 1];
        
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=columns; j++) {
                map[i][j] = (i - 1) * columns + j; 
            }
        }
    }
    
    private void process(int[][] queries, int[] answer) {
        for (int i=0; i<queries.length; i++) {
            answer[i] = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        preProcess(rows, columns);
        process(queries, answer);
        
        return answer;
    }
}