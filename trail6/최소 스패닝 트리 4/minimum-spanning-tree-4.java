import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int N, M;
    private static int answer = 0, count = 0;

    private static boolean[] types;
    private static int[] parent;

    private static List<Line> list;

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

        types = new boolean[N + 1];
        parent = new int[N + 1];

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            String tp = st.nextToken();
            types[i] = tp.equals("a") ? false : true;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new Line(a, b, v));
        }

        Collections.sort(list, (a, b) -> {
            return Integer.compare(a.v, b.v);
        });

        for (int i = 0; i < list.size(); i++) {
            Line line = list.get(i);

            if (types[line.a] == types[line.b]) {
                continue;
            }

            if (union(line.a, line.b)) {
                answer += line.v;
                count++;
            }
        }

        if (count == N - 1) System.out.print(answer);
        else System.out.print(-1);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
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
