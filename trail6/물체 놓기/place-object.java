import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int ANSWER = 0;
    private static int[][] near;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        near = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            near[0][i] = cost;
            near[i][0] = cost;
        }

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                near[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{0, 0});

        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int cost = current[1];

            if (visited[u]) continue;
            
            visited[u] = true;
            ANSWER += cost;

            for (int v = 0; v <= N; v++) {
                // 자기 자신 제외 및 방문하지 않은 정점 중 연결된 곳 탐색
                if (!visited[v] && u != v) {
                    pq.offer(new int[]{v, near[u][v]});
                }
            }
        }

        System.out.print(ANSWER);
    }
}