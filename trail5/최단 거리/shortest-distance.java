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

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                dists[i][j] = Integer.parseInt(st.nextToken());
                dists[i][j] = (i == j) ? 0 : dists[i][j];
            }
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

        for (int i = 1; i <= M; i++) {
           st = new StringTokenizer(br.readLine());

           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());

           answer.append(dists[a][b] + "\n");
        }

        System.out.print(answer);
    }
}