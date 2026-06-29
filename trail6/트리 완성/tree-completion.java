import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Set;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, ANSWER = 0;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            find(i);
            set.add(parent[i]);
        }

        System.out.print(set.size() - 1 + ANSWER);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int a, int b) {
        int pa = find(a), pb = find(b);

        if (pa == pb) ANSWER++;
        else parent[pb] = pa;
    }
}