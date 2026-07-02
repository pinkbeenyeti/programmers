import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

    private static StringBuilder answer;
    private static int N, M;

    private static int[] parent;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        parent = new int[100_005];
        count = new int[100_005];

        for (int i = 1; i <= 100_004; i++) {
            parent[i] = i;
            count[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        System.out.print(answer);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int pa = find(a), pb = find(b);

        if (pa == pb) {
            answer.append(count[pa]).append("\n");
            return;
        }

        parent[pb] = pa;
        count[pa] += count[pb];

        answer.append(count[pa]).append("\n");
    }
}