
import java.util.*;

class Solution {
    int[][] dicts = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    Queue<char[][]> placeList = new LinkedList<>();
    
    private boolean findNotKeeping(char[][] placeArray, int pRow, int pCol) {
        boolean[][] visited = new boolean[5][5];
        visited[pRow][pCol] = true;
        
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{pRow, pCol, 0});
        
        while (!qu.isEmpty()) {
            int[] data = qu.poll();
            
            for (int[] dict : dicts) {
                int row = data[0] + dict[0], col = data[1] + dict[1];
                
                if (row >= 0 && row < 5 && col >= 0 && col < 5) {
                    if (visited[row][col] || placeArray[row][col] == 'X') continue;
                    if (placeArray[row][col] == 'P') return false;
                    if (data[2] != 1) {
                        qu.offer(new int[]{row, col, data[2] + 1});
                        visited[row][col] = true;
                    }
                }
            }
        }
        
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (String[] place : places) {
            char[][] placeArray = new char[5][5];
            
            for (int i=0; i<5; i++) {
                placeArray[i] = place[i].toCharArray();
            }
            
            placeList.offer(placeArray);
        }
        
        for (int i=0; i<5; i++) {
            char[][] placeArray = placeList.poll();
            boolean isKeeped = true;
            
            for (int row=0; row<5; row++) {
                if (!isKeeped) break;
                
                for (int col=0; col<5; col++) {
                    if (placeArray[row][col] == 'P') isKeeped = findNotKeeping(placeArray, row, col);
                    if (!isKeeped) break;
                }
            }
            
            if (isKeeped) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
}