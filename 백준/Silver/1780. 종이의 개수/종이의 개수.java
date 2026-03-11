import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] papers;
    private static int[] count;

    private static void checkSquare(int startRow, int startCol, int N) {
        if (N == 0) {
            return;
        }

        int value = papers[startRow][startCol];
        boolean isSquare = true;

        for (int i=startRow; i<(startRow+N); i++) {
            if (!isSquare) {
                break;
            }

            for (int j=startCol; j<(startCol+N); j++) {
                if (papers[i][j] != value) {
                    isSquare = false;
                    break;
                }
            }
        }

        if (isSquare) count[value]++;
        else {
            checkSquare(startRow, startCol, N/3);
            checkSquare(startRow, startCol + N/3, N/3);
            checkSquare(startRow, startCol + N/3 + N/3, N/3);
            checkSquare(startRow + N/3, startCol, N/3);
            checkSquare(startRow + N/3 + N/3, startCol, N/3);
            checkSquare(startRow + N/3, startCol + N/3, N/3);
            checkSquare(startRow + N/3 + N/3, startCol + N/3, N/3);
            checkSquare(startRow + N/3, startCol + N/3 + N/3, N/3);
            checkSquare(startRow + N/3 + N/3, startCol + N/3 + N/3, N/3);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        papers = new int[N][N];
        count = new int[3];

        for (int i=0; i<N; i++) {
            String[] array = br.readLine().split(" ");

            for (int j=0; j<N; j++) {
                papers[i][j] = Integer.parseInt(array[j]) + 1;
            }
        }

        checkSquare(0, 0, N);
        System.out.print(count[0] + "\n" + count[1] + "\n" + count[2]);
    }
}
