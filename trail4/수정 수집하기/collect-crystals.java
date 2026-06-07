import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, K;
    private static int answer = 0;

    private static int[] gems;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String string;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        string = br.readLine();

        gems = new int[N];
        dp = new int[N][K + 2][2];

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'L') gems[i] = 0;
            else gems[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= (K + 1); j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        dp[0][0][0] = 1 - gems[0];
        dp[0][1][1] = gems[0];

        for (int i = 1; i < N; i++) {
            int pos = gems[i];

            for (int j = 0; j <= K; j++) {
                if (dp[i - 1][j][0] != -1) {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][0] + (1 - gems[i]));
                    dp[i][j + 1][1] = Math.max(dp[i][j + 1][1], dp[i - 1][j][0] + gems[i]);
                }

                if (dp[i - 1][j][1] != -1) {
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j][1] + gems[i]);
                    dp[i][j + 1][0] = Math.max(dp[i][j + 1][0], dp[i - 1][j][1] + (1 - gems[i]));
                }
            }
        }

        for (int i = 0; i <= K; i++) {
            answer = Math.max(answer, Math.max(dp[N - 1][i][0], dp[N - 1][i][1]));
        }

        System.out.print(answer);
    }
}