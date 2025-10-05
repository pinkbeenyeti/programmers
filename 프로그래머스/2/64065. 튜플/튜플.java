import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    private class Tuples implements Comparable<Tuples> {
        int size;
        String[] set;
        
        public Tuples(int size, String[] set) {
            this.size = size;
            this.set = set;
        }
        
        @Override
        public int compareTo(Tuples other) {
            return this.size - other.size;
        }
    }
    
    public int[] solution(String s) {
        PriorityQueue<Tuples> pq = new PriorityQueue<>();
        List<Integer> answer = new ArrayList<>();
        
        Pattern pattern = Pattern.compile("\\{([0-9,])*[0-9]\\}");
        Matcher matcher = pattern.matcher(s);
        
        while (matcher.find()) {
            String compiled = matcher.group();
            String[] set = compiled.substring(1, compiled.length() - 1).split(",");
            
            pq.offer(new Tuples(set.length, set));
        }
        
        Set<String> accumulated = new HashSet<>();
        
        while (!pq.isEmpty()) {
            Tuples tuples = pq.poll();
            
            for (String number : tuples.set) {
                if (!accumulated.contains(number)) {
                    answer.add(Integer.parseInt(number));
                    accumulated.add(number);
                    break;
                }
            }
        }
        
        int[] result = new int[answer.size()];
        
        for (int i=0; i<result.length; i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}