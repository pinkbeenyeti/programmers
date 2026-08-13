import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int A, B, C;
    private static int answer = 0;

    private static List<Line>[] lines;

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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        lines = new List[N + 1];

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

        int[] aDist = new int[N + 1];
        int[] bDist = new int[N + 1];
        int[] cDist = new int[N + 1];

        dks(A, aDist);
        dks(B, bDist);
        dks(C, cDist);

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, Math.min(aDist[i], Math.min(bDist[i], cDist[i])));
        }

        System.out.print(answer);
    }

    private static void dks(int start, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> {
            return Integer.compare(i[1], j[1]);
        });
        pq.offer(new int[]{start, 0});

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (dist[current[0]] > current[1]) {
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