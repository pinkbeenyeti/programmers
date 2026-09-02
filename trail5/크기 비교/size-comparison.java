import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] bs = new int[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());

            bs[big][small] = 1;
            bs[small][big] = -1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (bs[i][k] == 1 && bs[k][j] == 1)
                        bs[i][j] = 1;
                    else if (bs[i][k] == -1 && bs[k][j] == -1)
                        bs[i][j] = -1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int count = 0;

            for (int j = 1; j <= N; j++) {
                if (i != j && bs[i][j] == 0) {
                    count++;
                }
            }

            answer.append(count + "\n");
        }

        System.out.print(answer);
    }
}