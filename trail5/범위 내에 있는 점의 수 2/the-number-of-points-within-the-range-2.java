import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] isExist = new boolean[1_000_005];
        int[] sums = new int[1_000_005];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            isExist[Integer.parseInt(st.nextToken())] = true; 
        }

        sums[0] = isExist[0] ? 1 : 0;

        for (int i = 1; i <= 1_000_000; i++) {
            sums[i] = sums[i - 1] + (isExist[i] ? 1 : 0);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            answer.append(sums[b] - sums[a] + (isExist[a] ? 1 : 0));
            answer.append("\n");
        }

        System.out.print(answer);
    }
}