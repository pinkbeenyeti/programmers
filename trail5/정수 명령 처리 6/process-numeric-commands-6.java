import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("push")) 
                pq.offer(Integer.parseInt(st.nextToken()));
            else if (command.equals("pop"))
                answer.append(pq.poll()).append("\n");
            else if (command.equals("size"))
                answer.append(pq.size()).append("\n");
            else if (command.equals("empty"))
                answer.append(pq.isEmpty() ? 1 : 0).append("\n");
            else
                answer.append(pq.peek()).append("\n");
        }

        System.out.print(answer);
    }
}