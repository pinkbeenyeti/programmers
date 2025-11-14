import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int T;

    private static int[] parent;
    private static int[] count;

    private static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]); // 경로 압축
    }

    private static int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return count[rootA];
        else {
            parent[rootB] = rootA;
            count[rootA] += count[rootB];

            return count[rootA];
        }
    }

    // 5. process 메서드 구조는 그대로 유지
    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<T; i++) {
            int F = Integer.parseInt(br.readLine());

            parent = new int[F * 2];
            count = new int[F * 2];

            Map<String, Integer> nameToId = new HashMap<>();
            int idCounter = 0; // 새 ID 발급용

            for (int j=0; j<F; j++) {
                st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                if (!nameToId.containsKey(a)) {
                    nameToId.put(a, idCounter); // 새 ID 발급
                    parent[idCounter] = idCounter; // makeSet (parent)
                    count[idCounter] = 1;      // makeSet (count)
                    idCounter++;
                }

                if (!nameToId.containsKey(b)) {
                    nameToId.put(b, idCounter);
                    parent[idCounter] = idCounter;
                    count[idCounter] = 1;
                    idCounter++;
                }

                int idA = nameToId.get(a);
                int idB = nameToId.get(b);

                sb.append(union(idA, idB)).append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}