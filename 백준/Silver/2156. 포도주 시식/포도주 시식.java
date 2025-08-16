import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] userInputs = new int[10_001];
    private static int[] dp = new int[10_001];

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
        dp[1] = userInputs[1];
        dp[2] = userInputs[2] + userInputs[1];

        for (int i=3; i<=N; i++) {
            int case1 = dp[i - 1];
            int case2 = dp[i - 2] + userInputs[i];
            int case3 = dp[i - 3] + userInputs[i - 1] + userInputs[i];

            dp[i] = Math.max(case1, Math.max(case2, case3));
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

}
