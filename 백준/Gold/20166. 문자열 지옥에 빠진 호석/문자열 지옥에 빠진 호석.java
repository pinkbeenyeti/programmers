import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    private static int N, M, K;
    private static char[][] world;

    private static Queue<String> godLoves = new LinkedList<>();
    private static Map<String, Integer> allStrings = new HashMap<>();

    private static int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1},
        {0, 1}, {1, -1}, {1, 1},
        {-1, -1}, {-1, 1}
    };

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        world = new char[N][M];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            String tiles = st.nextToken();

            for (int col = 0; col < M; col++) {
                world[row][col] = tiles.charAt(col);
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();

            allStrings.put(key, allStrings.getOrDefault(key, 0));
            godLoves.offer(key);
        }
    }

    private static void dfs(int depth, int row, int col, String path) {
        if (depth == 6) return;

        allStrings.put(path, allStrings.getOrDefault(path, 0) + 1);
        for (int[] direction : directions) {
            int nRow = (row + direction[0] + N ) % N, nCol = (col + direction[1] + M) % M;
            dfs(depth + 1, nRow, nCol, path + world[nRow][nCol]);
        }
    }

    private static void process() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                dfs(1, row, col, world[row][col] + "");
            }
        }

        while (!godLoves.isEmpty()) {
            System.out.println(allStrings.get(godLoves.poll()));
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
