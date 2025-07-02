import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1])) {
                List<String> list = map.get(cloth[1]);
                list.add(cloth[0]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(cloth[0]);
                map.put(cloth[1], list);
            }
        }
        
        int answer = 1;
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            answer *= (list.size() + 1);
        }
        
        return answer - 1;
    }
}