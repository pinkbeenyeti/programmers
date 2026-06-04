import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int answer = -1;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int h = 1; h <= N; h++) {
            for (int w = 1; w <= M; w++) {
                findRectangle(h, w);
            }
        }

        System.out.print(answer);
    }

    private static void findRectangle(int h, int w) {
        for (int r = 0; r <= N - h; r++) {
            for (int c = 0; c <= M - w; c++) {
                if (isPositive(r, c, h, w)) {
                    answer = Math.max(answer, h * w);
                }
            }
        }
    }

   
    private static boolean isPositive(int sr, int sc, int h, int w) {
        for (int r = sr; r < sr + h; r++) {
            for (int c = sc; c < sc + w; c++) {
                if (map[r][c] <= 0) {
                    return false;
                }
            }
        }
        return true;
    } 
}