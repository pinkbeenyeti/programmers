import java.util.*;
import java.lang.Math;

class Solution {
    class Gamer {
        int x, y, distance;
        
        public Gamer(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    public void fillMap(int[][] map, int[][] rectangle) {
        for (int[] rc : rectangle) {
            int minX = rc[0]*2, minY = rc[1]*2, maxX = rc[2]*2, maxY = rc[3]*2;
            for (int i=minX; i<=maxX; i++) {
                if (map[minY][i] == 0) map[minY][i] = 1;
                if (map[maxY][i] == 0) map[maxY][i] = 1;
            }
            for (int i=minY; i<=maxY; i++) {
                if (map[i][minX] == 0) map[i][minX] = 1;
                if (map[i][maxX] == 0) map[i][maxX] = 1;               
            }
            for (int i=minX+1; i<maxX; i++) {
                for (int j=minY+1; j<maxY; j++) {
                    map[j][i] = 2;
                }
            }
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        int[][] moves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int result = Integer.MAX_VALUE;
        
        fillMap(map, rectangle);
        
        Queue<Gamer> qu = new LinkedList<>();
        qu.offer(new Gamer(characterX*2, characterY*2, 0));
        
        while(!qu.isEmpty()) {
            Gamer gamer = qu.poll();
            visited[gamer.y][gamer.x] = true;
            
            if (gamer.x == itemX*2 && gamer.y == itemY*2) {
                result = Math.min(result, gamer.distance/2);
            }
            
            for (int[] move : moves) {
                int nX = gamer.x + move[0], nY = gamer.y + move[1];
                if (nX < 1 || nX > 100 || nY < 1 || nY > 100) continue;
                if (visited[nY][nX] == true) continue;
                if (map[nY][nX] != 1) continue;
                
                qu.offer(new Gamer(nX, nY, gamer.distance+1));
            }
        }
        
        return result;
    }
}