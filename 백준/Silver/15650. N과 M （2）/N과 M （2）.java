import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static StringBuilder answer;

    private static void numberOrders(StringBuilder now, int size, int start) {
        if (size == M) {
            answer.append(now.toString()).append("\n");
            return;
        }

        for (int i=start; i<=N; i++) {
            now.append(i).append(" ");
            numberOrders(now, size + 1, i + 1);
            now.setLength(size * 2);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new StringBuilder();
    }

    private static void process() {
        numberOrders(new StringBuilder(), 0, 1);
        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
