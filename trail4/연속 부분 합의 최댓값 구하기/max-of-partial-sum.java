import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        int[][] dp = new int[2][N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = numbers[0];
        dp[1][0] = numbers[0];

        for (int i = 1; i < N; i++) {
            dp[0][i] = Math.max(dp[0][i - 1] + numbers[i], numbers[i]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1]); 
        }

        System.out.print(Math.max(dp[0][N - 1], dp[1][N - 1]));
    }
}