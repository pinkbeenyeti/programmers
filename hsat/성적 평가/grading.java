import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static StringBuilder answer;

    private static class Info {
        int index, score;

        public Info(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answer = new StringBuilder();

        Info[] scores = new Info[N];
        Info[] finalScores = new Info[N];

        for (int i = 0; i < N; i++) {
            scores[i] = new Info(i, 0);
            finalScores[i] = new Info(i, 0);
        }

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int target = Integer.parseInt(st.nextToken());

                scores[j].index = j;
                scores[j].score = target;
                finalScores[j].score += target;
            }

            sortScores(scores);
        }

        sortScores(finalScores);
        System.out.print(answer);
    }

    private static void sortScores(Info[] scores) {
        int[] result = new int[N];

        Arrays.sort(scores, (a, b) -> {return b.score - a.score;});
        result[scores[0].index] = 1;

        for (int i = 1; i < N; i++) {
            if (scores[i - 1].score == scores[i].score) result[scores[i].index] = result[scores[i - 1].index];
            else result[scores[i].index] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            answer.append(result[i]).append(" ");
        }

        answer.append("\n");
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}