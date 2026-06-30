import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static int N, M, K;

    private static int[] parent;
    private static int[] count;

    private static List<Integer> values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        count = new int[N + 1];
        for (int i = 1; i <= N; i++) count[i] = 1;

        values = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int rootA = find(A);
        int rootB = find(B);

        Set<Integer> set = new HashSet<>();
        set.add(parent[rootA]);

        for (int i = 1; i <= N; i++) {
            int rootI = find(i);

            if (rootI != rootB && !set.contains(rootI)) {
                values.add(count[rootI]);
                set.add(rootI);
            }
        }

        Collections.sort(values, Collections.reverseOrder());
        int answer = count[find(A)];

        for (int i = 0; i < K; i++) {
            if (i >= values.size()) break;
            else answer += values.get(i);
        }

        System.out.print(answer);
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int pa = find(a), pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
            count[pa] += count[pb]; 
        }
    }
}