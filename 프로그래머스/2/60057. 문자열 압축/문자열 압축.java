class Solution {
    private String splitString(String s, int unit) {
        int count = 1;
        String previous = s.substring(0, unit), nowUnit = "";
        StringBuilder splited = new StringBuilder();
        
        for (int i=unit; i<s.length(); i+=unit) {
            nowUnit = s.substring(i, ((i+unit > s.length()) ? s.length() : i+unit));
            if (nowUnit.equals(previous)) {
                count++;
            } else {
                if (count == 1) {
                    splited.append(previous);
                } else {
                    splited.append(count).append(previous);
                    count = 1;
                }
                
                previous = nowUnit;
            }
        }
        
        if (count != 1) splited.append(count);
        return splited.append(nowUnit).toString();
    }
    
    public int solution(String s) {
        int answer = s.length();
        
        for (int i=1; i<=s.length()/2; i++) {
            String splited = splitString(s, i);
            answer = Math.min(answer, splited.length());
        }
        
        return answer;
    }
}