import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        List<Long> result = new ArrayList<>();
        
        for (long number : numbers) {
            if ((number % 2) == 0) result.add(number + 1);
            else {
                int index = 0;
                long nNum = 0;
                
                while (true) {
                    if ((number & (1L<<index)) == 0) {
                        nNum = number + (1L<<index) - (1L<<(index-1));  
                        break;
                    }
                    
                    index++;
                }
                
                result.add(nNum);
            }
        }
        
        long[] answer = new long[numbers.length];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}