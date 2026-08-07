import java.io.*;
import java.util.*;

public class Main {

    private static int targetNode, targetHeight, targetParent, targetGrandParent;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer>[] tree = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        int parent = 0;
        int prev = Integer.parseInt(st.nextToken());

        if (prev == K) targetNode = 1;

        for (int i = 2; i <= N; i++) {
            int current = Integer.parseInt(st.nextToken());
            if (current == K) targetNode = i;

            if ((prev + 1) != current) {
                parent++;
            }

            tree[parent].add(i);
            prev = current;
        }

        findTarget(1, 0, 0, 0, tree);

        if (targetGrandParent != 0) {
            findCousin(1, 0, 0, 0, tree);
        }

        System.out.print(answer);
    }

    private static void findTarget(int node, int parent, int grandParent, int height, List<Integer>[] tree) {
        if (targetNode == node) {
            targetHeight = height;
            targetParent = parent;
            targetGrandParent = grandParent;
            return;
        }

        for (int kid : tree[node]) {
            findTarget(kid, node, parent, height + 1, tree);
        }
    }

    private static void findCousin(int node, int parent, int grandParent, int height, List<Integer>[] tree) {
        if (height == targetHeight) {
            if (grandParent == targetGrandParent && parent != targetParent) {
                answer++;
            }
            return;
        }

        for (int kid : tree[node]) {
            findCousin(kid, node, parent, height + 1, tree);
        }
    }
}