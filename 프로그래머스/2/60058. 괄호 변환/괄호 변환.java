import java.util.*;

class Solution {
    StringBuilder answer = new StringBuilder();
    
    private void firstStep(String np) {
        if (np.isEmpty()) return;
        
        if (np.charAt(0) == '(') correctU(np); else inCorrectU(np);
    }
    
    private void correctU(String np) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int openCount = 0, closeCount = 0, index = 0;
        
        while (true) {
            char ptr = np.charAt(index);
            
            if (ptr == '(') openCount++; else closeCount++;
            u.append(ptr);
            index++;
            
            if (openCount == closeCount) {
                v.append(np.substring(index, np.length()));
                break;
            }
        }
        
        answer.append(u.toString());
        firstStep(v.toString());
    }
    
    private void inCorrectU(String np) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int openCount = 0, closeCount = 0, index = 0;
        
        while (true) {
            char ptr = np.charAt(index);
            
            if (ptr == '(') openCount++; else closeCount++;
            u.append(ptr == '(' ? ')' : '(');
            index++;
            
            if (openCount == closeCount) {
                v.append(np.substring(index, np.length()));
                break;
            }
        }
        
        answer.append('(');
        firstStep(v.toString());
        answer.append(')');
        u.delete(u.length()-1, u.length()).delete(0, 1);
        answer.append(u.toString());
    }
    
    public String solution(String p) {
        firstStep(p);
        
        return answer.toString();
    }
}