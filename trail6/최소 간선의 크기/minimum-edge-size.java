import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int N, M;
    private static int A, B;
    private static int answer = Integer.MAX_VALUE;

    private static int[] parent;
    private static int[] values;

    private static List<Line> lines;

    private static class Line {
        int a, b, v;

        public Line(int a, int b, int v) {
            this.a = a;
            this.b = b;
            this.v = v;
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

        parent = new int[N + 1];
        values = new int[N + 1];

        lines = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lines.add(new Line(a, b, v));
        }

        Collections.sort(lines, (a, b) -> {
            return Integer.compare(b.v, a.v);
        });

        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);

            union(line.a, line.b);

            if (find(A) == find(B)) {
                System.out.print(line.v);
                break;
            }
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        parent[pb] = pa;
    }
}