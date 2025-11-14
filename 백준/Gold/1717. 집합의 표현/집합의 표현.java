import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] parent;

    private static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        int rootA = find(a), rootB = find(b);

        if (rootA == rootB) return false;
        else {
            parent[rootB] = rootA;
            return true;
        }
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        for (int i=0; i<=N; i++) {
            parent[i] = i;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) union(a, b);
            else {
                if (find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
