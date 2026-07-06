import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int N, M, K;
    private static int ANSWER = 0, count = 0;

    private static PriorityQueue<Line> pq;
    private static boolean[] visited;
    private static List<Line>[] lines;

    private static class Line implements Comparable<Line> {
        int to, value;
        boolean open;

        public Line(int to, int value, boolean open) {
            this.to = to;
            this.value = value;
            this.open = open;
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

        pq = new PriorityQueue<>();
        visited = new boolean[N + 1]; 
        lines = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            lines[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            lines[i].add(new Line(N, value, true));
            lines[N].add(new Line(i, value, true));

            lines[i].add(new Line((i + 1) % N, 0, true));
            lines[i].add(new Line((i - 1 + N) % N, 0, true));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            for (Line line : lines[a]) {
                if (line.to == b) line.open = false;
            }
            for (Line line : lines[b]) {
                if (line.to == a) line.open = false;
            }
        }

        pq.offer(new Line(0, 0, true));

        while (!pq.isEmpty()) {
            Line current = pq.poll();

            if (count == N) {
                break;
            }

            if (current.to != N && visited[current.to]) {
                continue;
            }
            

            visited[current.to] = true;
            ANSWER += current.value;
            count++;

            for (Line line : lines[current.to]) {
                if (!line.open) continue;
                if (visited[line.to]) continue;
                pq.offer(line);
            }
        }

        if (ANSWER <= K) System.out.print(1);
        else System.out.print(0);
    }
}