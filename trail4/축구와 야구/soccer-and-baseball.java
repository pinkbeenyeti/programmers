import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;

    private static int[][] abt;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        abt = new int[N][2];
        dp = new int[12][10];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            abt[i][0] = s;
            abt[i][1] = b;
        }

        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }

        dp[0][0] = 0;
        dp[1][0] = abt[0][0];
        dp[0][1] = abt[0][1];

        for (int i = 1; i < N; i++) {
            for (int s = 11; s >= 0; s--) {
                for (int b = 9; b >= 0; b--) {
                    if (dp[s][b] != -1) {
                        if (s < 11) dp[s + 1][b] = Math.max(dp[s + 1][b], dp[s][b] + abt[i][0]);
                        if (b < 9) dp[s][b + 1] = Math.max(dp[s][b + 1], dp[s][b] + abt[i][1]);
                    }
                }
            }
        }

       System.out.print(dp[11][9]);
    }
}