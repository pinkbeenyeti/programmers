import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] baskets;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        baskets = new int[N + 1];

        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            for (int j=start; j<=end; j++) {
                baskets[j] = number;
            }
        }
    }

    private static void process() {
        StringBuilder answer = new StringBuilder();
        
        for (int i=1; i<=N; i++) {
            answer.append(baskets[i]).append(" ");
        }
        
        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
