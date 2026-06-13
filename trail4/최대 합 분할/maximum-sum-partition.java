import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N = 0, S = 0;
    private static int[] numbers;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            S += numbers[i];
        }

        dp = new int[N + 1][2 * S + 1];
        for (int[] array : dp) Arrays.fill(array, -1);
        dp[0][S] = 0;

        for (int i = 1; i <= N; i++) {
            int target = numbers[i];

            for (int j = 0; j <= (2 * S); j++) {
                if (dp[i - 1][j] != -1) {
                    dp[i][j + target] = Math.max(dp[i][j + target], dp[i - 1][j] + target);
                    dp[i][j - target] = Math.max(dp[i][j - target], dp[i - 1][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
            }
        }

        if (dp[N][S] == -1) System.out.print(0);
        else System.out.println(dp[N][S]);
    }
}