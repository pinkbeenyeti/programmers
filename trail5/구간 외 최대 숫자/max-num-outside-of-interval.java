import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] L = new int[N + 2];
        int[] R = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            L[i] = Math.max(L[i - 1], nums[i]);
        }

        for (int i = N; i >= 1; i--) {
            R[i] = Math.max(R[i + 1], nums[i]);
        }

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            answer.append(Math.max(L[a - 1], R[b + 1]));
            answer.append("\n");
        }

        System.out.print(answer);
    }
}