import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = Integer.MIN_VALUE;

        int[][] values = new int[N + 1][N + 1];
        int[][] preSums = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= N; c++) {
                values[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                preSums[r][c] = preSums[r - 1][c] + values[r][c];
            }
        }

        for (int r1 = 1; r1 <= N; r1++) {
            for (int r2 = r1; r2 <= N; r2++) {
                int currentSum = 0;

                for (int c = 1; c <= N; c++) {
                    int val = preSums[r2][c] - preSums[r1 - 1][c];
                    currentSum = Math.max(val, currentSum + val);
                    answer = Math.max(answer, currentSum);
                } 
            }
        }

        System.out.print(answer);
    }
}