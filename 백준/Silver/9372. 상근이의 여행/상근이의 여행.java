import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder answer = new StringBuilder();

    private static void minTree(List<Integer>[] link, int N) {
        boolean[] visited = new boolean[N + 1];
        int count = 0;

        for (int i=1; i<=N; i++) {
            if (visited[i]) continue;

            Queue<Integer> qu = new LinkedList<>();
            qu.offer(i);

            visited[i] = true;

            while (!qu.isEmpty()) {
                int curr = qu.poll();

                for (int next : link[curr]) {
                    if (visited[next]) continue;
                    else {
                        visited[next] = true;
                        count++;
                        qu.offer(next);
                    }
                }
            }
        }

        answer.append(count).append("\n");
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            List<Integer>[] link = new List[N + 1];

            for (int j=1; j<=N; j++) {
                link[j] = new LinkedList<>();
            }

            for (int j=0; j<M; j++) {
                st = new StringTokenizer(br.readLine());

                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                link[node1].add(node2);
                link[node2].add(node1);
            }

            minTree(link, N);
        }

        System.out.print(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
