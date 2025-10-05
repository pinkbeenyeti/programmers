import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) return false;
        
        Pattern pattern = Pattern.compile("^[0-9]*");
        Matcher matcher = pattern.matcher(s);
        
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}