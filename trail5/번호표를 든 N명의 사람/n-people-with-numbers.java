import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] times = new int[N];

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }

        int l = 1, r = N;
        int answer = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (find(times, T, mid)) {
                r = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                l = mid + 1;
            }
        }

        System.out.print(answer);
    }

    private static boolean find(int[] times, int T, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < K; i++) {
            pq.offer(times[i]);
        }

        for (int i = K; i < times.length; i++) {
            int end = pq.poll() + times[i];

            if (end > T) return false;
            else pq.offer(end);
        }

        return true;
    }
}