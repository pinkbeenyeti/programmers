import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static List<Integer> merged;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        merged = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            merged.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=M; i++) {
            merged.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static void process() {
        Collections.sort(merged);
        StringBuilder sb = new StringBuilder();

        for (int number : merged) {
            sb.append(number).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
