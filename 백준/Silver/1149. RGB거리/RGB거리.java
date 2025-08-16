import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] costs = new int[1001][3];
    private static int[][] dp = new int[1001][3];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        dp[1][0] = costs[1][0];
        dp[1][1] = costs[1][1];
        dp[1][2] = costs[1][2];

        for (int i=2; i<=N; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
