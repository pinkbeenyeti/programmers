import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int ANSWER = 0, count = 0;

    private static List<Line> lines;
    private static int[] parent;

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
        count = N;

        lines = new ArrayList<>();
        parent = new int[N + 1];

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

        Collections.sort(lines, (a, b) -> { return Integer.compare(a.v, b.v); });

        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);

            if (union(line.a, line.b)) {
                ANSWER += line.v;
                count--;
            }

            if (count == 1) {
                ANSWER -= line.v;
                break;
            }
        }

        System.out.print(ANSWER);
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        int pa = find(a), pb = find(b);

        if (pa == pb) {
            return false;
        }

        parent[pb] = pa;
        return true;
    }
}