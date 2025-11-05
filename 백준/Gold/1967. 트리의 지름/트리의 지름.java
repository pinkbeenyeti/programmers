import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, START = 0, ANSWER = 0;
    private static List<Info>[] tree;

    private static class Info {
        int node, cost;

        public Info(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new List[N + 1];

        for (int i=0; i<=N; i++) {
            tree[i] = new LinkedList<>();
        }

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[node1].add(new Info(node2, cost));
            tree[node2].add(new Info(node1, cost));
        }
    }

    private static void dfs(int prev, int current, int currentCost) {
        for (Info info : tree[current]) {
            if (info.node == prev) continue;
            dfs(current, info.node, currentCost + info.cost);
        }

        if (currentCost > ANSWER) {
            START = current;
            ANSWER = currentCost;
        }
    }

    private static void process() {
        dfs(0, 1, 0);
        dfs(0, START, 0);

        System.out.print(ANSWER);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
