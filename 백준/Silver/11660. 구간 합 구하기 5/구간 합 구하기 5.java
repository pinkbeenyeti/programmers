import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;

    private static int[][] board;
    private static int[][] partSum;
    private static int[][] requests;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];
        partSum = new int[N + 1][N + 1];
        requests = new int[M][4];

        for (int r=1; r<=N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=1; c<=N; c++) board[r][c] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<4; j++) requests[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        StringBuilder answer = new StringBuilder();
        partSum[1][1] = board[1][1];

        for (int r=1; r<=N; r++) {
            for (int c=1; c<=N; c++) {
                partSum[r][c] = partSum[r - 1][c] + partSum[r][c - 1] - partSum[r - 1][c - 1] + board[r][c];
            }
        }

        for (int[] request : requests) {
            answer.append(partSum[request[2]][request[3]] - partSum[request[0] - 1][request[3]] - partSum[request[2]][request[1] - 1] + partSum[request[0] - 1][request[1] - 1]);
            answer.append("\n");
        }

        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
