import java.util.*;

class Solution {
    class Tuple implements Comparable<Tuple>{
        Set<Integer> set = new HashSet<>();
        int count = 0;
        
        public Tuple(String tuple) {
            String[] numbers = tuple.split(",");
            for (String number : numbers) set.add(Integer.parseInt(number));
            count = set.size();
        }
        
        @Override
        public int compareTo(Tuple other) {
            return this.count - other.count;
        }
    }
    
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        String[] tuples = s.replace("{", " ").replace("}", " ").trim().split(" , ");
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (String tuple : tuples) pq.offer(new Tuple(tuple));
        
        Set<Integer> accumulated = new HashSet<>();
        while (!pq.isEmpty()) {
            Tuple tuple = pq.poll();
            
            for (int number : tuple.set) {
                if (!accumulated.contains(number)) {
                    answer.add(number);
                    accumulated.add(number);
                    break;
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}