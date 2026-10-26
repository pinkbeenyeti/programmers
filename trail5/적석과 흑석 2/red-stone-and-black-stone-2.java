import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] red = new int[C];
        for (int i = 0; i < C; i++) {
            red[i] = Integer.parseInt(br.readLine());
        }

        int[][] black = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            black[i][0] = Integer.parseInt(st.nextToken());
            black[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(red);
        Arrays.sort(black, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;
        int blackIdx = 0;

        for (int i = 0; i < C; i++) {
            int t = red[i];

            while (blackIdx < N && black[blackIdx][0] <= t) {
                pq.offer(black[blackIdx][1]);
                blackIdx++;
            }

            while (!pq.isEmpty() && pq.peek() < t) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                answer++;
            }
        }

        System.out.print(answer);
    }
}