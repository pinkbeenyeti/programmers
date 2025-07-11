import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder result = new StringBuilder();
        StringBuilder term = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ' ') {
                if (term.length() == 0 && (ch < '0' || ch > '9')) {
                    ch = (char)(ch - ('a' - 'A'));
                }
                term.append(ch);
            } else {
                result.append(term).append(" ");
                term.setLength(0);
            }
        }

        result.append(term);

        return result.toString();
    }
}
