import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] dp;
    private static int[] values;
    private static List<Integer>[] nearList;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        dp = new int[2][N+1];
        values = new int[N+1];
        nearList = new List[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            nearList[i] = new ArrayList<>();
        }

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()), node2 = Integer.parseInt(st.nextToken());

            nearList[node1].add(node2);
            nearList[node2].add(node1);
        }
    }

    private static void dfs(int node, int prev) {
        dp[0][node] = 0;
        dp[1][node] = values[node];

        for (int child : nearList[node]) {
            if (child == prev) continue;

            dfs(child, node);
            dp[0][node] += Math.max(dp[0][child], dp[1][child]);
            dp[1][node] += dp[0][child];
        }
    }

    private static void process() {
        dfs(1, 0);
        System.out.println(Math.max(dp[0][1], dp[1][1]));
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

}
