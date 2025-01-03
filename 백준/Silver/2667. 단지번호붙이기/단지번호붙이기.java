import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N, group_cnt;
    static ArrayList<Integer> groups;

    static int[][] maxtrix;
    static boolean[][] visit;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static String[] aparts;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();;
        scanner.nextLine();

        maxtrix = new int[N][N];
        visit = new boolean[N][N];
        aparts = new String[N];
        groups = new ArrayList<>();

        for (int i=0; i<N; i++) {
            aparts[i] = scanner.nextLine();
        }

        for (int i=0; i<N; i++) {
            String[] apart = aparts[i].split("");
            for (int j=0; j<N; j++) {
                maxtrix[i][j] = Integer.parseInt(apart[j]);
            }
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        group_cnt++;

        for (int[] dir : dirs) {
            int p = x + dir[0], q = y + dir[1];

            if (p < 0 || q < 0 || p >= N || q >= N) continue;
            if (visit[p][q] || maxtrix[p][q] == 0) continue;

            dfs(p, q);
        }
    }

    static void process() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (maxtrix[i][j] == 0) continue;
                if (visit[i][j]) continue;
                dfs(i, j);
                groups.add(group_cnt);
                group_cnt = 0;
            }
        }

        Collections.sort(groups);
        System.out.println(groups.size());

        for (int count : groups) {
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
