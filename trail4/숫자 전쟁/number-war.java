import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] player1 = new int[N];
        int[] player2 = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) player1[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) player2[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][N + 1];
        for (int[] array : dp) Arrays.fill(array, -1);
        dp[0][0] = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (dp[i][j] == -1) continue;
                if (i == N || j == N) {
                    answer = Math.max(answer, dp[i][j]);
                    continue;
                }

                if (player1[i] > player2[j]) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + player2[j]);
                }

                if (player1[i] < player2[j]) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                }

                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
            }
        }

        System.out.print(answer);
    }
}