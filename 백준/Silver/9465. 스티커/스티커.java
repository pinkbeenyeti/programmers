import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] stickers = new int[2][100_001];
    private static int[][] dp;

    private static void logic() {
        dp = new int[2][100_001];
        dp[0][1] = stickers[0][1];
        dp[1][1] = stickers[1][1];

        for (int i=2; i<=N; i++) {
            dp[0][i] = stickers[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
            dp[1][i] = stickers[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
        }

        System.out.println(Math.max(dp[0][N], dp[1][N]));
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                stickers[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                stickers[1][j] = Integer.parseInt(st.nextToken());
            }

            logic();
        }
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
