import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> qu = new LinkedList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    qu.offer(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    answer.append((qu.isEmpty()) ? -1 : qu.poll()).append("\n");
                    break;

                case "size":
                    answer.append(qu.size()).append("\n");
                    break;

                case "empty":
                    answer.append((qu.isEmpty()) ? 1 : 0).append("\n");
                    break;

                case "front":
                    answer.append((qu.isEmpty()) ? -1 : qu.peekFirst()).append("\n");
                    break;

                case "back":
                    answer.append((qu.isEmpty()) ? -1 : qu.peekLast()).append("\n");
                    break;
            }
        }

        System.out.print(answer);
    }
}
