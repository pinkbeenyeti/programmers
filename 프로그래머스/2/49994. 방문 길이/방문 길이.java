import java.util.*;

class Solution {
    int[][] dicts = {{2, 0}, {-2, 0}, {0, -2}, {0, 2}};
    int x = 10, y = 10;
    
    private int moveRobot(int[] move, boolean[][] visited) {
        int movedY = y + move[0], movedX = x + move[1];
        if (movedX < 0 || movedX > 20 || movedY < 0 || movedY > 20) return 0; 
        
        int lineY = y + (move[0] / 2), lineX = x + (move[1] / 2);
        x = movedX;
        y = movedY;
        
        if (visited[lineY][lineX] == true) return 0;
        else {
            visited[lineY][lineX] = true;
            return 1;
        }
        
    }
    
    public int solution(String dirs) {
        char[] moveChars = new char[]{'U', 'D', 'L', 'R'};
        int[][] dicts = {{2, 0}, {-2, 0}, {0, -2}, {0, 2}};
        
        Map<Character, int[]> moveMap = new HashMap<>();
        for (int i=0; i<4; i++) moveMap.put(moveChars[i], dicts[i]);
        
        int answer = 0;
        boolean[][] visited = new boolean[21][21];
        for (int i=0; i<dirs.length(); i++) {
            char moveDict = dirs.charAt(i);
            answer += moveRobot(moveMap.get(moveDict), visited);
        }
        
        return answer;
    }
}