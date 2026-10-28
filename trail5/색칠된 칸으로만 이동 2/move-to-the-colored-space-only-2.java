import java.util.*;
import java.io.*;

public class Main {

    private static int[][] dicts = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> dests = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int color = Integer.parseInt(st.nextToken());
                if (color == 1) dests.add(new int[]{i, j});
            }
        }

        int l = 0, r = 1_000_000_000;
        int answer = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            boolean isMoved = true;

            Queue<int[]> qu = new LinkedList<>();
            qu.offer(dests.get(0));

            boolean[][] visited = new boolean[M][N];
            visited[dests.get(0)[0]][dests.get(0)[1]] = true;

            while (!qu.isEmpty()) {
                int[] current = qu.poll();
                boolean moved = false;

                for (int[] dict : dicts) {
                    int nr = current[0] + dict[0];
                    int nc = current[1] + dict[1];

                    if (nr >= 0 && nr < M && nc >= 0 && nc < N && Math.abs(map[current[0]][current[1]] - map[nr][nc]) <= mid) {
                        if (!visited[nr][nc]) { qu.offer(new int[]{nr, nc}); visited[nr][nc] = true; }
                    }
                }

            }

            for (int[] dest : dests) {
                if (!visited[dest[0]][dest[1]]) isMoved = false;
            }

            if (!isMoved) l = mid + 1;
            else {
                answer = mid;
                r = mid - 1;
            }
        }

        System.out.print(answer);
    }
}