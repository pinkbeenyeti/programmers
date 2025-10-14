import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        Pattern accentable = Pattern.compile("aya|ye|woo|ma");
        Pattern accentless = Pattern.compile("ayaaya|yeye|woowoo|mama");
        
        for (String babble : babbling) {
            int length = 0;
            
            Matcher accentMatch = accentable.matcher(babble);
            Matcher accentlessMatch = accentless.matcher(babble);
            
            if (accentlessMatch.find()) continue;
            while (accentMatch.find()) length += accentMatch.group().length();
            if (length == babble.length()) answer++;
        }
        
        return answer;
    }
}