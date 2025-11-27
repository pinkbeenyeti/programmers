import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static int N, Q;
    private static int[][] queries;

    private static int[] parent;
    private static int[] root;

    private static Set<Integer>[] colorSet;
    private static boolean[] isCut;

    private static int find(int x) {
        if (root[x] == x) return x;
        return root[x] = find(root[x]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        if (colorSet[rootA].size() < colorSet[rootB].size()) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        colorSet[rootA].addAll(colorSet[rootB]);
        colorSet[rootB].clear();
        colorSet[rootB] = null;

        root[rootB] = rootA;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        root = new int[N + 1];
        colorSet = new HashSet[N + 1];
        isCut = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            parent[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            root[i] = i;
            colorSet[i] = new HashSet<>();
            colorSet[i].add(Integer.parseInt(br.readLine()));
        }

        queries = new int[N + Q - 1][2];
        for (int i = 0; i < N + Q - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());

            queries[i][0] = type;
            queries[i][1] = node;

            if (type == 1) {
                isCut[node] = true;
            }
        }
    }

    private static void process() {
        Stack<Integer> answerStack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            if (!isCut[i]) union(i, parent[i]);
        }

        for (int i = N + Q - 2; i >= 0; i--) {
            int type = queries[i][0];
            int node = queries[i][1];

            if (type == 1) union(node, parent[node]);
            else {
                int rootNode = find(node);
                answerStack.push(colorSet[rootNode].size());
            }
        }

        while (!answerStack.isEmpty()) {
            answer.append(answerStack.pop()).append("\n");
        }

        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}