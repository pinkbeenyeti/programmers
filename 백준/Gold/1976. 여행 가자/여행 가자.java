import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] parent, destination;

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

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        destination = new int[M];

        for (int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=1; j<=N; j++) {
                int number = Integer.parseInt(st.nextToken());

                if (number != 0) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++) {
            destination[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        boolean canTravel = true;

        for (int i=0; i<(M - 1); i++) {
            if (find(destination[i]) != find(destination[i + 1])) {
                canTravel = false;
                break;
            }
        }

        if (canTravel) System.out.print("YES");
        else System.out.print("NO");
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
