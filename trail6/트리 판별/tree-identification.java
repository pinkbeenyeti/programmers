import java.util.*;
import java.io.*;

public class Main {

    private static Set<Integer> set;
    private static List<Integer>[] tree;
    private static int[] inDegree;

    private static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        tree = new List[20000];
        inDegree = new int[20000];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            set.add(a);
            set.add(b);

            if (tree[a] == null) tree[a] = new ArrayList<>();
            if (tree[b] == null) tree[b] = new ArrayList<>();

            tree[a].add(b);
            inDegree[b]++;
        }

        int rootCount = 0;
        int root = 0;

        for (int i = 1; i <= 10000; i++) {
            if (tree[i] == null) {
                continue;
            }

            if (inDegree[i] == 0) {
                rootCount++;
                root = i;
            }

            if (inDegree[i] > 1 || rootCount > 1) {
                System.out.print(0);
                return;
            }
        }

        dfs(root);
        
        if (count == set.size()) System.out.print(1);
        else System.out.print(0);
    }

    private static void dfs(int current) {
        if (tree[current] == null) {
            return;
        }

        for (int next : tree[current]) {
            count++;
            dfs(next);
        }
    }

}