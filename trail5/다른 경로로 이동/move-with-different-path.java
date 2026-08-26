import java.util.*;
import java.io.*;

public class Main {

    private static class Info implements Comparable<Info> {
        int node, cost;

        public Info(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] lines = new int[N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lines[a][b] = v;
            lines[b][a] = v;
        }

        int[] dists = new int[N  + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[N] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(N, 0));

        while (!pq.isEmpty()) {
            Info current = pq.poll();

            if (current.cost > dists[current.node]) continue;

            for (int next = 1; next <= N; next++) {
                int value = lines[current.node][next];

                if (value == 0 || dists[next] <= current.cost + value) {
                    continue;
                }

                dists[next] = current.cost + value;
                pq.offer(new Info(next, dists[next]));
            }
        }

        int curr = 1;
        int end = N;

        while (curr != end) {
            for (int next = 1; next <= N; next++) {
                int v = lines[curr][next];

                if (dists[next] != Integer.MAX_VALUE && v != 0 && dists[curr] == dists[next] + v) {
                    lines[curr][next] = 0;
                    lines[next][curr] = 0;
                    curr = next;
                    break;
                }
            }
        }

        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[N] = 0;

        pq = new PriorityQueue<>();
        pq.offer(new Info(N, 0));

        while (!pq.isEmpty()) {
            Info current = pq.poll();

            if (current.cost > dists[current.node]) continue;

            for (int next = 1; next <= N; next++) {
                int value = lines[current.node][next];

                if (value == 0 || dists[next] <= current.cost + value) {
                    continue;
                }

                dists[next] = current.cost + value;
                pq.offer(new Info(next, dists[next]));
            }
        }

        if (dists[1] == Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.print(dists[1]);
    }
}