import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static ArrayList<Integer>[] linkedList;
    static int[] parents;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        linkedList = new ArrayList[N+1];
        parents = new int[N+1];
        scanner.nextLine();

        for (int i=1; i<=N; i++) {
            linkedList[i] = new ArrayList<>();
        }

        for (int i=1; i<N; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            linkedList[a].add(b);
            linkedList[b].add(a);
            scanner.nextLine();
        }
    }

    static void process() {
        for (int kid : linkedList[1]) {
            dfs(kid, 1);
        }

        for (int i=2; i<=N; i++) {
            System.out.println(parents[i]);
        }
    }

    static void dfs(int kid, int parent) {
        parents[kid] = parent;

        for (int k : linkedList[kid]) {
            if (k == 1 || parents[k] != 0) continue;
            dfs(k, kid);
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
