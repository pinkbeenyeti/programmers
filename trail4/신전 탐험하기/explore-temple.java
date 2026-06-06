import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[][] gems = new int[N][3]; 
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            gems[i][0] = l;
            gems[i][1] = m;
            gems[i][2] = r;

            dp[i][0] = l;
            dp[i][1] = m;
            dp[i][2] = r;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < 3; j++) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][(0 + j) % 3] + gems[i][0]);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][(1 + j) % 3] + gems[i][1]);
                dp[i][2] = Math.max(dp[i][2], dp[i - 1][(2 + j) % 3] + gems[i][2]);
            }
        }

        for (int i = 0; i < 3; i++) {
            answer = Math.max(answer, dp[N - 1][i]);
        }

        System.out.print(answer);
    }
}