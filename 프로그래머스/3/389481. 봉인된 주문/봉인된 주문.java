import java.util.*;

class Solution {
    private long stringToNumber(String ban) {
        long result = 0;
        
        for (int i=(ban.length() - 1); i>=0; i--) {
            result += ((long) Math.pow(26, ban.length() - 1 - i)) * (ban.charAt(i) - 'a' + 1);
        }
        
        return result;
    }
    
    private String numberToString(long number) {
        StringBuilder result = new StringBuilder();
        
        while (number > 0) {
            number--;
            result.append((char) ('a' + (number % 26)));
            number /= 26;
        }
        
        return result.reverse().toString();
    }
    
    public String solution(long n, String[] bans) {
        Set<Long> higherBanned = new HashSet<>();
        long nowOrder = n, realOrder = n;
        
        for (String ban : bans) {
            long transNumber = stringToNumber(ban);
            
            if (transNumber < n) nowOrder--;
            else higherBanned.add(transNumber);
        }
        
        while (nowOrder <= n) {
            if (!higherBanned.contains(realOrder)) {
                nowOrder++;
            }
            
            realOrder++;
        }
        
        return numberToString(realOrder - 1);
    }
}