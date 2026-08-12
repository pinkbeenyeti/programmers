import java.io.*;
import java.util.*;

public class Main {

    private static class Line {
        int to, value;

        public Line(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Line>[] lines = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            lines[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lines[a].add(new Line(b, v));
            lines[b].add(new Line(a, v));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dists = new int[N + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> Integer.compare(i[1], j[1]));

        dists[end] = 0;
        pq.offer(new int[]{end, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > dists[u]) continue;

            for (Line line : lines[u]) {
                if (dists[line.to] > d + line.value) {
                    dists[line.to] = d + line.value;
                    pq.offer(new int[]{line.to, dists[line.to]});
                }
            }
        }

        System.out.println(dists[start]);

        StringBuilder sb = new StringBuilder();
        int curr = start;

        while (curr != end) {
            sb.append(curr).append(" ");

            int minNextNode = Integer.MAX_VALUE;

            for (Line line : lines[curr]) {
                int next = line.to;
                int weight = line.value;

                if (dists[next] != Integer.MAX_VALUE && dists[curr] == dists[next] + weight) {
                    if (next < minNextNode) {
                        minNextNode = next;
                    }
                }
            }
            curr = minNextNode;
        }
        sb.append(end);

        System.out.println(sb.toString());
    }
}