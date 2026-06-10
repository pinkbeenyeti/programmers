import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int answer = Integer.MIN_VALUE;

    private static int[][] map;
    private static int[][][][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        sum = new int[N][N][M][M];

        for (int sr = 0; sr < N; sr++) {
            for (int er = (sr); er < N; er++) {
                for (int sc = 0; sc < M; sc++) {
                    for (int ec = (sc); ec < M; ec++) {
                        if (sr == er && sc == ec) sum[sr][er][sc][ec] = map[er][ec];
                        else if (sr == er) sum[sr][er][sc][ec] = sum[sr][er][sc][ec - 1] + map[er][ec];
                        else if (sc == ec) sum[sr][er][sc][ec] = sum[sr][er - 1][sc][ec] + map[er][ec];
                        else sum[sr][er][sc][ec] = sum[sr][er][sc][ec - 1]
                                                 + sum[sr][er - 1][sc][ec]
                                                 - sum[sr][er - 1][sc][ec - 1]
                                                 + map[er][ec];
                    }
                }
            }
        }

        for (int sr = 0; sr < N; sr++) {
            for (int er = (sr); er < N; er++) {
                for (int sc = 0; sc < M; sc++) {
                    for (int ec = (sc); ec < M; ec++) {
                        compare(sr, er, sc, ec);
                    }
                }
            }
        }

        System.out.print(answer);
    }

    private static void compare(int sr, int er, int sc, int ec) {
        for (int ar = 0; ar < N; ar++) {
            for (int br = ar; br < N; br++) {
                for (int ac = 0; ac < M; ac++) {
                    for (int bc = ac; bc < M; bc++) {
                        if (ar > er || br < sr || ac > ec || bc < sc) {
                            answer = Math.max(answer, sum[ar][br][ac][bc] + sum[sr][er][sc][ec]);
                        }
                    }
                }
            }
        }
    }
}