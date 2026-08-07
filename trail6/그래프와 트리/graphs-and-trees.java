import java.io.*;
import java.util.*;

public class Main {

    private static int[] parent;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i; 
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        for (int i = 1; i <= N; i++) {
            int root = find(i);

            if (root != 0 && !visited[root]) {
                visited[root] = true;
                answer++;
            }
        }

        System.out.print(answer);
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        
        if (pa == pb) {
            parent[pa] = 0;
        }

        if (pa != pb) {
            parent[Math.max(pa, pb)] = Math.min(pa, pb);
        }
    }
}