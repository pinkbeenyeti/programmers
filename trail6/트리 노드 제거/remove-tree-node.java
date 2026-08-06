import java.util.*;
import java.io.*;

public class Main {

    private static List<Integer>[] tree;
    private static int answer = 0, root = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        tree = new List[N];
        for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            int j = Integer.parseInt(st.nextToken());

            if (j == -1) {
                root = i;
                continue;
            }

            tree[i].add(j);
            tree[j].add(i);
        }

        int remove = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[N];
        visited[root] = true;

        findLeaf(root, remove, visited);

        System.out.print(answer);
    }

    private static void findLeaf(int current, int remove, boolean[] visited) {

        if (current == remove) {
            return;
        }

        boolean isLeaf = true;

        for (int to : tree[current]) {
            if (to == remove || visited[to]) continue;

            isLeaf = false;
            visited[to] = true;
            findLeaf(to, remove, visited);
        }

        if (isLeaf && current != root) {
            answer++;
        }
    }
}