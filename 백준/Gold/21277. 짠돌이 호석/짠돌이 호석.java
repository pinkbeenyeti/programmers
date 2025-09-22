import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N1, M1, N2, M2, answer = Integer.MAX_VALUE;
    private static int[][] puzzle1, puzzle2;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N1 = Integer.parseInt(st.nextToken());
        M1 = Integer.parseInt(st.nextToken());
        puzzle1 = new int[N1][M1];

        for (int row=0; row<N1; row++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            for (int col=0; col<M1; col++) {
                puzzle1[row][col] = line.charAt(col) - '0';
            }
        }

        st = new StringTokenizer(br.readLine());
        N2 = Integer.parseInt(st.nextToken());
        M2 = Integer.parseInt(st.nextToken());
        puzzle2 = new int[N2][M2];

        for (int row=0; row<N2; row++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            for (int col=0; col<M2; col++) {
                puzzle2[row][col] = line.charAt(col) - '0';
            }
        }
    }

    private static void process() {
        for (int i=1; i<=4; i++) {
            rotate();

            for (int shift_row=-51; shift_row<=51; shift_row++) {
                for (int shift_col=-51; shift_col<=51; shift_col++) {
                    if (checkPossible(shift_row, shift_col)) {
                        int height = Math.max(N1, shift_row + puzzle2.length) - Math.min(0, shift_row);
                        int width = Math.max(M1, shift_col + puzzle2[0].length) - Math.min(0, shift_col);

                        answer = Math.min(answer, height * width);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static void rotate() {
        int N = puzzle2.length, M = puzzle2[0].length;
        int[][] tempPuzzle = new int[M][N];

        for (int row=0; row<M; row++) {
            for (int col=0; col<N; col++) {
                tempPuzzle[row][col] = puzzle2[N - col - 1][row];
            }
        }

        puzzle2 = tempPuzzle;
    }

    private static boolean checkPossible(int shift_row, int shift_col) {
        for (int row=0; row<puzzle2.length; row++) {
            for (int col=0; col< puzzle2[0].length; col++) {
                if (puzzle2[row][col] == 1) {
                    int newRow = shift_row + row, newCol = shift_col + col;

                    if (newRow >=0 && newRow < puzzle1.length && newCol >= 0 && newCol < puzzle1[0].length && puzzle1[newRow][newCol] == 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
