import java.util.*;

class Solution {
    private char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private Map<Character, Integer> map = new HashMap<>();
    private boolean[] visited = new boolean[8];
    private int answer = 0;

    
    private boolean isValid(String[] data) {
        for (String condition : data) {
            char index1 = condition.charAt(0), index2 = condition.charAt(2);
            int distance = Math.abs(map.get(index1) - map.get(index2)) - 1;
            int value = condition.charAt(4) - '0';
            
            if (condition.charAt(3) == '=') {
                if (distance != value) return false;
                continue;
            }
            
            if (condition.charAt(3) == '<') {
                if (distance >= value) return false;
                continue;
            }
            
            if (condition.charAt(3) == '>') {
                if (distance <= value) return false;
            }
        }
        
        return true;
    }
    
    private void dfs(int depth, String[] data) {
        if (depth == 8) {
            if (isValid(data)) answer++;
            return;
        }
        
        for (int i=0; i<8; i++) {
            if (visited[i]) continue;
            else {
                visited[i] = true;
                map.replace(friends[i], depth);
                dfs(depth + 1, data);
                
                visited[i] = false;
            }
        }
    }
    
    public int solution(int n, String[] data) {
        for (char ch : friends) map.put(ch, 0);
        dfs(0, data);
        return answer;
    }
}