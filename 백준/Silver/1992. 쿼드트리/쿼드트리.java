import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] papers;

    private static String checkSquare(int startRow, int startCol, int N) {
        if (N == 0) {
            return "";
        }

        int value = papers[startRow][startCol];
        boolean isSquare = true;

        for (int i=startRow; i<(startRow+N); i++) {
            if (!isSquare) {
                break;
            }

            for (int j=startCol; j<(startCol+N); j++) {
                if (value != papers[i][j]) {
                    isSquare = false;
                    break;
                }
            }
        }

        if (isSquare) return String.format("%d", value);
        else {
            String lu = checkSquare(startRow, startCol, N/2);
            String ru = checkSquare(startRow, startCol + N/2, N/2);
            String ld = checkSquare(startRow + N/2, startCol, N/2);
            String rd = checkSquare(startRow + N/2, startCol + N/2, N/2);

            return String.format("(%s%s%s%s)", lu, ru, ld, rd);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        papers = new int[N][N];

        for (int i=0; i<N; i++) {
            char[] array = br.readLine().toCharArray();

            for (int j=0; j<N; j++) {
                papers[i][j] = array[j] - '0';
            }
        }

        System.out.print(checkSquare(0, 0, N));
    }
}
