class Solution {
    public int solution(int n) {
        int oneCount = 0;
        
        for (int i=0; i<20; i++) {
            if ((n & 1<<i) != 0) oneCount++;
        }
        
        int answer = n+1;
        while (true) {
            int count = 0;
            
            for (int i=0; i<20; i++) {
                if ((answer & 1<<i) != 0) count++;
            }
            
            if (count == oneCount) return answer;
            else answer++;
        }
    }
}