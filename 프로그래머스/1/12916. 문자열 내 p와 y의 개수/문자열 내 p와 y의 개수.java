import java.util.Arrays;

class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        String[] array = s.split("");
        
        long p = Arrays.stream(array).filter(a -> a.equals("p")).count();
        long y = Arrays.stream(array).filter(a -> a.equals("y")).count();
        
        return p == y;
    }
}