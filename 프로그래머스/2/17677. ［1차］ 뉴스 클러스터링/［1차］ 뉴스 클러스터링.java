import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String str1, String str2) {
        int mul = 0, plus = 0;
        
        Pattern pattern = Pattern.compile("[a-z]{2}");
        
        Matcher str1Matcher = pattern.matcher(str1.toLowerCase());
        Matcher str2Matcher = pattern.matcher(str2.toLowerCase());
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (int i=0; i<str1.length() - 1; i++) {
            if (str1Matcher.find(i) && str1Matcher.start() == i) {
                String splited = str1Matcher.group();
                map1.put(splited, map1.getOrDefault(splited, 0) + 1);
            }
        }
        
        
        for (int i=0; i<str2.length() - 1; i++) {
            if (str2Matcher.find(i) && str2Matcher.start() == i) {
                String splited = str2Matcher.group();
                map2.put(splited, map2.getOrDefault(splited, 0) + 1);
            }
        }
        
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                mul += Math.min(map1.get(key), map2.get(key));
                plus += Math.max(map1.get(key), map2.get(key));
                
                map2.remove(key);
            } else {
                plus += map1.get(key);
            }
        }
        
        for (String key : map2.keySet()) {
            plus += map2.get(key);
        }
        
        if (plus == 0) return 65536;
        else return (int) ((double) mul / plus * 65536);
    }
}