import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int N, M, K;
    private static long ANSWER = 0, count = -1;

    private static List<Line>[] lines;

    private static class Line implements Comparable<Line> {
        int to, value;

        public Line(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Line other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        lines = new List[N + 1];
        for (int i = 1; i <= N; i++) lines[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lines[a].add(new Line(b, v));
            lines[b].add(new Line(a, v));
        }

        PriorityQueue<Line> pq = new PriorityQueue<>();
        pq.offer(new Line(1, 0));

        boolean[] visited = new boolean[N + 1];
        visited[0] = true;

        while (!pq.isEmpty()) {
            Line current = pq.poll();

            if (visited[current.to]) continue;
            else {
                ANSWER += (count++ * K) + current.value;
                visited[current.to] = true;
            }

            for (Line line : lines[current.to]) {
                if (!visited[line.to]) {
                    pq.offer(line);
                }
            }
        }

        System.out.print(ANSWER + K);
    }
}