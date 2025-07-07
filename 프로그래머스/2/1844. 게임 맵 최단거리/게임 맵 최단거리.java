import java.util.*;

class Solution {
    int[][] dicts = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int answer = Integer.MAX_VALUE;
    
    class Robot {
        int row, col, move;
        
        public Robot(int row, int col, int move) {
            this.row = row;
            this.col = col;
            this.move = move;
        }
    }
    
    public int solution(int[][] maps) {
        int rowLimit = maps.length, colLimit = maps[0].length;
        
        Queue<Robot> qu = new LinkedList<>();
        qu.offer(new Robot(0, 0, 1));
        
        boolean[][] visited = new boolean[rowLimit][colLimit];
        visited[0][0] = true;
        
        while (!qu.isEmpty()) {
            Robot robot = qu.poll();
            
            if (robot.row == (rowLimit - 1) && robot.col == (colLimit - 1)) {
                answer = Math.min(answer, robot.move);
            }
            
            for (int[] dict : dicts) {
                int nRow = robot.row + dict[0], nCol = robot.col + dict[1];
                
                if (nRow >= rowLimit || nRow < 0 || nCol >= colLimit || nCol < 0 || visited[nRow][nCol] || maps[nRow][nCol] == 0) continue;
                else {
                    qu.offer(new Robot(nRow, nCol, robot.move + 1));
                    visited[nRow][nCol] = true;
                }
            }
        }
        
        if (answer == Integer.MAX_VALUE) return -1;
        else return answer;
    }
}