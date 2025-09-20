import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, START, END;
    private static List<Edge>[] map;
    private static int[] dist;

    private static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class Info implements Comparable<Info> {
        int node, totalCost;

        public Info(int node, int toatlCost) {
            this.node = node;
            this.totalCost = toatlCost;
        }

        @Override
        public int compareTo(Info other) {
            return this.totalCost - other.totalCost;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new List[N + 1];
        dist = new int[N + 1];

        for (int i=1; i<=N; i++) {
            map[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken()), node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[node1].add(new Edge(node2, cost));
        }

        st = new StringTokenizer(br.readLine());
        START = Integer.parseInt(st.nextToken());
        END = Integer.parseInt(st.nextToken());
    }

    private static void process() {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(START, 0));
        dist[START] = 0;

        while (!pq.isEmpty()) {
            Info current = pq.poll();

            if (current.totalCost > dist[current.node]) {
                continue;
            }

            for (Edge edge : map[current.node]) {
                if (dist[edge.to] > current.totalCost + edge.cost) {
                    dist[edge.to] = current.totalCost + edge.cost;
                    pq.offer(new Info(edge.to, dist[edge.to]));
                }
            }
        }

        System.out.println(dist[END]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
