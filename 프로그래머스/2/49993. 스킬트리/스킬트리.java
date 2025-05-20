import java.util.*;

class Solution {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        
        for (int i=0; i<skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        
        for (String ns : skill_trees) {
            int order = 0;
            boolean valid = true;
            for (int i=0; i<ns.length(); i++) {
                char word = ns.charAt(i);
                if (map.containsKey(word)) {
                    if (map.get(word) != order) {
                        valid = false;
                        break;
                    }
                    order++;
                }
            }
            
            if (valid) answer++;
        }
        
        return answer;
    }
}