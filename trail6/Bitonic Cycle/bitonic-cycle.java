import java.io.*;
import java.util.*;

public class Main {

    private static int[][] dots;
    private static long[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        dots = new int[N][2];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dots[i][0] = x;
            dots[i][1] = y;
        }

        Arrays.sort(dots, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < N; i++) Arrays.fill(dp[i], Long.MAX_VALUE);
        dp[0][0] = 0;

        for (int front = 0; front < (N - 1); front++) {
            int next = front + 1;

            for (int back = 0; back <= front; back++) {
                if (dp[front][back] == Long.MAX_VALUE) continue; 
                dp[next][back] = Math.min(dp[next][back], dp[front][back] + dist(front, next));
                dp[next][front] = Math.min(dp[next][front], dp[front][back] + dist(back, next));
            }
        }

        long answer = Long.MAX_VALUE;

        for (int i = 0; i < (N - 1); i++) {
            if (dp[N - 1][i] != Long.MAX_VALUE) {
                answer = Math.min(answer, dp[N - 1][i] + dist(N - 1, i));
            }
        }

        System.out.print(answer);
    }

    // 두 점 사이의 거리를 long 타입으로 변환하여 제곱합 연산
    private static long dist(int a, int b) {
        long dx = dots[a][0] - dots[b][0];
        long dy = dots[a][1] - dots[b][1];
        return dx * dx + dy * dy;
    }
}
