import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static boolean isIrony = false;

    private static int[] opposite;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        opposite = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (opposite[a] == 0) opposite[a] = b;
            else {
                int pa = find(a), pb = find(b);

                if (pa == pb) {
                    System.out.print(0);
                    isIrony = true;
                    break;
                }

                union(opposite[a], b);
            }

            if (opposite[b] == 0) opposite[b] = a;
            else {
                int pa = find(a), pb = find(b);

                if (pa == pb) {
                    System.out.print(0);
                    isIrony = true;
                    break;
                }

                union(opposite[b], a);
            }
        }

        if (!isIrony) System.out.print(1);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        parent[pb] = pa;
    }
}