import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, stRow, stCol, glRow, glCol;
    private static int[][] map;

    private static Map<Integer, int[][]> directions;
    private static int[][][] dists;

    private static class Move implements Comparable<Move>{
        int row, col, moveIndex, collision;

        public Move(int row, int col, int moveIndex, int collision) {
            this.row = row;
            this.col = col;
            this.moveIndex = moveIndex;
            this.collision = collision;
        }

        @Override
        public int compareTo(Move other) {
            return this.collision - other.collision;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        st = new StringTokenizer(br.readLine());

        stRow = Integer.parseInt(st.nextToken());;
        stCol = Integer.parseInt(st.nextToken());
        glRow = Integer.parseInt(st.nextToken());
        glCol = Integer.parseInt(st.nextToken());

        for (int row=1; row<=N; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col=1; col<=M; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void preProcess() {
        directions = new HashMap<>();
        directions.put(0, new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}});
        directions.put(1, new int[][]{{-1, 0}, {1, 0}});
        directions.put(2, new int[][]{{0, -1}, {0, 1}});

        dists = new int[N + 1][M + 1][3];
        for (int state=0; state<3; state++) {
            for (int row=1; row<=N; row++) {
                for (int col=1; col<=M; col++){
                    dists[row][col][state] = Integer.MAX_VALUE;
                }
            }
         }
        dists[stRow][stCol][1] = 0;
    }

    private static void process() {
        PriorityQueue<Move> pq = new PriorityQueue<>();
        pq.offer(new Move(stRow, stCol, 1, 0));

        while (!pq.isEmpty()) {
            Move move = pq.poll();

            if (move.collision > dists[move.row][move.col][move.moveIndex]) {
                continue;
            }

            for (int[] direction : directions.get(move.moveIndex)) {
                int row = move.row + direction[0], col = move.col + direction[1];

                if (row >= 1 && row <= N && col >= 1 && col <= M && map[row][col] != -1) {
                    if (move.collision + map[row][col] < dists[row][col][(move.moveIndex + 1) % 3]) {
                        dists[row][col][(move.moveIndex + 1) % 3] =  move.collision + map[row][col];
                        pq.offer(new Move(row, col, (move.moveIndex + 1) % 3, move.collision + map[row][col]));
                    }
                }
            }
        }

        int answer = Math.min(Math.min(dists[glRow][glCol][0], dists[glRow][glCol][1]), dists[glRow][glCol][2]);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        preProcess();
        process();
    }
}
