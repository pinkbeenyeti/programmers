import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int T;

    private static Map<Integer, Integer> balls;
    private static int[][] dicts = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        balls = new HashMap<>();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            balls.put(r * N + c, balls.getOrDefault(r * N + c, 0) + 1);
        }

        for (int i = 0; i < T; i++) {
            List<Integer> positions = new ArrayList<>();

            for (int position : balls.keySet()) {
                int r = position / N, c = position % N;
                int resultR = 0, resultC = 0;
                int max = 0;

                for (int[] dict : dicts) {
                    int nr = r + dict[0];
                    int nc = c + dict[1];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > max) { 
                        resultR = nr;
                        resultC = nc;
                        max = map[nr][nc];
                    }
                }

                positions.add(resultR * N + resultC);
                balls.put(r * N + c, balls.get(r * N + c) - 1);
            }

            for (int position : positions) {
                balls.put(position, balls.getOrDefault(position, 0) + 1);
            }

            positions.clear();

            for (int position : balls.keySet()) {
                if (balls.get(position) == 0 || balls.get(position) > 1) {
                    positions.add(position);
                }
            }

            for (int position : positions) {
                balls.remove(position);
            }
        }

        System.out.print(balls.size());
    }
}