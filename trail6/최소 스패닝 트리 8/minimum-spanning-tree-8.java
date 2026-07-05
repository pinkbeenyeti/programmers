import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, ANSWER = 0;
    private static List<Line>[] nodes;

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

        nodes = new List[N + 1];
        for (int i = 1; i <= N; i++) nodes[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[a].add(new Line(b, v));
            nodes[b].add(new Line(a, v));
        }

        PriorityQueue<Line> pq = new PriorityQueue<>();
        pq.offer(new Line(1, 0));

        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Line current = pq.poll();

            if (visited[current.to]) continue;
            else { visited[current.to] = true; ANSWER += current.value; }

            for (Line line : nodes[current.to]) {
                if (!visited[line.to]) {
                    pq.offer(new Line(line.to, line.value));
                }
            }
        }
        
        System.out.print(ANSWER);
    }
}