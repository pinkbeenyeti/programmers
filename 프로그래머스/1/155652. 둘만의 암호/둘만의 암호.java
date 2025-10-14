import java.util.List;
import java.util.LinkedList;

import java.util.Set;
import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder stb = new StringBuilder();
        
        Set<Character> set = new HashSet<>();
        for (int i=0; i<skip.length(); i++) set.add(skip.charAt(i));
        
        for (int i=0; i<s.length(); i++) {
            List<Character> list = new LinkedList<>();
            char ch = (char) (s.charAt(i) + 1);
            
            while (list.size() < index) {
                if (ch > 'z') ch = (char) (ch - 'z' + 'a' - 1);
                if (!set.contains(ch)) list.add(ch);
                ch = (char) (ch + 1);
            }
            
            stb.append(list.get(index - 1));
        }
        
        return stb.toString();
    }
}