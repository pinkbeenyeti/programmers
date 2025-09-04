import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    private static int[] dp;
    private static int N, R, Q;
    private static List<Integer>[] nearList;
    private static Queue<Integer> query = new LinkedList<>();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        nearList = new List[N+1];
        for (int i=1; i<=N; i++) nearList[i] = new ArrayList<>();

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()), node2 = Integer.parseInt(st.nextToken());

            nearList[node1].add(node2);
            nearList[node2].add(node1);
        }

        for (int i=1; i<=Q; i++) {
            st = new StringTokenizer(br.readLine());
            query.offer(Integer.parseInt(st.nextToken()));
        }
    }

    private static void dfs(int node, int prev) {
        dp[node] = 1;

        for (int kid : nearList[node]) {
            if (kid == prev) continue;

            dfs(kid, node);
            dp[node] += dp[kid];
        }
    }

    private static void process() {
        dfs(R, 0);

        while (!query.isEmpty()) {
            System.out.println(dp[query.poll()]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
