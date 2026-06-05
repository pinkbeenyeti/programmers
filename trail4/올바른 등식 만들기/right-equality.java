import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        long[][] dp = new long[N][41];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        dp[0][numbers[0] + 20] += 1;
        dp[0][-numbers[0] + 20] += 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 40; j++) {
                if (dp[i - 1][j] > 0){
                    int a = j + numbers[i];
                    int b = j - numbers[i];

                    if (a <= 40 && a >= 0) dp[i][a] += dp[i - 1][j];
                    if (b <= 40 && b >= 0) dp[i][b] += dp[i - 1][j];
                } 
            }
        }

        System.out.print(dp[N - 1][M + 20]);
    }
}