import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0, index = 0;
        
        Queue<Integer> container = new LinkedList<>();
        Stack<Integer> tempContainer = new Stack<>();
        for (int i=1; i<=order.length; i++) container.offer(i);
        
        while (!container.isEmpty()) {
            int box = container.poll();
            
            if (box == order[index]) {
                answer++;
                index++;
                continue;
            }
            
            while (!tempContainer.isEmpty() && tempContainer.peek() == order[index]) {
                answer++;
                index++;
                tempContainer.pop();
            }
            
            tempContainer.push(box);
        }
        
        while (!tempContainer.isEmpty()) {
            if (order[index] == tempContainer.peek()) {
                answer++;
                index++;
                tempContainer.pop();
            } else {
                break;
            }
        }
        
        return answer;
    }
}