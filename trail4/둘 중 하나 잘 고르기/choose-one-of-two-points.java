import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] red = new int[N * 2 + 1];
        int[] blue = new int[N * 2 + 1];

        for (int i = 1; i <= (N * 2); i++) {
            st = new StringTokenizer(br.readLine());

            red[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken()); 
        }

        int[][][] dp = new int[N * 2 + 1][N + 1][N + 1];
        dp[1][1][0] = red[1];
        dp[1][0][1] = blue[1];

        for (int i = 2; i <= (N * 2); i++) {
            for (int r = 0; r <= N; r++) {
                for (int b = 0; b <= N; b++) {
                    if (dp[i - 1][r][b] == 0) continue;
                    else {
                        if (r < N) dp[i][r + 1][b] = Math.max(dp[i][r + 1][b], dp[i - 1][r][b] + red[i]);
                        if (b < N) dp[i][r][b + 1] = Math.max(dp[i][r][b + 1], dp[i - 1][r][b] + blue[i]);
                    }
                }
            }
        }

        System.out.print(dp[N * 2][N][N]);
    }
}