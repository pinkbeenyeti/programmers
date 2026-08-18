import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int command = Integer.parseInt(br.readLine());

            if (command != 0) pq.offer(command);
            else {
                if (pq.isEmpty()) answer.append(0);
                else answer.append(pq.poll());
                answer.append("\n");
            }
        }

        System.out.print(answer);
    }
}