import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static int N, S, M;
    private static int[] volumes = new int[51];
    private static boolean[][] dp = new boolean[51][1001];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) volumes[i] = Integer.parseInt(st.nextToken());
    }

    private static void process() {
        dp[0][S] = true;
        int answer = -1;

        for (int row=1; row<=N; row++) {
            for (int col=0; col<=M; col++) {
                if (dp[row-1][col]) {
                    int volume1 = col + volumes[row], volume2 = col - volumes[row];
                    if (volume1 >= 0 && volume1 <= M) dp[row][volume1] = true;
                    if (volume2 >= 0 && volume2 <= M) dp[row][volume2] = true;
                }
            }
        }

        for (int col=0; col<=M; col++) {
            if (dp[N][col]) answer = col;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
