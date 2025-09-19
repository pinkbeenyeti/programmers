import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] numbers;
    private static int[] count;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];
        count = new int[100_001];
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        int L = 1, R = 1;
        long answer = 0;

        while (L <= R && R <= N) {
            if (count[numbers[R]] == 0) {
                count[numbers[R]] = 1;
                answer += (R - L + 1);
                R++;
            } else {
                count[numbers[L]] = 0;
                L++;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
