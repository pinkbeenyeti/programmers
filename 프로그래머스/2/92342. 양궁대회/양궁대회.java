class Solution {
    private int arrowCount = 0;
    private int[] scores = new int[2];
    private int[] liArrows = new int[11];
    private int[] answer = new int[11];
    
    private boolean isBetter() {
        for (int i = 10; i >= 0; i--) {
            if (liArrows[i] > answer[i]) return true;
            if (liArrows[i] < answer[i]) return false;
        }
        
        return false;
    }
    
    private void dfs(int apScore, int liScore, int arrow, int count, int index, int[] info) {
        if (index == 11) {
            liArrows[10] += arrow;
            int ndiff = liScore - apScore, diff = scores[1] - scores[0];
            if (ndiff > diff || (ndiff == diff) && isBetter()) {
                scores[0] = apScore;
                scores[1] = liScore;
                arrowCount = count;
                System.arraycopy(liArrows, 0, answer, 0, 11);
            }
            
            liArrows[10] -= arrow;
            return;
        }
        
        if (arrow >= info[index]+1) {
            liArrows[index] = info[index] + 1;
            dfs(apScore, liScore + (10-index), arrow - (info[index]+1), count+1, index+1, info);
            liArrows[index] = 0;
        }
            
        if (info[index] > 0) {
            dfs(apScore + (10-index), liScore, arrow, count, index+1, info);
        } else {
            dfs(apScore, liScore, arrow, count, index+1, info);
        }
    }
    
    public int[] solution(int n, int[] info) {
        dfs(0, 0, n, 0, 0, info);
        if (scores[1] <= scores[0]) return new int[]{-1};
        return answer;
    }
}
