import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;
    private static StringBuilder answer = new StringBuilder();

    private static void getProfit(int N) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] stocks = new int[N + 1];
        long result = 0;

        for (int i=1; i<=N; i++) {
            stocks[i] = Integer.parseInt(st.nextToken());
        }

        int maxPrice = stocks[N];
        for (int i=N-1; i>0; i--) {
            if (maxPrice >= stocks[i]) {
                result += (maxPrice - stocks[i]);
            } else {
                maxPrice = stocks[i];
            }
        }

        answer.append(result).append("\n");
    }

    private static void process() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=1; i<=T; i++) {
            int N = Integer.parseInt(br.readLine());

            getProfit(N);
        }

        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
