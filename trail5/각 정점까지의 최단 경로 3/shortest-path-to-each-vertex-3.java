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
        StringBuilder answer = new StringBuilder();

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
        }

        int[] dists = new int[N + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        dists[1] = 0;
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > dists[u]) continue;

            for (Line line : lines[u]) {
                if (dists[line.to] > dists[u] + line.value) {
                    dists[line.to] = dists[u] + line.value;
                    pq.offer(new int[]{line.to, dists[line.to]});
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (dists[i] == Integer.MAX_VALUE) {
                answer.append(-1).append("\n");
            } else {
                answer.append(dists[i]).append("\n");
            }
        }

        System.out.print(answer);
    }
}