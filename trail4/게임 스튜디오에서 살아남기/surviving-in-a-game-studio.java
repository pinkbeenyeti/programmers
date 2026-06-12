import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

    private static int N, NORMAL, ANSWER = 0;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        NORMAL = (int) Math.pow(10, 9) + 7;

        dp = new int[N + 1][3][3];
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int b = 0; b < 3; b++) {
                for (int t = 0; t < 3; t++) {
                    dp[i][0][t] = (dp[i][0][t] + dp[i - 1][b][t]) % NORMAL;
                }
            }

            for (int b = 0; b < 2; b++) {
                for (int t = 0; t < 3; t++) {
                    dp[i][b + 1][t] = (dp[i][b + 1][t] + dp[i - 1][b][t]) % NORMAL;
                }
            }

            for (int b = 0; b < 3; b++) {
                for (int t = 0; t < 2; t++) {
                    dp[i][0][t + 1] = (dp[i][0][t + 1] + dp[i - 1][b][t]) % NORMAL;
                }
            }
        }

        for (int b = 0; b < 3; b++) {
            for (int t = 0; t < 3; t++) {
                ANSWER = (ANSWER + dp[N][b][t]) % NORMAL;
            }
        }

        System.out.print(ANSWER);
    }
}