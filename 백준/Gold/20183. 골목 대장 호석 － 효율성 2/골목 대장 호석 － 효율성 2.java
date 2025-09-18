import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, A, B;
    private static long C;

    private static List<Edge>[] village;

    private static class Edge {
        int to;
        long cost;

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class Info implements Comparable<Info>{
        int node;
        long totalCost;

        public Info(int node, long totalCost) {
            this.node = node;
            this.totalCost = totalCost;
        }

        @Override
        public int compareTo(Info other) {
            return Long.compare(this.totalCost, other.totalCost);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        village = new List[N + 1];

        for (int i=1; i<=N; i++) {
            village[i] = new ArrayList<>();
        }

        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken()), node2 = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            village[node1].add(new Edge(node2, cost));
            village[node2].add(new Edge(node1, cost));
        }
    }

    private static void process() {
        long left = 1, right = 1_000_000_001;
        long ans = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (dijkstra(mid)) {
                ans = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        System.out.println(ans);
    }

    private static boolean dijkstra(long limit) {
        long[] dists = new long[N + 1];
        Arrays.fill(dists, Long.MAX_VALUE);
        dists[A] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(A, 0));

        while (!pq.isEmpty()) {
            Info current = pq.poll();

            if (current.totalCost > dists[current.node]) {
                continue;
            }

            for (Edge edge : village[current.node]) {
                if (edge.cost > limit) continue;
                if (dists[current.node] + edge.cost > C) continue;
                if (dists[edge.to] > dists[current.node] + edge.cost) {
                    dists[edge.to] = dists[current.node] + edge.cost;
                    pq.offer(new Info(edge.to, dists[edge.to]));
                }
            }
        }

        return dists[B] != Long.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
