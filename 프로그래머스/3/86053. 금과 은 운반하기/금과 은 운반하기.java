import java.lang.Math;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long start = 0, end = (long)1e15, answer = Long.MAX_VALUE;
        while(start <= end) {
            long mid = (start + end) / 2;
            long gold = 0, silver = 0, total = 0;

            for (int i=0; i<g.length; i++) {
                long move = mid / (t[i] * 2);
                if (mid % (t[i] * 2) >= t[i]) move++;

                long maxCarry = move * w[i];
                gold += Math.min(g[i], maxCarry);
                silver += Math.min(s[i], maxCarry);
                total += Math.min(g[i] + s[i], maxCarry);
            }

            if (gold >= a && silver >= b && total >= a + b) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}
