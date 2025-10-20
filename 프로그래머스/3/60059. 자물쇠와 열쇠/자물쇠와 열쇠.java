import java.util.*;

class Solution {
    private int N, M, holeCount = 0;
    
    private List<int[]> keyPositions;
    private Set<Integer>[] lockPositions;
    
    private void rotate() {
        for (int[] keyPosition : keyPositions) {
            int trans1 = keyPosition[1], trans2 = (int) Math.abs(N - 1 - keyPosition[0]);
            keyPosition[0] = trans1;
            keyPosition[1] = trans2;
        }
    }
    
    private boolean move() {
        for (int r=(1 - N); r<M; r++) {
            for (int c=(1 - N); c<M; c++) {
                int fillCount = 0;
                boolean collision = false;
                
                for (int[] keyPosition : keyPositions) {
                    if (keyPosition[0] + r < 0 || keyPosition[0] + r >= M || keyPosition[1] + c < 0 || keyPosition[1] + c >= M) {
                        continue;
                    }
                    
                    if (lockPositions[keyPosition[0] + r].isEmpty()) {
                        continue;
                    }
                    
                    if (!lockPositions[keyPosition[0] + r].contains(keyPosition[1] + c)) {
                        collision = true;
                        break;
                    }
                    
                    fillCount++;
                }
                
                if (!collision && fillCount == holeCount) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private void preProcess(int[][] key, int[][] lock) {
        N = key.length;
        M = lock.length;
        
        keyPositions = new LinkedList<>();
        lockPositions = new Set[M];
        
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                if (key[r][c] == 1) keyPositions.add(new int[]{r, c});
            }
        }
        
        for (int i=0; i<M; i++) {
            lockPositions[i] = new HashSet<>();
        }
        
        for (int r=0; r<M; r++) {
            for (int c=0; c<M; c++) {
                if (lock[r][c] == 0) {
                    lockPositions[r].add(c);
                    holeCount++;
                }
            }
        }
    }
    
    private boolean process() {
        for (int r=0; r<4; r++) {
            rotate();
            if (move()) return true;
        }
        
        return false;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        preProcess(key, lock);
        return process();
    }
}