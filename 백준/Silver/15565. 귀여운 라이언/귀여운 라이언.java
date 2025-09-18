import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int[] dolls;
    private static int[] dollCount;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dolls = new int[N + 1];
        dollCount = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int R = 0, answer = N + 1;

        for (int L=1; L<=N; L++) {
            dollCount[dolls[L - 1]]--;

            while (R < N && dollCount[1] < K) {
                R++;
                dollCount[dolls[R]]++;
            }

            if (dollCount[1] >= K) {
                answer = Math.min(answer, R - L + 1);
            }
        }
        
        if (answer == N + 1) answer = -1;
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
