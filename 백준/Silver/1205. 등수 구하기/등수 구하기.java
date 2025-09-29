import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, score, P, answer = 0;
    private static Rank[] rankArray;

    private static class Rank {
        int rank, score;

        public Rank(int rank, int score) {
            this.rank = rank;
            this.score = score;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        rankArray = new Rank[P + 1];
        rankArray[0] = new Rank(0, -1);

        if (N != 0) {
            st = new StringTokenizer(br.readLine());
        }

        for (int i=1; i<=N; i++) {
            int nowScore = Integer.parseInt(st.nextToken());

            if (rankArray[i - 1].score != nowScore) {
                rankArray[i] = new Rank(i, nowScore);
            } else {
                rankArray[i] = new Rank(rankArray[i - 1].rank, nowScore);
            }
        }
    }

    private static void process() {
        if (N == 0) {
            System.out.println(1);
            return;
        }

        if (N == P && score <= rankArray[N].score){
            System.out.println(-1);
            return;
        }

        int L = 1, R = N, answerIndex = N + 1;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (rankArray[mid].score > score) {
                L = mid + 1;
            } else {
                R = mid - 1;
                answerIndex = mid;
            }
        }

        if (answerIndex <= N && rankArray[answerIndex].score == score) {
            System.out.println(rankArray[answerIndex].rank);
        } else {
            System.out.println(answerIndex);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
