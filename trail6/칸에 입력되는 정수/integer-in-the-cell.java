import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    private static int N, M, answer = 0;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            int root = find(target);

            if (root == 0) break;
            
            parent[root] -= 1;
            answer++;
        }

        System.out.print(answer);
    }

    private static int find(int target) {
        if (target == parent[target]) return target;
        return parent[target] = find(parent[target]);
    }
}