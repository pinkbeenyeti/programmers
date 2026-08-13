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

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lines[a].add(new Line(b, v));
            lines[b].add(new Line(a, v));
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dists = new int[N + 1];
        int[] paths = new int[N + 1];

        Arrays.fill(dists, Integer.MAX_VALUE);
        Arrays.fill(paths, Integer.MAX_VALUE);

        dists[b] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> {
            return Integer.compare(i[1], j[1]);
        });
        pq.offer(new int[]{b, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (current[1] > dists[current[0]]) {
                continue;
            }

            for (Line line : lines[current[0]]) {
                if (dists[line.to] > line.value + current[1]) {
                    dists[line.to] = line.value + current[1];
                    paths[line.to] = current[0];
                    pq.offer(new int[]{line.to, line.value + current[1]});
                }

                if (dists[line.to] == line.value + current[1] && paths[line.to] > current[0]) {
                    paths[line.to] = current[0];
                }
            }
        }

        int x = a;
        answer.append(x);

        while (x != b) {
            x = paths[x];
            answer.append(" " + x);
        }

        System.out.println(dists[a]);
        System.out.print(answer);
    }
}