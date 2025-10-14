import java.util.Arrays;

class Solution {
    private boolean canPlace(String[][] park, int n) {
        for (int row=0; row<=(park.length - n); row++) {
            for (int col=0; col<=(park[0].length - n); col++) {
                boolean placed = true;
                
                for (int r=row; r<(row + n); r++) {
                    for (int c=col; c<(col + n); c++) {
                        if (!park[r][c].equals("-1")) {
                            placed = false;
                            break;
                        }
                    }
                    
                    if (!placed) break;
                }
                
                if (placed) return true;
            }
        }
        
        return false;
    }
    
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        for (int i=(mats.length - 1); i>=0; i--) {
            if (canPlace(park, mats[i])) return mats[i];
        }
        
        return -1;
    }
}