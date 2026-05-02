import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static int n, m, answer = 0;

    private static int[][] map;
    private static boolean[][] isGrowed;
    private static List<int[]> nutritions;

    private static int[] diagonalIndexes = {2, 4, 6, 8};
    private static int[][] dicts = {{0, 0}, {0, 1}, {-1, 1}, 
                                    {-1, 0}, {-1, -1}, {0, -1},
                                    {1, -1}, {1, 0}, {1, 1}};

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        isGrowed = new boolean[n][n];
        nutritions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = (n - 2); i < n; i++) {
            for (int j = 0; j < 2; j++) {
                nutritions.add(new int[]{i, j});
                isGrowed[i][j] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            moveNutritions(d, p);
            growTrees();
            removeTrees();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += map[i][j];
            }
        }

        System.out.print(answer);
    }

    private static void moveNutritions(int d, int p) {
        isGrowed = new boolean[n][n];
        
        for (int[] nutrition : nutritions) {
            nutrition[0] = ((nutrition[0] + (dicts[d][0] * p) % n) + n) % n;
            nutrition[1] = ((nutrition[1] + (dicts[d][1] * p) % n) + n) % n;

            isGrowed[nutrition[0]][nutrition[1]] = true;
        }
    }

    private static void growTrees() {
        int[] count = new int[nutritions.size()];

        for (int i = 0; i < nutritions.size(); i++) {
            int r = nutritions.get(i)[0];
            int c = nutritions.get(i)[1];
            
            map[r][c] += 1;
        }

        for (int i = 0; i < nutritions.size(); i++) {
            int r = nutritions.get(i)[0];
            int c = nutritions.get(i)[1];

            for (int index : diagonalIndexes) {
                int nr = r + dicts[index][0];
                int nc = c + dicts[index][1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] > 0) {
                    count[i]++;
                }
            }
        }

        for (int i = 0; i < nutritions.size(); i++) {
            int r = nutritions.get(i)[0];
            int c = nutritions.get(i)[1];

            map[r][c] += count[i];
        }
    }

    private static void removeTrees() {
        nutritions.clear();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isGrowed[i][j]) {
                    continue;
                }

                if (map[i][j] >= 2) {
                    map[i][j] -= 2;
                    nutritions.add(new int[]{i, j});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
       process();
    }
}