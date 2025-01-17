import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Postion {
        int row, column, count;

        public Postion(int row, int column, int count) {
            this.row = row;
            this.column = column;
            this.count = count;
        }
    }

    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] maze;
    static boolean[][] visit;
    static int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        maze = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];
        scanner.nextLine();

        for (int i=1; i<=N; i++) {
            String[] temp = scanner.nextLine().split("");
            for (int j=1; j<=M; j++) {
                int k = Integer.parseInt(temp[j-1]);
                maze[i][j] = k;

                if (k == 0) visit[i][j] = true;
            }
        }

        visit[1][1] = true;
    }

    static void bfs() {
        Queue<Postion> qu = new LinkedList<>();
        qu.add(new Postion(1, 1, 1));

        while(!qu.isEmpty()) {
            Postion pos = qu.poll();
            for (int[] direction : directions) {
                int row = pos.row + direction[0], column = pos.column + direction[1];

                if (row < 1 || row > N || column < 1 || column > M) continue;
                if (visit[row][column]) continue;
                if (row == N & column == M) {
                    answer = Math.min(answer, pos.count+1);
                    continue;
                }

                qu.add(new Postion(row, column, pos.count+1));
                visit[row][column] = true;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        bfs();
    }
}
