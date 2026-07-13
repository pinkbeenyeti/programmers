import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
    
        List<Integer>[] link = new List[N + 1];
        for (int i = 1; i <= N; i++) link[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            link[a].add(b);
            link[b].add(a);
        }

        boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];

        dfs(1, link, visited, parent);

        for (int i = 2; i <= N; i++) {
            answer.append(parent[i]).append("\n");
        }

        System.out.print(answer);
    }

    private static void dfs(int currentNode, List<Integer>[] link, boolean[] visited, int[] parent) {
        for (int next : link[currentNode]) {
            if (!visited[next]) {
                parent[next] = currentNode;
                visited[next] = true;
                dfs(next, link, visited, parent);
            }
        }
    }
}