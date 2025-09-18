import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, A, B, C;

    private static List<Edge>[] nearList;
    private static int[] dists;

    private static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class Info implements Comparable<Info> {
        int to, value;

        public Info(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Info other) {
            return this.value - other.value;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        nearList = new List[N + 1];

        for (int i=1; i<=N; i++) {
            nearList[i] = new ArrayList<>();
        }

        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken()), node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nearList[node1].add(new Edge(node2, cost));
            nearList[node2].add(new Edge(node1, cost));
        }
    }

    private static void process() {
        for (int limit=1; limit<=20; limit++) {
            if (dijkstra(limit)) {
                System.out.println(limit);
                return;
            }
        }

        System.out.println(-1);
    }

    private static boolean dijkstra(int limit) {
        dists = new int[N + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[A] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(A, 0));

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (info.value > dists[info.to]) {
                continue;
            }

            for (Edge edge : nearList[info.to]) {
                if (edge.cost > limit) continue;
                if (dists[info.to] + edge.cost > C) continue;
                if (dists[edge.to] > dists[info.to] + edge.cost) {
                    dists[edge.to] = dists[info.to] + edge.cost;
                    pq.offer(new Info(edge.to, dists[edge.to]));
                }
            }
        }

        return dists[B] != Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
