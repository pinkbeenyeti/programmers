import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int Norm = (int) Math.pow(10, 9) + 7;
        int Answer = 0;

        int[][] dp = new int[N + 1][10];
        for (int i = 1; i < 10; i++) dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j - 1 >= 0) dp[i][j] = ((dp[i][j] % Norm) + (dp[i - 1][j - 1] % Norm)) % Norm;
                if (j + 1 < 10) dp[i][j] = ((dp[i][j] % Norm) + (dp[i - 1][j + 1] % Norm)) % Norm;
            }
        }

        for (int i = 0; i < 10; i++) {
            Answer = ((Answer % Norm) + (dp[N][i]) % Norm) % Norm;
        }

        System.out.print(Answer);
    }
}