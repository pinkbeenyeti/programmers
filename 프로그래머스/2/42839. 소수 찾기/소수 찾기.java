import java.util.*;

class Solution {
    int answer = 0;
    Set<Integer> set = new HashSet<>();
    
    private boolean isNumber(int n) {
        if (n == 0 || n == 1) return false;
        else if (n == 2) return true;
        
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n%i == 0) return false;
        }
        
        return true;
    }
    
    private void makeNumbers(String current, String numbers, boolean[] visited, int depth) {
        if (current.length() == depth) {
            set.add(Integer.parseInt(current));
            return;
        }
        
        for (int i=0; i<numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNumbers(current + numbers.charAt(i), numbers, visited, depth);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        
        for (int i=1; i<=numbers.length(); i++) {
            makeNumbers("", numbers, visited, i);
        }
        
        for (int number : set) {
            if (isNumber(number)) answer++;
        }
        
        return answer;
    }
}