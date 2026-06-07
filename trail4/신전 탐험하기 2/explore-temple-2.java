import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int answer = 0;

    private static int[][] gems;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        gems = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            gems[i][0] = Integer.parseInt(st.nextToken());
            gems[i][1] = Integer.parseInt(st.nextToken());
            gems[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = gems[0][0];
        dp[1][1] = gems[1][1] + dp[0][0];
        dp[1][2] = gems[1][2] + dp[0][0];

        up(0);

        dp = new int[N][3];
        dp[0][1] = gems[0][1];
        dp[1][0] = gems[1][0] + dp[0][1];
        dp[1][2] = gems[1][2] + dp[0][1];

        up(1);

        dp = new int[N][3];
        dp[0][2] = gems[0][2];
        dp[1][0] = gems[1][0] + dp[0][2];
        dp[1][1] = gems[1][1] + dp[0][2];

        up(2);

        System.out.print(answer);
    }

    private static void up(int exclude) {
        for (int i = 2; i < N; i++) {
            if (dp[i - 1][0] != 0) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + gems[i][1]);
                dp[i][2] = Math.max(dp[i][2], dp[i - 1][0] + gems[i][2]);
            }

            if (dp[i - 1][1] != 0) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + gems[i][0]);
                dp[i][2] = Math.max(dp[i][2], dp[i - 1][1] + gems[i][2]);
            }

            if (dp[i - 1][2] != 0) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][2] + gems[i][0]);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][2] + gems[i][1]);
            }
        }

        for (int i = 1; i <= 2; i++) {
            answer = Math.max(answer, dp[N - 1][(exclude + i) % 3]);
        }
    }
}