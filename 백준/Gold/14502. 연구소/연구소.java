import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Position {
        int row, column;

        Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    static int[][] map;
    static int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int N, M;
    static int answer = 0;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][M];
        scanner.nextLine();

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                map[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
    }

    static void bfs(int[][] mapCopy) {
        Queue<Position> qu = new LinkedList<>();

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (mapCopy[i][j] == 2) qu.add(new Position(i, j));
            }
        }

        while (!qu.isEmpty()) {
            Position virus = qu.poll();
            for (int[] direction : directions) {
                int row = virus.row + direction[0], column = virus.column + direction[1];

                if (row < 0 || row >= N || column < 0 || column >= M) continue;
                if (mapCopy[row][column] != 0) continue;

                mapCopy[row][column] = 2;
                qu.add(new Position(row, column));
            }
        }

        int count = 0;
        for (int[] array : mapCopy) {
            for (int value : array) {
                if (value == 0) count++;
            }
        }

        answer = Math.max(answer, count);
    }

    static void dfs(int depth) {
        if (depth == 3) {
            int[][] mapCopy = new int[N][M];
            for (int i=0; i<N; i++) {
                System.arraycopy(map[i], 0, mapCopy[i], 0 , M);
            }
            bfs(mapCopy);
            return;
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void process() {
        dfs(0);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
