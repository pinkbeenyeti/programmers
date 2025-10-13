class Solution {
    private int getMaxDivided(int a, int b) {
        while (a != b) {
            if (a > b) a -= b;
            else b -= a;
        }
        
        return a;
    }
    
    private int getMinMultipled(int a, int b, int divisor) {
        return divisor * (a / divisor) * (b / divisor);
    }
    
    public int[] solution(int n, int m) {
        int max = getMaxDivided(n, m);
        int min = getMinMultipled(n, m, max);
        
        return new int[]{max, min};
    }
}