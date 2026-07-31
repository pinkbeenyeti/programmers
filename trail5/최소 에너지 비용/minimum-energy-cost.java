import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long answer = 0;

        int[] distance = new int[N + 1];
        int[] energy = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
        }

        long[] mins = new long[N + 1];
        long[] disum = new long[N + 1];

        mins[0] = 2_000_000;

        for (int i = 1; i <= N; i++) {
            mins[i] = Math.min(mins[i - 1], energy[i]);
        }

        disum[N - 1] = distance[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            if (mins[i] != mins[i + 1]) {
                disum[i] = distance[i];
                answer += disum[i + 1] * mins[i + 1];
            }

            if (mins[i] == mins[i + 1]) {
                disum[i] = disum[i + 1] + distance[i];
            }
        }

        System.out.print(answer);
    }
}