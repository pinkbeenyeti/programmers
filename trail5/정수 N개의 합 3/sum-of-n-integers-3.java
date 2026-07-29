import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[][] nums = new int[N + 1][N + 1];
        int[][] sums = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= N; c++) {
                nums[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                sums[r][c] = sums[r - 1][c] + sums[r][c - 1] - sums[r - 1][c - 1] + nums[r][c];
            }
        }

        for (int r = K; r <= N; r++) {
            for (int c = K; c <= N; c++) {
                answer = Math.max(answer, sums[r][c] - sums[r - K][c] - sums[r][c - K] + sums[r - K][c - K]);
            }
        }

        System.out.print(answer);
    }
}