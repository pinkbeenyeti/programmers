import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] lists;
    static boolean[] visit;
    static StringBuilder answer;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();
        lists = new ArrayList[N+1];

        for (int i=1; i<=N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            int x = scanner.nextInt(), y = scanner.nextInt();
            lists[x].add(y);
            lists[y].add(x);
        }

        for (int i=1; i<=N; i++) {
            Collections.sort(lists[i]);
        }

        answer = new StringBuilder();
    }

    static void dfs(int v) {
        visit[v] = true;
        answer.append(v).append(' ');

        for (int x : lists[v]) {
            if (visit[x]) continue;
            dfs(x);
        }
    }

    static void bfs(int v) {
        Queue<Integer> qu = new LinkedList<>();

        visit[v] = true;
        qu.add(v);

        while (!qu.isEmpty()) {
            v = qu.poll();
            answer.append(v).append(' ');

            for (int x : lists[v]) {
                if (visit[x]) continue;

                qu.add(x);
                visit[x] = true;
            }
        }
    }

    static void init() {
        for(int i=1; i<=N; i++) {
            visit[i] = false;
        }
    }

    static void process() {
        visit = new boolean[N+1];

        dfs(V);
        answer.append('\n');
        init();
        bfs(V);

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
