import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    static Queue<Integer> userInputs = new LinkedList<>();
    static long[][] dp = new long[65][11];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            userInputs.offer(Integer.parseInt(st.nextToken()));
        }
    }

    private static void process() {
        for (int i=0; i<10; i++) {
            dp[1][i] = 1;
            dp[2][i] = i + 1;
        }

        for (int row=3; row<65; row++) {
            for (int col=0; col<10; col++) {
                if (col == 0) dp[row][col] = 1;
                else dp[row][col] = dp[row][col - 1] + dp[row - 1][col];
            }
        }

        for (int row=1; row<65; row++) {
            long sum = 0;

            for (int col=0; col<10; col++) {
                sum += dp[row][col];
            }

            dp[row][10] = sum;
        }

        while (!userInputs.isEmpty()) {
            int N = userInputs.poll();
            System.out.println(dp[N][10]);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
