import java.util.ArrayList;
import java.lang.Math;

class Solution {
    ArrayList<Integer> positions;
    
    public int hailSequence(int k) {
        int n = 0;
        while(k != 1) {
            positions.add(k);
            n++;
            if (k%2 == 0) {
                k = k/2;
                
            } else {
                k = k*3 + 1;
            }
        }
        
        positions.add(k);
        
        return n;
    }
    
    public double[] solution(int k, int[][] ranges) {
        positions = new ArrayList<>();
        int n = hailSequence(k);
        
        ArrayList<Double> regions = new ArrayList<>();
        for (int[] range : ranges) {
            int a = range[0], b = n - Math.abs(range[1]);
            if (a > b) {
                regions.add(-1.0);
            } else {
                double sum = 0;
                for (int i=a; i<b; i++) {
                    sum += (positions.get(i) + positions.get(i+1)) / 2.0;
                }
                
                regions.add(sum);
            }
        }
        
        double answer[] = new double[regions.size()];
        for(int i=0; i<regions.size(); i++) {
            answer[i] = regions.get(i);
        }
        
        return answer;
    }
}