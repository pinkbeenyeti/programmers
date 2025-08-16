import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static long[][] dp = new long[2][91];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
    }

    private static void process() {
        dp[0][1] = 0;
        dp[1][1] = 1;
        dp[0][2] = 1;
        dp[1][2] = 0;
        dp[0][3] = 1;
        dp[1][3] = 1;

        for (int i=4; i<=N; i++) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[1][i] = dp[0][i - 1];
        }

        System.out.println(dp[0][N] + dp[1][N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
