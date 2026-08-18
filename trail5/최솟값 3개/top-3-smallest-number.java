import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));

            if (pq.size() >= 3) {
                long a = pq.poll();
                long b = pq.poll();
                long c = pq.poll();

                answer.append(a * b * c).append("\n");

                pq.offer(a);
                pq.offer(b);
                pq.offer(c);
            }
            else {
                answer.append(-1).append("\n");
            }
        }

        System.out.print(answer);
    }
}