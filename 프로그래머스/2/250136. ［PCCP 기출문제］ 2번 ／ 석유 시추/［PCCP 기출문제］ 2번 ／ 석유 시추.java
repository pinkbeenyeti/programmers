import java.util.*;

public class Solution {
    public int solution(int[][] land) {
        int depth = land.length;
        int oilNum = land[0].length;
        int[] oils = new int[oilNum];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int y = 0; y < depth; y++) {
            for (int x = 0; x < oilNum; x++) {
                if (land[y][x] == 0) {
                    continue;
                }
                
                Queue<int[]> qu = new LinkedList<>();
                qu.add(new int[]{y, x});
                land[y][x] = 0;
                Set<Integer> connect = new HashSet<>();
                int amount = 0;
                
                while (!qu.isEmpty()) {
                    int[] pos = qu.poll();
                    int y1 = pos[0], x1 = pos[1];
                    amount++;
                    connect.add(x1);
                    
                    for (int[] direction : directions) {
                        int dy = direction[0], dx = direction[1];
                        int ny = y1 + dy, nx = x1 + dx;
                        if (nx >= 0 && nx < oilNum && ny >= 0 && ny < depth && land[ny][nx] == 1) {
                            qu.add(new int[]{ny, nx});
                            land[ny][nx] = 0;
                        }
                    }
                }
                
                for (int num : connect) {
                    oils[num] += amount;
                }
            }
        }
        
        return Arrays.stream(oils).max().orElse(0);
    }
}
