class Solution {
    private int result = 0;
    
    public int solution(int n, int w, int num) {
        int row = (n % w == 0) ? (n / w) : ((n / w) + 1), glRow = 0, glCol = 0;
        int[][] map = new int[row + 1][w + 1];
        
        for (int r=1; r<=row; r++) {
            for (int c=1; c<=w; c++) {
                if ((c + (r - 1) * w) > n) {
                    break;
                }
                
                if ((r % 2) == 0) map[r][w - c + 1] = c + (r - 1) * w;
                else map[r][c] = c + (r - 1) * w;
                
                if ((c + (r - 1) * w) == num) {
                    glRow = r;
                    glCol = ((r % 2) == 0) ? (w - c + 1) : c;
                }
            }
        }
        
        for (int r=glRow; r<=row; r++) {
            if (map[r][glCol] != 0) result++;
        }
        
        return result;
    }
}