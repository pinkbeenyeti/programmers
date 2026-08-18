import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> min = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (max.size() <= min.size()) 
                    max.offer(num);
                else
                    min.offer(num);

                if (!min.isEmpty() && min.peek() < max.peek()) {
                    int minRoot = min.poll();
                    int maxRoot = max.poll();

                    min.offer(maxRoot);
                    max.offer(minRoot);
                }

                if (j % 2 == 0) {
                    answer.append(max.peek()).append(" ");
                }
            }

            answer.append("\n");
        }

        System.out.print(answer);
    }
}