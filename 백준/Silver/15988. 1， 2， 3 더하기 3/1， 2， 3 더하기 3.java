import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static long[] dp = new long[1_000_001];
    static Queue<Integer> userInput = new LinkedList<>();

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            userInput.offer(Integer.parseInt(st.nextToken()));
        }
    }

    private static void process() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i=4; i<1_000_001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
        }

        while (!userInput.isEmpty()) {
            System.out.println(dp[userInput.poll()]);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
