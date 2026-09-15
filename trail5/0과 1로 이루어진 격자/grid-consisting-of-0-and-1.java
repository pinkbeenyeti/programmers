import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        int[][] map = new int[N + 1][N + 1];
        int[][] fliped = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            String target = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j + 1] = target.charAt(j) - '0';
            } 
        }

        for (int r = N; r >= 1; r--) {
            for (int c = N; c >= 1; c--) {
                fliped[r][c] = (fliped[r + 1][c + 1] + fliped[r + 1][c] + fliped[r][c + 1]) % 2;

                int value = (fliped[r][c] == 1) ? 1 - map[r][c] : map[r][c];

                if (value == 1) {
                    fliped[r][c] = 1 - fliped[r][c];
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}