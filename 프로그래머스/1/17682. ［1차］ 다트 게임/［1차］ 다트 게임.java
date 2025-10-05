import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[4];
        int turn = 1;
        
        Pattern pattern = Pattern.compile("([0-9]*)([A-Z])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);
        
        while (matcher.find()) {
            int score = Integer.parseInt(matcher.group(1));
            String bonus = matcher.group(2), option = matcher.group(3);
            
            if (bonus.equals("D")) {
                score = (int) Math.pow(score, 2);
            } else if (bonus.equals("T")) {
                score = (int) Math.pow(score, 3);
            }
            
            if (!option.isEmpty()) {
                if (option.equals("*")) {
                    score *= 2;
                    scores[turn - 1] *= 2;
                } else if (option.equals("#")) {
                    score *= -1;
                }
            }
            
            scores[turn] = score;
            turn++;
        }
        
        return scores[1] + scores[2] + scores[3];
    }
}