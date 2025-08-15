import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static String N;
    private static long normalize = 1_000_000;
    private static long[] dp = new long[5001];

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
    }

    private static void process() {
        if (N.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        
        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<=N.length(); i++) {
            int first = Integer.parseInt(N.substring(i-1, i)), second = Integer.parseInt(N.substring(i-2, i));

            if (first > 0 && first < 10) dp[i] = (dp[i] + dp[i - 1]) % normalize;
            if (second > 9 && second < 27) dp[i] = (dp[i] + dp[i - 2]) % normalize;
        }

        System.out.println(dp[N.length()]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
