import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int cacheSize, String[] cities) {
        for (int i=0; i<cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }
        
        ArrayList<String> cache = new ArrayList<>();
        for (int i=0; i<cities.length; i++) {
            if (cacheSize == 0) {
                answer+=5;
                continue;
            }
            if (cache.contains(cities[i])) {
                cache.remove(cities[i]);
                cache.add(cities[i]);
                answer+=1;
                continue;
            }
            if (cache.size() == cacheSize) {
                cache.remove(0);
            }
            cache.add(cities[i]);
            answer+=5;
        }
        
        return answer;
    }
}