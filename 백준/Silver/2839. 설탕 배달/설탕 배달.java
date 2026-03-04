import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] array = new int[2][5001];

        array[0][3] = 1;
        array[0][6] = 2;
        array[0][8] = 1;
        array[0][9] = 3;

        array[1][5] = 1;
        array[1][8] = 1;
        array[1][10] = 2;

        for (int i=11; i<=5000; i++) {
            array[0][i] = 2000;
            array[1][i] = 2000;

            for (int j=1; j<=(i/2); j++) {
                int a = array[0][j] + array[1][j];
                int b = array[0][i-j] + array[1][i-j];

                if (a != 0 && b != 0 && (a + b) < (array[0][i] + array[1][i])) {
                    array[0][i] = array[0][j] + array[0][i-j];
                    array[1][i] = array[1][j] + array[1][i-j];
                }
            }
        }

        if (array[0][N] + array[1][N] != 0) System.out.print(array[0][N] + array[1][N]);
        else System.out.print(-1);
    }
}
