import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static int T;
    private static int[] cases;
    private static long[][] dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        cases = new int[T+1];
        dp = new long[11][5];

        for (int i=1; i<=T; i++) {
            st = new StringTokenizer(br.readLine());
            cases[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        dp[1][1] = 1;
        dp[1][4] = 1;

        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][4] = 2;

        dp[3][1] = 2;
        dp[3][2] = 1;
        dp[3][3] = 1;
        dp[3][4] = 4;

        for (int row=4; row<=10; row++) {
            long sum = 0;

            for (int col=1; col<=3; col++) {
                dp[row][col] = dp[row - col][4];
                sum += dp[row][col];
            }

            dp[row][4] = sum;
        }

        for (int i=1; i<=T; i++) {
            System.out.println(dp[cases[i]][4]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
