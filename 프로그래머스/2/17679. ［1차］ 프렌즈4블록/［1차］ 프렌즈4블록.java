import java.util.*;

class Solution {
    private int[][] moves = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    
    private int removeBlock(ArrayList<int[]> indexes, char[][] game, int m, int n) {
        int removed = 0;
        for (int[] index : indexes) {
            int row = index[0], col = index[1];
            for (int[] move : moves) {
                if (game[row+move[0]][col+move[1]] != 'X') {
                    removed++;
                    game[row+move[0]][col+move[1]] = 'X';
                }
            }
        }
        
        for (int col = 0; col < n; col++) {
            for (int row = m - 1; row >= 0; row--) {
                if (game[row][col] == 'X') {
                    int upper = row - 1;
                    while (upper >= 0 && game[upper][col] == 'X') {
                        upper--;
                    }
                    if (upper >= 0) {
                        game[row][col] = game[upper][col];
                        game[upper][col] = 'X';
                    }
                }
            }
        }
        
        return removed;
    }
    
    public int solution(int m, int n, String[] board) {
        char[][] game = new char[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                game[i][j] = board[i].charAt(j);
            }
        }
        
        int answer = 0;
        while(true) {
            ArrayList<int[]> indexes = new ArrayList<>();
            boolean canExit = true;
            for (int i=0; i<m-1; i++) {
                for (int j=0; j<n-1; j++) {
                    char block = game[i][j];
                    if (block == 'X') continue;
                    if (game[i+1][j] == block && game[i][j+1] == block && game[i+1][j+1] == block) {
                        indexes.add(new int[]{i, j});
                        canExit = false;
                    }
                }
            }
            
            if (canExit) break;
            answer += removeBlock(indexes, game, m, n);
        }
        
        return answer; 
    }
}