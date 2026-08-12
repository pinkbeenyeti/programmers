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
        int K = Integer.parseInt(br.readLine());

        List<Line>[] lines = new List[N + 1];
        
        for (int i = 1; i <= N; i++) {
            lines[i] = new ArrayList<>();
        }

        int[] dists = new int[N + 1];

        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[K] = 0;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lines[a].add(new Line(b, v));
            lines[b].add(new Line(a, v));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        pq.offer(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (current[1] > dists[current[0]]) {
                continue;
            }

            for (Line line : lines[current[0]]) {
                if (dists[line.to] > line.value + current[1]) {
                    pq.offer(new int[]{line.to, line.value + current[1]});
                    dists[line.to] = line.value + current[1];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            answer.append(dists[i] == Integer.MAX_VALUE ? -1 : dists[i]).append("\n");
        }

        System.out.print(answer);
    }
}