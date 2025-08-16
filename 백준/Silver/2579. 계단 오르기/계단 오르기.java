import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] userInputs = new int[301];
    private static int[][] dp = new int[301][301];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            userInputs[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        dp[1][0] = userInputs[1];
        dp[1][1] = userInputs[1];
        dp[2][0] = userInputs[2];
        dp[2][1] = userInputs[2] + userInputs[1];

        for (int i=3; i<=N; i++) {
            dp[i][0] = Math.max(dp[i-2][0] + userInputs[i], dp[i-2][1] + userInputs[i]);
            dp[i][1] = dp[i-1][0] + userInputs[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
