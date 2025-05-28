import java.lang.Math;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        char[] bonus = new char[3];
        char[] option = {' ', ' ', ' '};
        
        int index = 0, pointer = 0;
        for (int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                scores[index] = Integer.parseInt(dartResult.substring(pointer, i));
                bonus[index] = c;
                index++;
                pointer = i+1;
                continue;
            }
            if (c == '*' || c == '#') {
                option[index-1] = c;
                pointer = i+1;
            }
        }
        
        for (int i=0; i<3; i++) {
            if (bonus[i] == 'D') scores[i] = (int) Math.pow(scores[i], 2);
            if (bonus[i] == 'T') scores[i] = (int) Math.pow(scores[i], 3);
            if (option[i] == '*') {
                if (i != 0) scores[i-1] = scores[i-1] * 2;
                scores[i] = scores[i] * 2;
            }
            if (option[i] == '#') scores[i] = -scores[i];
        }
        
        int result = 0;
        for (int i=0; i<3; i++) {
            result += scores[i];
        }
        
        return result;
    }
}