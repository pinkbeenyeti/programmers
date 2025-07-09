class Solution {
    public int[] solution(String s) {
        int trans = 0, zero = 0;
        
        while (s.length() > 1) {
            int length = s.length();
            s = s.replace("0", "");
            if (length != s.length()) zero += (length - s.length());
            s = Integer.toBinaryString(s.length());
            trans++;
        }
        
        int[] answer = new int[]{trans, zero};
        return answer;
    }
}