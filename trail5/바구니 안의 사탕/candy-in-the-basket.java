import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] candy = new long[1_000_001];
        long[] sums = new long[1_000_001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int cand = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            candy[pos] += cand;
        }

        sums[0] = candy[0];
        long answer = 0;

        for (int i = 1; i <= 1_000_000; i++) {
            sums[i] = sums[i - 1] + candy[i];
        }

        for (int i = 0; i <= 1_000_000; i++) {
            int a = Math.max(0, i - K);
            int b = Math.min(1_000_000, i + K);
            answer = Math.max(answer, sums[b] - sums[a] + candy[a]);
        }

        System.out.print(answer);
    }
}