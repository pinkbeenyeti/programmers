import java.util.*;
import java.io.*;

public class Main {

    private static int[][] dicts = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int left = 0, right = 1_000_000, half = ((N * N) % 2 == 0) ? (N * N) / 2 : (N * N) / 2 + 1;
        int answer = 1_000_000;

        while (left <= right) {
            int mid = (left + right) / 2;
            int maxRegion = 0;

            boolean[][] visited = new boolean[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c]) {
                        visited[r][c] = true;
                        int count = 1;

                        Queue<int[]> qu = new LinkedList<>();
                        qu.offer(new int[]{r, c});

                        while (!qu.isEmpty()) {
                            int[] current = qu.poll();

                            for (int[] dict : dicts) {
                                int nr = current[0] + dict[0];
                                int nc = current[1] + dict[1];

                                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && Math.abs(board[nr][nc] - board[current[0]][current[1]]) <= mid) {
                                    qu.offer(new int[]{nr, nc});
                                    visited[nr][nc] = true;
                                    count++;
                                }
                            }
                        }

                        maxRegion = Math.max(maxRegion, count);
                    }
                }
            }

            if (maxRegion >= (half)) {
                right = mid - 1;
                answer = Math.min(mid, answer);
            }
            else {
                left = mid + 1;
            }
        }

        System.out.print(answer);
    }
}