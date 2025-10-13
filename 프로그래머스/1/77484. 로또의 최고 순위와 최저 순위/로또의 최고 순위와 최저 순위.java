import java.util.Set;
import java.util.HashSet;

class Solution {
    private int[] ranks = {6, 6, 5, 4, 3, 2, 1};
    private int zero = 0;
    
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> lottoSet = new HashSet<>();
        Set<Integer> winSet = new HashSet<>();
        
        for (int num : lottos) {
            if (num == 0) zero++;
            lottoSet.add(num);
        }
        
        for (int num : win_nums) {
            winSet.add(num);
        }
        
        lottoSet.retainAll(winSet);
        
        int min = lottoSet.size(), max = (lottoSet.size() + zero >= 6) ? 6 : lottoSet.size() + zero;
        return new int[]{ranks[max], ranks[min]};
    }
}