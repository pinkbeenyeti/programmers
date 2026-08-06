import java.io.*;
import java.util.*;

public class Main {

    private static List<Line>[] tree;
    private static StringBuilder answer = new StringBuilder();

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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree[a].add(new Line(b, c));
            tree[b].add(new Line(a, c));
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N + 1];
            visited[a] = true;

            find(a, b, 0, visited);
        }

        System.out.print(answer);
    }

    private static boolean find(int current, int goal, int value, boolean[] visited) {
        if (current == goal) {
            answer.append(value).append("\n");
            return true;
        }

        for (Line line : tree[current]) {
            if (visited[line.to]) {
                continue;
            }
            
            visited[line.to] = true;
            if (find(line.to, goal, value + line.cost, visited)) return true;
        }

        return false;
    }
}