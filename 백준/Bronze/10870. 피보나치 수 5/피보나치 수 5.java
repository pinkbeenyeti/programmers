import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static int N;
    static int dp[] = new int[21];

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
    }

    static void process() {
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<21; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.print(dp[N]);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
