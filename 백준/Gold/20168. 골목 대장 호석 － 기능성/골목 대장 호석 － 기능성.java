import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, A, B, C;
    private static int minShame = Integer.MAX_VALUE;

    private static List<Integer>[] nearList;
    private static int[][] costs;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        nearList = new List[N + 1];
        costs = new int[N + 1][N + 1];

        for (int i=1; i<=N; i++) {
            nearList[i] = new ArrayList<>();
        }

        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken()), node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nearList[node1].add(node2);
            nearList[node2].add(node1);

            costs[node1][node2] = cost;
            costs[node2][node1] = cost;
        }
    }

    private static void process() {
        for (int linked: nearList[A]) {
            if (costs[A][linked] <= C) {
                dfs(A, linked, costs[A][linked], costs[A][linked]);
            }
        }

        if (minShame == Integer.MAX_VALUE) minShame = -1;
        System.out.println(minShame);
    }

    private static void dfs(int prev, int node, int cost, int shame) {
        if (shame >= minShame) return;
        
        if (node == B) {
            minShame = Math.min(minShame, shame);
            return;
        }

        for (int linked : nearList[node]) {
            if (linked == prev) continue;
            if (cost + costs[node][linked] > C) continue;

            dfs(node, linked, cost + costs[node][linked], Math.max(shame, costs[node][linked]));
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
