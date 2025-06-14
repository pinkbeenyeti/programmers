import java.util.*;

class Solution {
    private List<Integer> candBit = new ArrayList<>();
    private int rowLength = 0;
    private int result = 0;
    
    public int solution(String[][] relation) {
        Set<String> data = new HashSet<>();
        rowLength = relation[0].length;
        
        StringBuilder candKey = new StringBuilder();
        for (int bit=1; bit<Math.pow(2, rowLength); bit++) {
            data.clear();
            
            for (String[] row : relation) {
                candKey.setLength(0);
                
                for (int i=0; i<rowLength; i++) {
                    if ((bit & (1 << i)) != 0) candKey.append(row[i]);
                }
                
                data.add(candKey.toString());
            }
            
            if (data.size() != relation.length) continue;
            
            boolean isMin = true;
            for (int prevBit : candBit) {
                if ((bit & prevBit) == prevBit) {
                    isMin = false;
                    break;
                }
            }
            
            if (isMin) {
                candBit.add(bit);
                result++;
            }
        }
        
        return result;
    }
}