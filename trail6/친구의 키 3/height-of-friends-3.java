import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        List<Integer>[] lines = new List[N + 1];
        int[] degrees = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            lines[i] = new ArrayList<>();
        }

        PriorityQueue<Integer> qu = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines[a].add(b);
            degrees[b]++;
        }

        for (int i = 1; i <= N; i++) {
            if (degrees[i] == 0) {
                visited[i] = true;
                qu.offer(i);
            }
        }

        while (!qu.isEmpty()) {
            int current = qu.poll();

            answer.append(current).append(" ");
            count++;

            for (int next : lines[current]) {
                if (degrees[next] == 1 && !visited[next]) {
                    visited[next] = true;
                    qu.offer(next);
                }
                degrees[next]--;
            }
        }

        if (count == N) System.out.print(answer);
        else System.out.print(-1);
    }
}