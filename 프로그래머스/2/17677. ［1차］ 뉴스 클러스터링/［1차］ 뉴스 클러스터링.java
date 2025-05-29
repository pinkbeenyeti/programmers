import java.util.*;

class Solution {
    private boolean isValid(String str) {
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') continue;
            
            return false;
        }
        
        return true;
    }
    
    private void fillMap(HashMap<String, Integer> aggr, String str) {
        for (int i=0; i<str.length()-1; i++) {
            String st = str.substring(i, i+2).toUpperCase();
            if (!isValid(st)) continue;
            if (!aggr.containsKey(st)) {
                aggr.put(st, 1);
                continue;
            }
            aggr.replace(st, aggr.get(st)+1);
        }
    }
    
    public int solution(String str1, String str2) {
        HashMap<String, Integer> aggr1 = new HashMap<>();
        HashMap<String, Integer> aggr2 = new HashMap<>();
        fillMap(aggr1, str1);
        fillMap(aggr2, str2);
        
        double mis = 0, mu = 0;
        for (String key : aggr1.keySet()) {
            int val1 = aggr1.get(key);
            if (aggr1.containsKey(key) && aggr2.containsKey(key)) {
                int val2 = aggr2.get(key);
                mis += Math.min(val1, val2);
                mu += Math.max(val1, val2);
                aggr2.remove(key);
                continue;
            }
            mu += val1;
        } 
        
        for (String key : aggr2.keySet()) {
            mu += aggr2.get(key);
        }

        if (mis == 0 && mu == 0) return 65536;
        return (int) (mis/mu*65536);
    }
}