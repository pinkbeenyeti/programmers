import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;

    private static int[] foods;
    private static long[] dp;
    private static List<Interval>[] intervals;

    private static class Interval {
        int left;
        long satisfy;

        public Interval(int left, long satisfy) {
            this.left = left;
            this.satisfy = satisfy;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        foods = new int[N + 1];
        dp = new long[N + 1];
        intervals = new List[N + 1];

        for (int i=1; i<=N; i++) {
            intervals[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            foods[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        long sum = 0;

        for (int L=1, R=L; L<=N; L++) {
            while (sum < K && R <= N) sum += foods[R++];
            if (sum >= K) {
                intervals[R - 1].add(new Interval(L, sum - K));
            }
            
            sum -= foods[L];
        }

        for (int R=1; R<=N; R++) {
            dp[R] = dp[R - 1];

            for (Interval interval : intervals[R]) {
                dp[R] = Math.max(dp[R], dp[interval.left - 1] + interval.satisfy);
            }

        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
