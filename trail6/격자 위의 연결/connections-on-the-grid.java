import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int answer = 0;

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

        parent = new int[N * M];
        list = new ArrayList<>();

        for (int i = 0; i < (N * M); i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < (M - 1); j++) {
                int v = Integer.parseInt(st.nextToken());
                list.add(new Line(i * M + j, i * M + j + 1, v));
            }
        }

        for (int i = 0; i < (N - 1); i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                list.add(new Line(i * M + j, (i + 1) * M + j, v));
            }
        }

        Collections.sort(list, (a, b) -> {
            if (a.v != b.v) return a.v - b.v;
            return a.a - b.a;
        });

        for (int i = 0; i < list.size(); i++) {
            Line line = list.get(i);

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