import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];
        int[] dp = new int[N];

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            dp[i] = numbers[i];
        }

        for (int i=1; i<N; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
        }

        for (int i=0; i<N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.print(max);
    }
}
