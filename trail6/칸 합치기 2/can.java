import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int count;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = N;

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int root = find(a);
            int current = find(b);

            while (current > 0 && current != root) {
                int next = find(current - 1);

                parent[current] = root;
                count--;

                current = next;
            }

            answer.append(count).append("\n");
        }

        System.out.print(answer);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
}