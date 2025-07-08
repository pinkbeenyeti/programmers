import java.util.*;

class Solution {
    class Fruit implements Comparable<Fruit> {
        int size, count;
        
        public Fruit(int size, int count) {
            this.size = size;
            this.count = count;
        }
        
        @Override
        public int compareTo(Fruit other) {
            return this.count - other.count;
        }
    }
    
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int size : tangerine) {
            if (map.containsKey(size)) map.replace(size, map.get(size) + 1);
            else map.put(size, 1);
        }
        
        PriorityQueue<Fruit> pq = new PriorityQueue<>();
        for (int key : map.keySet()) pq.offer(new Fruit(key, map.get(key)));
        
        int fruitCount = tangerine.length;
        while (fruitCount > k) {
            Fruit fruit = pq.poll();
            
            if (fruitCount - fruit.count > k) fruitCount -= fruit.count;
            else {
                if (fruitCount - fruit.count < k) {
                    fruit.count -= (fruitCount - k);
                    pq.offer(fruit);
                }
                
                break;
            } 
        }
        
        return pq.size();
    }
}