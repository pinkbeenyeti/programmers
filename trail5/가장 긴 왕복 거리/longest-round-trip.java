import java.io.*;
import java.util.*;

public class Main {

    private static int answer = 0;

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
        int S = Integer.parseInt(st.nextToken());

        List<Line>[] line1 = new List[N + 1];
        List<Line>[] line2 = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            line1[i] = new ArrayList<>();
            line2[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            line1[a].add(new Line(b, v));
            line2[b].add(new Line(a, v));
        }

        int[] dist1 = new int[N + 1];
        int[] dist2 = new int[N + 1];

        dks(S, line1, dist1);
        dks(S, line2, dist2);

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dist1[i] + dist2[i]);
        }

        System.out.print(answer);
    }

    private static void dks(int start, List<Line>[] lines, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        pq.offer(new int[]{start, 0});

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (current[1] > dist[current[0]]) {
                continue;
            }

            for (Line line : lines[current[0]]) {
                if (dist[line.to] > line.value + current[1]) {
                    dist[line.to] = line.value + current[1];
                    pq.offer(new int[]{line.to, line.value + current[1]});
                }
            }
        }
    }
}