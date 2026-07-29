import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = 200_000;

        boolean[] isExclude = new boolean[N + 1];
        int[] counts = new int[N + 1];

        for (int i = 0; i < B; i++) {
            st = new StringTokenizer(br.readLine());
            isExclude[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i <= N; i++) {
            counts[i] = counts[i - 1] + (isExclude[i] ? 1 : 0);
        }

        for (int i = K; i <= N; i++) {
            answer = Math.min(answer, counts[i] - counts[i - K]);
        }

        System.out.print(answer);
    }
}