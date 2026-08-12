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

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lines[b].add(new Line(a, v));
        }

        int[] dists = new int[N + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[N] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        pq.offer(new int[]{N, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (current[1] > dists[current[0]]) {
                continue;
            }

            for (Line line : lines[current[0]]) {
                if (dists[line.to] > current[1] + line.value) {
                    pq.offer(new int[]{line.to, current[1] + line.value});
                    dists[line.to] = current[1] + line.value;
                }
            }
        }

        int answer = 0;

        for (int i = 1; i < N; i++) {
            answer = Math.max(answer, dists[i]);
        }

        System.out.print(answer);
    }
}