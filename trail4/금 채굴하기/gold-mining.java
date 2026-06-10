import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int maxGold = 0;
        int maxK = N * 2; 

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                
                for (int K = 0; K <= maxK; K++) {
                    int goldCount = 0;

                    for (int nr = r - K; nr <= r + K; nr++) {
                        for (int nc = c - K; nc <= c + K; nc++) {
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                if (Math.abs(r - nr) + Math.abs(c - nc) <= K) {
                                    if (map[nr][nc] == 1) {
                                        goldCount++;
                                    }
                                }
                            }
                        }
                    }

                    int cost = K * K + (K + 1) * (K + 1);
                    int profit = goldCount * M;

                    if (profit >= cost) {
                        maxGold = Math.max(maxGold, goldCount);
                    }
                }
                
            }
        }

        System.out.print(maxGold);
    }
}