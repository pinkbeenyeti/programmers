import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer>[] tree;
    private static boolean[] visited;

    private static int orderCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        tree = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        findLeaf(1, 0);

        if (orderCount % 2 == 0) System.out.print(0);
        else System.out.print(1);
    }

    private static void findLeaf(int current, int height) {
        visited[current] = true;

        boolean isLeaf = true;

        for (int next : tree[current]) {
            if (!visited[next]) {
                findLeaf(next, height + 1);
                isLeaf = false;
            }
        }

        if (isLeaf) {
            orderCount += height;
        }
    }
}