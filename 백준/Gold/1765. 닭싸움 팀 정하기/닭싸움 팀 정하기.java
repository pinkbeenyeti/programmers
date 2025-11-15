import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] parent;
    private static List<Integer>[] enemy;

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

    private static void preProcess() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        enemy = new List[N + 1];

        for (int i=1; i<=N; i++) {
            parent[i] = i;
            enemy[i] = new LinkedList<>();
        }

        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command.equals("E")) {
                enemy[a].add(b);
                enemy[b].add(a);
            }

            if (command.equals("F")) {
                union(a, b);
            }
        }
    }

    private static void process() {
        for (int i=1; i<=N; i++) {
            for (int j=0; j<(enemy[i].size() - 1); j++) {
                union(enemy[i].get(j), enemy[i].get(j + 1));
            }
        }

        Set<Integer> set = new HashSet<>();
        int answer = 0;

        for (int i=1; i<=N; i++) {
            int root = find(i);

            if (!set.contains(root)) {
                answer++;
                set.add(root);
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        preProcess();
        process();
    }
}
