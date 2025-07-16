class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int a=0; a<=d; a+=k) {
            long b = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(a, 2));
            answer = answer + (b / k) + 1;
        }
        
        return answer;
    }
}