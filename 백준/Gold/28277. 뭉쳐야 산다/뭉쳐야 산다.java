import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static int N, Q;
    private static Set<Integer>[] sets;

    private static void union(int a, int b) {
        if (sets[a].size() >= sets[b].size()) {
            sets[a].addAll(sets[b]);
            sets[b].clear();
        } else {
            sets[b].addAll(sets[a]);
            sets[a] = sets[b];
            sets[b] = new HashSet<>();
        }
    }

    private static void print(int x) {
        System.out.println(sets[x].size());
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        sets = new Set[N + 1];

        for (int i=1; i<=N; i++) {
            sets[i] = new HashSet<>();
        }

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            for (int j=1; j<=count; j++) {
                sets[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i=1; i<=Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            else print(Integer.parseInt(st.nextToken()));
        }

    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
