import java.util.*;
import java.io.*;

public class Main {

    private static class Info implements Comparable<Info> {
        int node, v;

        public Info(int node, int v) {
            this.node = node;
            this.v = v;
        }

        @Override
        public int compareTo(Info other) {
            return Integer.compare(this.v, other.v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        List<Info>[] lines = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            lines[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lines[a].add(new Info(b, v));
            lines[b].add(new Info(a, v));
        }

        int[] dists = new int[N + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[N] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>();
        for (Info info : lines[N]) {
            dists[info.node] = info.v;
            pq.offer(info);
        }

        while (!pq.isEmpty()) {
            Info current = pq.poll();

            for (Info next : lines[current.node]) {
                if (dists[next.node] <= current.v + next.v) {
                    continue;
                }

                dists[next.node] = current.v + next.v;
                pq.offer(new Info(next.node, current.v + next.v));
            }
        }

        for (int i = 1; i < N; i++) {
            answer = Math.max(answer, dists[i]);
        }

        System.out.print(answer);
    }
}