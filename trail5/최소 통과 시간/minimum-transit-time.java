import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] tunnels = new long[M];

        for (int i = 0; i < M; i++) {
            tunnels[i] = Long.parseLong(br.readLine());
        }

        long l = 1, r = Long.MAX_VALUE - 2;
        long answer = Long.MAX_VALUE;

        while (l <= r) {
            long mid = (l + r) / 2;

            if (find(tunnels, N, mid)) {
                r = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                l = mid + 1;
            }
        }

        System.out.print(answer);
    }

    private static boolean find(long[] tunnels, int N, long value) {
        int count = 0;

        for (int i = 0; i < tunnels.length; i++) {
            count += value / tunnels[i];
            if (count >= N) return true;
        }

        return false;
    }
}