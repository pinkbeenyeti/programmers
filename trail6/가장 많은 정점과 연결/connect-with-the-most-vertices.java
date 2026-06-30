import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static int N, M, K;
    private static int ANSWER = 0;

    private static int[] parent;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());

        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) set.add(find(i));
        
        if (set.size() == 1) {
            System.out.print(0);
            return;
        }

        List<Integer> rootCosts = new ArrayList<>();
        for (int s : set) rootCosts.add(numbers[s]);
        Collections.sort(rootCosts);

        int globalMin = rootCosts.get(0);
        for (int i = 1; i < rootCosts.size(); i++) ANSWER += (globalMin + rootCosts.get(i));

        if (ANSWER <= K) System.out.print(ANSWER);
        else System.out.print("NO");
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int pa = find(a), pb = find(b);

        if (pa != pb) {
            if (numbers[pa] >= numbers[pb]) parent[pa] = pb;
            else parent[pb] = pa;
        }
    }
}