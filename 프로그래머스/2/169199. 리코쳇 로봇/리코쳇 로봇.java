import java.util.*;

class Solution {
    class Robot {
        int row, col, move;
        
        public Robot(int row, int col, int move) {
            this.row = row;
            this.col = col;
            this.move = move;
        }
    }
    
    public int solution(String[] board) {
        Queue<Robot> qu = new LinkedList<>();
        char[][] boardgame = new char[board.length + 2][board[0].length() + 2];
        boolean[][] visited = new boolean[boardgame.length][boardgame[0].length];
        
        for (int row=0; row<boardgame.length; row++) {
            for (int col=0; col<boardgame[0].length; col++) {
                if (row == 0 || row == (boardgame.length - 1) || col == 0 || col == boardgame[0].length - 1) {
                    boardgame[row][col] = 'D';
                } else {
                    char ch = board[row - 1].charAt(col - 1);
                    boardgame[row][col] = ch;
                    
                    if (ch == 'R') {
                        visited[row][col] = true;
                        qu.offer(new Robot(row, col, 0));
                    }
                }
            }
        }
        
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!qu.isEmpty()) {
            Robot robot = qu.poll();
            
            for (int[] direction : directions) {
                int row = robot.row, col = robot.col;
                
                while (boardgame[row + direction[0]][col + direction[1]] != 'D') {
                    row += direction[0];
                    col += direction[1];
                }
                
                if (boardgame[row][col] == 'G') return (robot.move + 1);
                
                if (!visited[row][col]) {
                    visited[robot.row][robot.col] = true;
                    qu.offer(new Robot(row, col, robot.move + 1));
                }
            }
        }
        
        return -1;
    }
}