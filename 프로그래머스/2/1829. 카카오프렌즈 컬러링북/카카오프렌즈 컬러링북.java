import java.util.*;

class Solution {
    private int[][] dicts = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    private int getArea(boolean[][] visited, int[][] picture, int row, int col, int m, int n) {
        int area = 1;
        
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{row, col});
        visited[row][col] = true;
        
        while (!qu.isEmpty()) {
            int[] pos = qu.poll();
            
            for (int[] dict : dicts) {
                int nr = pos[0] + dict[0], nc = pos[1] + dict[1];
                
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (visited[nr][nc] || picture[nr][nc] != picture[row][col]) continue;
                
                visited[nr][nc] = true;
                qu.offer(new int[]{nr, nc});
                area++;
            }
        }
        
        return area;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int count_area = 0, max_area = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] || picture[i][j] == 0) continue;
                else {
                    count_area++;
                    
                    int area = getArea(visited, picture, i, j, m, n);
                    if (max_area < area) max_area = area;
                }
            }
        }
        
        return new int[]{count_area, max_area};
    }
}