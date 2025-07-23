import java.util.*;

class Solution {
    class Stock {
        int index, price;
        
        public Stock(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> stack = new Stack<>();
        
        for (int i=0; i<prices.length; i++) {
            while (!stack.isEmpty() && stack.peek().price > prices[i]) {
                    Stock stock = stack.pop();
                    answer[stock.index] = i - stock.index;
            }
            
            stack.push(new Stock(i, prices[i]));
        }
        
        while (!stack.isEmpty()) {
            Stock stock = stack.pop();
            answer[stock.index] = prices.length - stock.index - 1;
        }
            
        return answer;
    }
}