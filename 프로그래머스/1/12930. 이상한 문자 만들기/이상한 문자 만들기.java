class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int wordIndex = 0; 
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(" ");
                wordIndex = 0;
            } else {
                if (wordIndex % 2 == 0) {
                    answer.append(Character.toUpperCase(c));
                } else {
                    answer.append(Character.toLowerCase(c));
                }
                
                wordIndex++;
            }
        }
        
        return answer.toString();
    }
}