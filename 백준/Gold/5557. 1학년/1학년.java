import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int calculateResult;
    private static long[][] dp = new long[101][21];
    private static Queue<Integer> numbers = new LinkedList<>();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<N; i++) {
            numbers.offer(Integer.parseInt(st.nextToken()));
        }

        calculateResult = Integer.parseInt(st.nextToken());
    }

    private static void process() {
        dp[1][numbers.poll()] = 1;
        int row = 2;

        while (!numbers.isEmpty()) {
            int number = numbers.poll();

            for (int col=0; col<21; col++) {
                if (dp[row-1][col] != 0) {
                    int cal1 = col + number, cal2 = col - number;

                    if (cal1 >= 0 && cal1 <= 20) dp[row][cal1] += dp[row-1][col];
                    if (cal2 >= 0 && cal2 <= 20) dp[row][cal2] += dp[row-1][col];
                }
            }

            row++;
        }

        System.out.println(dp[N-1][calculateResult]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
