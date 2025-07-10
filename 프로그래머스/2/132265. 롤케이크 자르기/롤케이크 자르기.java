import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> me = new HashMap<>();
        Map<Integer, Integer> friend = new HashMap<>();
        for (int topp : topping) friend.put(topp, friend.getOrDefault(topp, 0) + 1);
        
        for (int topp : topping) {
            me.put(topp, me.getOrDefault(topp, 1) + 1);
            
            if (friend.get(topp) == 1) friend.remove(topp);
            else friend.replace(topp, friend.get(topp) - 1);
            
            if (me.size() == friend.size()) answer++;
        }
        
        return answer;
    }
}