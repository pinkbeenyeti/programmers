import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

    private static int N, M;

    private static int[] parent;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        count = new int[N + 1];

        for (int i = 1; i <= N; i++) parent[i] = i;
        for (int i = 1; i <= N; i++) count[i] = 1;
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            
            if (command.equals("x")) union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            else answer.append(count[find(Integer.parseInt(st.nextToken()))]).append("\n");

        }

        System.out.print(answer);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int pa = find(parent[a]), pb = find(parent[b]);
        int ca = count[pa], cb = count[pb];

        if (pa != pb) {
            count[pa] += cb;
            count[pb] += ca;
        }

        parent[pa] = pb;
    }
}