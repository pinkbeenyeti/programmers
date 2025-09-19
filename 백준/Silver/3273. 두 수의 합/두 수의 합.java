import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, X;
    private static int[] numbers;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);
    }

    private static void process() {
        int L = 0, R = N - 1, answer = 0;

        while (L < R) {
            int sum  = numbers[L] + numbers[R];

            if (sum > X) R--;
            else if (sum < X) L++;
            else {
                R--;
                L++;
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
