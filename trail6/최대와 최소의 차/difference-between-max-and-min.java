import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int count, min, max;

    private static List<Line> lines;
    private static int[] parent;

    private static class Line {
        int a, b, t;

        public Line(int a, int b, int t) {
            this.a = a;
            this.b = b;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lines = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            lines.add(new Line(a, b, t));
        }

        Collections.sort(lines, (a, b) -> {return Integer.compare(b.t, a.t);});
        count = 0;

        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);

            if (union(line.a, line.b) && line.t == 0) {
                count++;
            }   
        }

        Collections.sort(lines, (a, b) -> {return Integer.compare(a.t, b.t);});
        min = count * count;
        count = 0;

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);

            if (union(line.a, line.b) && line.t == 0) {
                count++;
            }
        }

        max = count * count;
        System.out.print(Math.abs(max - min));
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