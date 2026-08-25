import java.io.*;
import java.util.*;

public class Main {

    private static final long INF = Long.MAX_VALUE;

    private static class Info implements Comparable<Info> {
        int to;
        long totalCost, time;

        public Info(int to, long cost, long time) {
            this.to = to;
            this.totalCost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(Info other) {
            if (this.totalCost != other.totalCost) {
                return Long.compare(this.totalCost, other.totalCost);
            }
            return Long.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[][] minFare = new long[1001][1001];
        long[][] minTime = new long[1001][1001];

        for (int i = 1; i <= 1000; i++) {
            Arrays.fill(minFare[i], INF);
            Arrays.fill(minTime[i], INF);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long fare = Long.parseLong(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] route = new int[count];
            for (int j = 0; j < count; j++) {
                route[j] = Integer.parseInt(st.nextToken());
            }

            for (int u = 0; u < count; u++) {
                int from = route[u];
                for (int v = u + 1; v < count; v++) {
                    int to = route[v];
                    long time = v - u;

                    if (fare < minFare[from][to]) {
                        minFare[from][to] = fare;
                        minTime[from][to] = time;
                    } else if (fare == minFare[from][to] && time < minTime[from][to]) {
                        minTime[from][to] = time;
                    }
                }
            }
        }

        long[] dists = new long[1001];
        long[] times = new long[1001];

        Arrays.fill(dists, INF);
        Arrays.fill(times, INF);

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(A, 0, 0));

        dists[A] = 0;
        times[A] = 0;

        while (!pq.isEmpty()) {
            Info current = pq.poll();
            int u = current.to;

            if (current.totalCost > dists[u]) continue;
            if (current.totalCost == dists[u] && current.time > times[u]) continue;

            for (int v = 1; v <= 1000; v++) {
                if (minFare[u][v] == INF) continue;

                long nextCost = current.totalCost + minFare[u][v];
                long nextTime = current.time + minTime[u][v];

                boolean update = false;

                if (nextCost < dists[v]) {
                    update = true;
                } else if (nextCost == dists[v] && nextTime < times[v]) {
                    update = true;
                }

                if (update) {
                    dists[v] = nextCost;
                    times[v] = nextTime;
                    pq.offer(new Info(v, nextCost, nextTime));
                }
            }
        }

        if (dists[B] == INF) {
            System.out.print("-1 -1");
        } else {
            System.out.print(dists[B] + " " + times[B]);
        }
    }
}