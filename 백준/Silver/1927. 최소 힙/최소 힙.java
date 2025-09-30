import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=1; i<=N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                if (pq.size() == 0) answer.append("0\n");
                else answer.append(pq.poll()).append("\n");
            } else {
                pq.offer(number);
            }
        }

        System.out.print(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
