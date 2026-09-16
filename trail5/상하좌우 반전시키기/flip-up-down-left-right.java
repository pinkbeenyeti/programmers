import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int count = 0;

        int[][] map = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i - 1][j] == 0) {
                    map[i][j] = 1 - map[i][j];
                    map[i - 1][j] = 1 - map[i - 1][j];
                    map[i][j - 1] = 1 - map[i][j - 1];
                    map[i][j + 1] = 1 - map[i][j + 1];
                    map[i + 1][j] = 1 - map[i + 1][j];
                    count++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (map[N][i] == 0) {
                System.out.print(-1);
                return;
            }
        }

        System.out.print(count);
    }
}