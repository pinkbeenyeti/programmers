import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) pq.offer(Integer.parseInt(st.nextToken()));

        int answer = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            answer += (a + b);
            pq.offer(a + b);
        }

        System.out.print(answer);
    }
}