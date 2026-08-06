import java.io.*;
import java.util.*;

public class Main {

    private static int N, answer = 0;
    private static int start, end;

    private static List<Line>[] tree;

    private static class Line {
        int to, cost;

        public Line(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree[a].add(new Line(b, c));
            tree[b].add(new Line(a, c));
        }

        dfs(1, 0, new boolean[N + 1]);
        start = end;
        dfs(start, 0, new boolean[N + 1]);

        System.out.print(answer);
    }

    private static void dfs(int current, int value, boolean[] visited) {
        if (value > answer) {
            answer = value;
            end = current;
        }

        for (Line line : tree[current]) {
            if (visited[line.to]) continue;
            visited[line.to] = true;
            dfs(line.to, value + line.cost, visited);
        }
    }
}