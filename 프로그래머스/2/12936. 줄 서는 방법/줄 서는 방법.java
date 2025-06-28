import java.util.*;

class Solution {
    private long factorial(int number) {
        long result = 1L;
        
        for (int i=2; i<=number; i++) result *= i;
        
        return result;
    }
    
    private void getOrder(List<Integer> answer, List<Integer> numbers, long nowOrder, long k) {
        long diff = factorial(numbers.size() - 1);
        
        for (int i=0; i<numbers.size(); i++) {
            if ((nowOrder + diff) > k) {
                answer.add(numbers.get(i));
                numbers.remove(i);
                getOrder(answer, numbers, nowOrder, k);
                return;
            } else {
                nowOrder += diff;
            }
        }
    }
    
    public int[] solution(int n, long k) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        
        for (int i=1; i<=n; i++) {
            numbers.add(i);
        }
        
        getOrder(answer, numbers, 1L, k);
        
        int[] answerArray = new int[n];
        for (int i=0; i<answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }
        
        return answerArray;
    }
}