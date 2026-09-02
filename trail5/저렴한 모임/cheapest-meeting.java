import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[][] dists = new int[N + 1][N + 1];

        for (int[] dist : dists) {
            Arrays.fill(dist, 1_000_000_000);
        }

        for (int i = 1; i <= N; i++) {
            dists[i][i] = 0;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dists[a][b] = v;
            dists[b][a] = v;
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
            if (dists[v1][i] < 1_000_000_000 && dists[v2][i] < 1_000_000_000 && dists[i][end] < 1_000_000_000) {
                answer = Math.min(answer, dists[v1][i] + dists[v2][i] + dists[i][end]);
            }
        }

        if (answer >= 1_000_000_000)
            System.out.print(-1);
        else
            System.out.print(answer);
    }
}