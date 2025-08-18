import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int normalize = 1_000_000_000;
    private static long[][][] dp = new long[101][10][1024];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
    }

    private static void fillDp0(int row, int bit) {
        if (dp[row - 1][1][bit] > 0) {
            dp[row][0][bit | 1] = (dp[row][0][bit | 1] + dp[row - 1][1][bit]) % normalize;
        }
    }

    private static void fillDp9(int row, int bit) {
        if (dp[row - 1][8][bit] > 0) {
            dp[row][9][bit | (1 << 9)] = (dp[row][9][bit | (1 << 9)] + dp[row - 1][8][bit]) % normalize;
        }
    }

    private static void fillDpElse(int row, int col, int bit) {
        if (dp[row - 1][col - 1][bit] > 0) {
            dp[row][col][bit | (1 << col)] = (dp[row][col][bit | (1 << col)] + dp[row - 1][col - 1][bit]) % normalize;
        }

        if (dp[row - 1][col + 1][bit] > 0) {
            dp[row][col][bit | (1 << col)] = (dp[row][col][bit | (1 << col)] + dp[row - 1][col + 1][bit]) % normalize;
        }
    }

    private static void process() {
        long answer = 0;

        for (int col=1; col<10; col++) {
            dp[1][col][1<<col] = 1;
        }

        for (int row=2; row<=100; row++) {
            for (int col=0; col<10; col++) {
                for (int bit=1; bit<1024; bit++) {
                    if (col == 0) fillDp0(row, bit);
                    else if (col == 9) fillDp9(row, bit);
                    else fillDpElse(row, col, bit);
                }
            }
        }

        for (int col=0; col<10; col++) {
            answer = (answer + dp[N][col][1023]) % normalize;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
