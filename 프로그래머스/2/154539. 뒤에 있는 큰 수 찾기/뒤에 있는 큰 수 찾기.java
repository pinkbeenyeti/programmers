import java.util.*;

class Solution {
    class Data {
        int index, value;
        
        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Data> stack = new Stack<>();
        
        for (int i=0; i<numbers.length; i++) {      
            while (true) {
                if (stack.isEmpty() || stack.peek().value >= numbers[i]) {
                    stack.push(new Data(i, numbers[i]));
                    break;
                }
                
                if (stack.peek().value < numbers[i]) {
                    Data popped = stack.pop();
                    answer[popped.index] = numbers[i];
                }
            }
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop().index] = -1;
        }
        
        return answer;
    }
}