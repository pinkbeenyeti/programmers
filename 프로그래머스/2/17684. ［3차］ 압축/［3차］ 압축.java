import java.util.*;

class Solution {
    
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        for (char ch='A'; ch<='Z'; ch++) dict.put(String.valueOf(ch), ch - 'A' + 1);
        
        
        StringBuilder w = new StringBuilder();
        int index = 27, position = 0;
        
        while (position < msg.length()) {
            w.append(msg.charAt(position));
            int nextPosition = position + 1;
            
            while (dict.containsKey(w.toString())) {
                if (nextPosition == msg.length()) break;
                
                w.append(msg.charAt(nextPosition));
                nextPosition++;
            }
            
            if (!dict.containsKey(w.toString())) {
                w.setLength(w.length() - 1);
            }
            
            answer.add(dict.get(w.toString()));
            
            if (position + w.length() < msg.length()) {
                String newEntry = w.toString() + msg.charAt(position + w.length());
                dict.put(newEntry, index++);
            }

            position += w.length();
            w.setLength(0);
        }
        
        int[] numbers = new int[answer.size()];
        for (int i=0; i<answer.size(); i++) numbers[i] = answer.get(i);
        
        return numbers;
    }
}