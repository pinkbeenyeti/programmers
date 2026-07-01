import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static double answer = 0;

    private static int[] parent;
    private static long[][] spots;

    private static List<Line> list;

    private static class Line {
        int a, b;
        long v;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
            getValue();
        }

        private void getValue() {
            long xx = (spots[a][0] - spots[b][0]) * (spots[a][0] - spots[b][0]);
            long yy = (spots[a][1] - spots[b][1]) * (spots[a][1] - spots[b][1]);
            this.v = xx + yy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        spots = new long[N + 1][2];

        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            spots[i][0] = x;
            spots[i][1] = y;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                list.add(new Line(i, j));
            }
        }

        Collections.sort(list, (a, b) -> {
            return Long.compare(a.v, b.v);
        });

        for (int i = 0; i < list.size(); i++) {
            Line line = list.get(i);

            if (union(line.a, line.b)) {
                answer += Math.sqrt(line.v);
            }
        }

        System.out.print(String.format("%.2f", answer));
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