import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                int target = Integer.parseInt(st.nextToken());

                if (pq.isEmpty()) pq.offer(target);
                else if (pq.size() < N) pq.offer(target);
                else if (pq.peek() < target) {
                    pq.poll();
                    pq.offer(target);
                }
            }
        }
        
        System.out.print(pq.poll());
    }
}
