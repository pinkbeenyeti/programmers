import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] liquids;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        liquids = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquids);
    }

    private static void process() {
        int L = 0, R = N - 1, diff = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (L < R) {
            if (Math.abs(liquids[L] + liquids[R]) < diff) {
                answer[0] = liquids[L];
                answer[1] = liquids[R];
                diff = Math.abs(liquids[L] + liquids[R]);
            }

            if (liquids[L] + liquids[R] > 0) R--;
            else if (liquids[L] + liquids[R] < 0) L++;
            else {
                break;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
