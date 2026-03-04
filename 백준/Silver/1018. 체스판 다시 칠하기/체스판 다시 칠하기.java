import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean[][] board;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = (str.charAt(j) == 'W');
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    public static void find(int startRow, int startCol) {
        int endRow = startRow + 8;
        int endCol = startCol + 8;
        int count = 0;

        boolean expected = board[startRow][startCol];

        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {

                if (board[i][j] != expected) {
                    count++;
                }

                expected = (!expected);
            }
            expected = (!expected);
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
