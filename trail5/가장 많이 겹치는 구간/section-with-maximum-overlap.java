import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] sums = new int[200_002];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sums[a]++;
            sums[b + 1]--;
        }

        for (int i = 1; i <= 200_000; i++) {
            sums[i] += sums[i - 1];
            answer = Math.max(answer, sums[i]);
        }

        System.out.print(answer);
    }
}