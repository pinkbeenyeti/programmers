import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dists = new int[N + 1][N + 1];

        for (int[] array : dists) {
            Arrays.fill(array, 1_000_000_000);
        }

        for (int i = 1; i <= N; i++) {
            dists[i][i] = 0;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dists[a][b] = Math.min(dists[a][b], v);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dists[i][j] > dists[i][k] + dists[k][j]) {
                        dists[i][j] = dists[i][k] + dists[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dists[i][j] == 1_000_000_000)
                    answer.append(-1 + " ");
                else
                    answer.append(dists[i][j] + " ");
            }
            answer.append("\n");
        }

        System.out.print(answer);
    }
}