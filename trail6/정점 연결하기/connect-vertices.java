import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        
        for (int i = 0; i < (N - 2); i++) {
            st = new StringTokenizer(br.readLine());

            int[] values = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            Arrays.sort(values);

            union(values[0], values[1]);
        }

        Set<Integer> nodes = new TreeSet<>();
        for (int i = 1; i <= N; i++) nodes.add(find(parent[i]));

        for(int node : nodes) answer.append(node).append(" ");
        System.out.print(answer);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int pa = find(a), pb = find(b);

        if (pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
    }
}