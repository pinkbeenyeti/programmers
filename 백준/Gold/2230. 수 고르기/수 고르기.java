import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] numbers;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
    }

    private static void process() {
        int R = 1, answer = Integer.MAX_VALUE;

        for (int L=1; L<=N; L++) {
            int left = numbers[L];

            while (R < N && (numbers[R] - left) < M) {
                R++;
            }

            if (numbers[R] - left >= M) {
                answer = Math.min(answer, numbers[R] - left);
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
