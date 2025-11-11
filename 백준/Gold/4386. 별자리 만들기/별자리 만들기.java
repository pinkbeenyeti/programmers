import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static double answer = 0;

    private static double[][] stars;
    private static int[] parent;

    private static PriorityQueue<Edge> pq = new PriorityQueue<>();

    private static class Edge implements Comparable<Edge> {
        int from, to;
        double distance;

        public Edge(int from, int to, double distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.distance, other.distance);
        }
    }

    private static double getDistance(double[] a, double[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;
        else {
            parent[rootB] = rootA;
            return true;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        stars = new double[N][2];
        parent = new int[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars[i] = new double[]{x, y};
            parent[i] = i;
        }

        for (int i=0; i<N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                double dist = getDistance(stars[i], stars[j]);
                pq.offer(new Edge(i, j, dist));
            }
        }
    }

    private static void process() {
        int edgeCount = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (edgeCount == N - 1) {
                break;
            }

            if (union(current.from, current.to)) {
                answer += current.distance;
                edgeCount++;
            }
        }

        System.out.print(String.format("%.2f", answer));
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
