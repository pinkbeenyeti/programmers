import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] papers;
    private static int[] count;

    private static void checkPaper(int startRow, int startCol, int N) {
        if (N == 0) {
            return;
        }

        boolean isPaper = true;
        int color = papers[startRow][startCol];

        for (int i=startRow; i<(startRow + N); i++) {
            if (!isPaper) {
                break;
            }

            for (int j=startCol; j<(startCol + N); j++) {
                if (color != papers[i][j]) {
                    isPaper = false;
                    break;
                }
            }
        }

        if (isPaper) count[color]++;
        else {
            checkPaper(startRow, startCol, N/2);
            checkPaper(startRow, startCol + N/2, N/2);
            checkPaper(startRow + N/2, startCol, N/2);
            checkPaper(startRow + N/2, startCol + N/2, N/2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        papers = new int[N][N];
        count = new int[2];

        for (int i=0; i<N; i++) {
            String[] array = br.readLine().split(" ");

            for (int j=0; j<N; j++) {
                papers[i][j] = Integer.parseInt(array[j]);
            }
        }

        checkPaper(0, 0, N);
        System.out.print(count[0] + "\n" + count[1]);
    }
}
