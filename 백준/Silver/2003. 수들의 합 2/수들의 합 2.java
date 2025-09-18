import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] numbers;

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int R = 0, sum = 0, ans = 0;

        for (int L=1; L<=N; L++) {
            sum -= numbers[L - 1];

            while (R < N && sum < M) {
                R++;
                sum += numbers[R];
            }

            if (sum == M) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
