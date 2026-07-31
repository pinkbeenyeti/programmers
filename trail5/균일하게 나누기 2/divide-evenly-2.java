import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 2000;

        boolean[][] map = new boolean[1001][1001];
        int[][] sums = new int[1001][1001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = true;
        }

        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y <= 1000; y++) {
                sums[x][y] = sums[x - 1][y] + sums[x][y - 1] - sums[x - 1][y - 1];
                if (map[x][y]) sums[x][y]++;
            }
        }
        for (int x = 2; x <= 998; x+=2) {
            for (int y = 2; y <= 998; y+=2) {
                int a = sums[x][y];
                int b = sums[1000][y] - sums[x][y];
                int c = sums[x][1000] - sums[x][y];
                int d = sums[1000][1000] - sums[1000][y] - sums[x][1000] + sums[x][y];

                int max = Math.max(Math.max(a, b), Math.max(c, d));
                answer = Math.min(answer, max);
            }
        }

        System.out.print(answer);
    }
}