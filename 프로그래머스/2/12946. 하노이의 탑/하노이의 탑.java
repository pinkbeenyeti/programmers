import java.util.*;

class Solution {
    List<int[]> result;

    public int[][] solution(int n) {
        result = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        
        return result.stream().toArray(int[][]::new);
    }

    private void hanoi(int n, int from, int to, int via) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, via, to);
        result.add(new int[]{from, to});
        hanoi(n - 1, via, to, from);
    }
}