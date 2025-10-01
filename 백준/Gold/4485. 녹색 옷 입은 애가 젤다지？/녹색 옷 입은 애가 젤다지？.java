import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dicts = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static class Info implements Comparable<Info> {
        int row, col, value;

        public Info(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Info other) {
            return this.value - other.value;
        }
    }

    private static int getMin(int[][] cave, int N) {
        int[][] costs = new int[N][N];

        for (int[] row : costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(0, 0, cave[0][0]));
        costs[0][0] = cave[0][0];

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (info.value > costs[info.row][info.col]) {
                continue;
            }

            for (int[] dict : dicts) {
                int row = info.row + dict[0], col = info.col + dict[1];

                if (row >= 0 && row < N && col >= 0 && col < N) {
                    if (costs[row][col] > info.value + cave[row][col]) {
                        costs[row][col] = info.value + cave[row][col];
                        pq.offer(new Info(row, col, info.value + cave[row][col]));
                    }
                }
            }
        }

        return costs[N - 1][N - 1];
    }

    private static void process() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int index = 1, result = 0;

        while (N != 0) {
            int[][] cave = new int[N][N];

            for (int row=0; row<N; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int col=0; col<N; col++) {
                    cave[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            result = getMin(cave, N);
            answer.append("Problem ").append(index).append(": ").append(result).append("\n");

            N = Integer.parseInt(br.readLine());
            index++;
        }

        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
