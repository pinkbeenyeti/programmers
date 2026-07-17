import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] degrees = new int[N + 1];
        int[] dp = new int[N + 1];
        dp[1] = 1;

        List<Integer>[] lines = new List[N + 1];
        for (int i = 1; i <= N; i++) lines[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines[a].add(b);
            degrees[b]++;
        }

        Queue<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= N; i++) if (degrees[i] == 0) qu.offer(i);
        
        while(!qu.isEmpty()) {
            int node = qu.poll();

            for (int next : lines[node]) {
                if (degrees[next] == 1) {
                    qu.offer(next);
                }
                dp[next] = (dp[next] + dp[node]) % 1_000_000_007;
                degrees[next]--;
            }
        }


        System.out.print(dp[N]);
    }
}