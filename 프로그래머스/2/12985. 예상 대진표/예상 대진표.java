class Solution {
    int answer = 1;
    
    public int solution(int n, int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        while ((a+1) != b || (a % 2 == 0)) {
            if (a % 2 == 0) a = a / 2;
            else a = (a + 1) / 2;
            
            if (b % 2 == 0) b = b / 2;
            else b = (b + 1) / 2;
            
            answer++;
        }
        
        return answer;
    }
}