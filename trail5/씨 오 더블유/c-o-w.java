import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long answer = 0;

        String target = br.readLine();

        int[] C = new int[N + 2];
        boolean[] O = new boolean[N + 1];
        int[] W = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            C[i] = C[i - 1];
            W[N - i + 1] = W[N - i + 2];

            if (target.charAt(i - 1) == 'C')
                C[i]++;
            else if (target.charAt(i - 1) == 'O')
                O[i] = true;
                
            if (target.charAt(N - i) == 'W')
                W[N - i + 1]++;
        }

        for (int i = 2; i < N; i++) {
            if (O[i]) {
                answer += (long) C[i - 1] * W[i + 1];
            }
        }

        System.out.print(answer);
    }
}