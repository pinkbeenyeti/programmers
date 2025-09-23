import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, C;
    private static long answer, totalValue = 0;
    private static int W = 0, H = 100_000, count = 0;

    private static List<Stone>[] X, Y;

    private static class Stone {
        int x, y, value;

        public Stone(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        X = new List[100_001];
        Y = new List[100_001];

        for (int i=0; i<=100_000; i++) {
            X[i] = new ArrayList<>();
            Y[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            X[x].add(new Stone(x, y, value));
            Y[y].add(new Stone(x, y, value));
        }
    }

    private static void del() {
        for (Stone stone : Y[H]) {
            if (stone.x <= W) {
                count--;
                totalValue -= stone.value;
            }
        }

        H--;
    }

    private static void add() {
        for (Stone stone : X[W]) {
            if (stone.y <= H) {
                count++;
                totalValue += stone.value;
            }
        }

        W++;
    }

    private static void process() {
        while (W <= 100_000 && H >= 0) {
            if (count > C) del();
            else add();

            if (count <= C) {
                answer = Math.max(answer, totalValue);
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
