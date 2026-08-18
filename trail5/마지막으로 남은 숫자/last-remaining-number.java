import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            if (a != b) {
                pq.offer(Math.abs(a - b));
            }
        }

        System.out.print(pq.isEmpty() ? -1 : pq.poll());
    }
}