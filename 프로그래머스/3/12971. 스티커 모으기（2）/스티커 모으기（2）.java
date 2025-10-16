class Solution {
    public int solution(int sticker[]) {
        if (sticker.length == 1) return sticker[0];
        
        int[][] dpFirst = new int[2][sticker.length], dpSecond = new int[2][sticker.length];
        
        dpFirst[0][0] = sticker[0];
        dpSecond[0][1] = sticker[1];
        
        for (int i=1; i<(sticker.length - 1); i++) {
            dpFirst[0][i] = dpFirst[1][i - 1] + sticker[i];
            dpFirst[1][i] = Math.max(dpFirst[0][i - 1], dpFirst[1][i - 1]);
        }
        
        for (int i=2; i<sticker.length; i++) {
            dpSecond[0][i] = dpSecond[1][i - 1] + sticker[i];
            dpSecond[1][i] = Math.max(dpSecond[0][i - 1], dpSecond[1][i - 1]);
        }

        return Math.max(Math.max(dpFirst[0][sticker.length - 2], dpFirst[1][sticker.length - 2]), 
                        Math.max(dpSecond[0][sticker.length - 1], dpSecond[1][sticker.length - 1]));
    }
}