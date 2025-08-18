import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] scores;
    private static int[][] maxScores;
    private static int[][] minScores;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        scores = new int[N + 1][3];
        maxScores = new int[N + 1][3];
        minScores = new int[N + 1][3];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<3; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void process() {
        for (int i=0; i<3; i++) {
            maxScores[1][i] = scores[1][i];
            minScores[1][i] = scores[1][i];
        }

        for (int row=2; row<=N; row++) {
            maxScores[row][0] = Math.max(maxScores[row-1][0], maxScores[row-1][1]) + scores[row][0];
            maxScores[row][1] = Math.max(Math.max(maxScores[row-1][0], maxScores[row-1][1]), maxScores[row - 1][2]) + scores[row][1];
            maxScores[row][2] = Math.max(maxScores[row-1][1], maxScores[row-1][2]) + scores[row][2];

            minScores[row][0] = Math.min(minScores[row-1][0], minScores[row-1][1]) + scores[row][0];
            minScores[row][1] = Math.min(Math.min(minScores[row-1][0], minScores[row-1][1]), minScores[row - 1][2]) + scores[row][1];
            minScores[row][2] = Math.min(minScores[row-1][1], minScores[row-1][2]) + scores[row][2];
        }

        System.out.print(Math.max(Math.max(maxScores[N][0], maxScores[N][1]), maxScores[N][2]) + " ");
        System.out.println(Math.min(Math.min(minScores[N][0], minScores[N][1]), minScores[N][2]));
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
