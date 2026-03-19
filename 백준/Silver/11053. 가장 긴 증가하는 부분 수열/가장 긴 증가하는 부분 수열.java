import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int maxLength = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];
        int[] dp = new int[N];

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=(N - 1); i>=0; i--) {

            dp[i] = 1;

            for (int j=(i + 1); j<N; j++) {
                if (numbers[i] < numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        for (int i=0; i<N; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.print(maxLength);
    }
}
