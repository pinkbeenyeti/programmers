import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            if (target == 0) {
                if (pq.isEmpty()) {
                    answer.append("0\n");
                }
                else {
                    answer.append(pq.poll()).append("\n");
                }
            }

            if (target != 0) {
                pq.offer(target);
            }
        }

        System.out.print(answer);
    }
}