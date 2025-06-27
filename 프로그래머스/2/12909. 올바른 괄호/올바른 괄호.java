class Solution {
    boolean solution(String s) {
        String[] splited = s.split("");
        
        int open = 0, close = 0;
        for (String oc : splited) {
            if (oc.equals("(")) open++;
            else close++;
            
            if (close > open) return false;
        }
        
        if (open != close) return false;
        else return true;
    }
}