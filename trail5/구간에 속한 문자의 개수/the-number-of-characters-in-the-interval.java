import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        int[][][] sums = new int[3][N + 1][M + 1];

        for (int r = 1; r <= N; r++) {
            String target = br.readLine();

            for (int c = 1; c <= M; c++) {
                map[r][c] = target.charAt(c - 1) - 'a';
            }
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                for (int i = 0; i < 3; i++) {
                    if (map[r][c] == i) sums[i][r][c]++;
                    sums[i][r][c] += sums[i][r - 1][c] + sums[i][r][c - 1] - sums[i][r - 1][c - 1];
                }
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 3; j++) {
                answer.append(sums[j][er][ec] - sums[j][er][sc -1] - sums[j][sr - 1][ec] + sums[j][sr - 1][sc - 1]);
                answer.append(" ");
            }
            
            answer.append("\n");
        }

        System.out.print(answer);
    }
}