import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int N, answer = 0;

    private static List<Dot> xDots;
    private static List<Dot> yDots;
    private static List<Dot> zDots;
    private static List<Line> lines;

    private static int[] parent;

    private static class Dot {
        int index, value;

        public Dot(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

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

        xDots = new ArrayList<>();
        yDots = new ArrayList<>();
        zDots = new ArrayList<>();
        lines = new ArrayList<>();

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            xDots.add(new Dot(i, x));
            yDots.add(new Dot(i, y));
            zDots.add(new Dot(i, z));
        }

        Collections.sort(xDots, (a, b) -> {
            return Integer.compare(a.value, b.value);
        });

        Collections.sort(yDots, (a, b) -> {
            return Integer.compare(a.value, b.value);
        });

        Collections.sort(zDots, (a, b) -> {
            return Integer.compare(a.value, b.value);
        });

        for (int i = 1; i < N; i++) {
            Dot xDot1 = xDots.get(i - 1), xDot2 = xDots.get(i);
            Dot yDot1 = yDots.get(i - 1), yDot2 = yDots.get(i);
            Dot zDot1 = zDots.get(i - 1), zDot2 = zDots.get(i);

            lines.add(new Line(xDot1.index, xDot2.index, Math.abs(xDot1.value - xDot2.value)));
            lines.add(new Line(yDot1.index, yDot2.index, Math.abs(yDot1.value - yDot2.value)));
            lines.add(new Line(zDot1.index, zDot2.index, Math.abs(zDot1.value - zDot2.value)));
        }

        Collections.sort(lines, (a, b) -> {
            return Integer.compare(a.v, b.v);
        });

        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);

            if (union(line.a, line.b)) {
                answer += line.v;
            }
        }

        System.out.print(answer);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        int pa = find(a), pb = find(b);

        if (pa == pb) return false;

        parent[pb] = pa;
        return true;
    }
}