import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int[] temperatures;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        temperatures = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int R = K, sum = 0, answer = Integer.MIN_VALUE;

        for (int i=1; i<=(K-1); i++) {
            sum += temperatures[i];
        }

        for (int L=1; L<=(N-K+1); L++) {
            sum += temperatures[R];
            answer = Math.max(answer, sum);

            sum -= temperatures[L];
            R++;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
