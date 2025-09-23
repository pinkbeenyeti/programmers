import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static List<Integer>[] graph;
    private static int[][] dists;

    private static class Info implements Comparable<Info> {
        int nowNode, totalDistance;

        public Info(int nowNode, int totalDistance) {
            this.nowNode = nowNode;
            this.totalDistance = totalDistance;
        }

        @Override
        public int compareTo(Info other) {
            return this.totalDistance - other.totalDistance;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        dists = new int[N + 1][N + 1];

        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()), node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }
    }

    private static void process() {
        preProcess();

        int count = Integer.MAX_VALUE, node1 = 0, node2 = 0;

        for (int i=1; i<N; i++) {
            for (int j=i+1; j<=N; j++) {
                int nowCount = calculateChicken(i, j);

                if (count > nowCount) {
                    count = nowCount;
                    node1 = i;
                    node2 = j;
                }
            }
        }

        System.out.println(node1 + " " + node2 + " " + (count * 2));
    }

    private static void preProcess() {
        for (int[] row : dists) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int root=1; root<=N; root++) {
            dists[root][root] = 0;
            dists[root][0] = 0;

            PriorityQueue<Info> pq = new PriorityQueue<>();
            pq.offer(new Info(root, 0));

            while (!pq.isEmpty()) {
                Info info = pq.poll();

                if (info.totalDistance > dists[root][info.nowNode]) continue;

                for (int toNode : graph[info.nowNode]) {
                    if (dists[root][toNode] > info.totalDistance + 1) {
                        dists[root][toNode] = info.totalDistance + 1;
                        pq.offer(new Info(toNode, dists[root][toNode]));
                    }
                }
            }
        }
    }

    private static int calculateChicken(int node1, int node2) {
        int result = 0;

        for (int node=1; node<=N; node++) {
            int toNode1 = dists[node][node1], toNode2 = dists[node][node2];
            result += Math.min(toNode1, toNode2);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
