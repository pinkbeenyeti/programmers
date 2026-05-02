import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    private static int n, l, r;
    private static int[][] eggs;
    private static int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        eggs = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                eggs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        int move = 0;

        while (true) {
            List<Integer> values = new ArrayList<>();

            boolean[][] visited = new boolean[n][n];
            int[][] regions = new int[n][n];

            int index = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;
                    
                    findRegions(values, visited, regions, index, i, j);
                    index++;
                }
            }

            if (values.size() == (n * n)) break;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    eggs[i][j] = values.get(regions[i][j]);
                }
            }

            move++;
        }

        System.out.print(move);
    }

    private static void findRegions(List<Integer> values, boolean[][] visited, int[][] regions, int index, int rPos, int cPos) {
        int sum = 0;
        int count = 0;

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{rPos, cPos});
        visited[rPos][cPos] = true;

        while (!qu.isEmpty()) {
            int[] current = qu.poll();
            
            int currR = current[0];
            int currC = current[1];

            regions[currR][currC] = index;
            sum += eggs[currR][currC];
            count++;

            for (int[] dr : directions) {
                int nr = currR + dr[0];
                int nc = currC + dr[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    int diff = Math.abs(eggs[nr][nc] - eggs[currR][currC]);
                    
                    if (diff >= l && diff <= r) {
                        visited[nr][nc] = true;
                        qu.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        values.add(sum / count);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}