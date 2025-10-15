import java.util.*;

class Solution {
    private class Box implements Comparable<Box>{
        Stack<Integer> cards;
        
        public Box() {
            this.cards = new Stack<>();
        }
        
        @Override
        public int compareTo(Box other) {
            return other.cards.size() - this.cards.size();
        }
    }
    
    public int solution(int[] cards) {
        PriorityQueue<Box> pq = new PriorityQueue<>();
        
        for (int i=0; i<cards.length; i++){
            if (cards[i] == 0) continue;
            
            Box box = new Box();
            box.cards.push(cards[i]);
            cards[i] = 0;
            
            while (cards[box.cards.peek() - 1] != 0) {
                int index = box.cards.peek() - 1;
                box.cards.push(cards[index]);
                cards[index] = 0;
            }
            
            pq.offer(box);
        }
        
        if (pq.size() > 1) return pq.poll().cards.size() * pq.poll().cards.size();
        else return 0;
    }
}