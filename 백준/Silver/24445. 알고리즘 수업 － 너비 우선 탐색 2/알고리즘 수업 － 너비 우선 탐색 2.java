import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder answer = new StringBuilder();
    private static int N, M, R, index = 1;

    private static List<Integer>[] link;
    private static boolean[] visited;
    private static int[] orders;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        link = new List[N + 1];
        visited = new boolean[N + 1];
        orders = new int[N + 1];

        for (int i=1; i<=N; i++) {
            link[i] = new LinkedList<>();
        }

        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            link[n1].add(n2);
            link[n2].add(n1);
        }

        for (int i=1; i<=N; i++) {
            link[i].sort(Collections.reverseOrder());
        }
    }

    private static void process() {
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{-1, R});

        visited[R] = true;
        orders[R] = index;

        while (!qu.isEmpty()) {
            int[] curr = qu.poll();

            for (int next : link[curr[1]]) {
                if (next == curr[0] || visited[next]) continue;

                visited[next] = true;
                orders[next] = ++index;

                qu.offer(new int[]{curr[1], next});
            }
        }

        for (int i=1; i<=N; i++) {
            answer.append(orders[i]).append("\n");
        }

        System.out.print(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
