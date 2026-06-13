import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    private static int N, M;
    private static int time, size;

    private static int[][] map;
    private static int[][] temp;
    private static int[][] dicts = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        temp = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < 300; i++) {
            int zeros = 1;
            int ices = 0;

            boolean[][] visited = new boolean[N][M];
            visited[0][0] = true;

            Queue<int[]> qu = new LinkedList<>();
            qu.offer(new int[]{0, 0});

            while (!qu.isEmpty()) {
                int[] current = qu.poll();

                for (int[] dict : dicts) {
                    int r = current[0] + dict[0];
                    int c = current[1] + dict[1];

                    if (r >= 0 && r < N && c >= 0 && c < M && !visited[r][c]) {
                        if (map[r][c] == 0) {
                            qu.offer(new int[]{r, c});
                            visited[r][c] = true;
                            zeros++;
                        }

                        if (map[r][c] == 1) {
                            visited[r][c] = true;
                            temp[r][c] = -1;
                            ices++;
                        }
                    }
                }
            }

            if (zeros == N * M) break;
            else {
                time = i;
                size = ices;
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    map[r][c] += temp[r][c];
                    temp[r][c] = 0;
                }
            }
        }

        System.out.print(time + " " + size);
    }
}