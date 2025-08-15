import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] cardPrices = new int[1001];
    static int[] maxPrices = new int[1001];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            cardPrices[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        maxPrices[1] = cardPrices[1];

        for (int i=2; i<=N; i++) {
            for (int j=1; j<=i; j++) {
                maxPrices[i] = Math.max(maxPrices[i], cardPrices[j] + maxPrices[i - j]);
            }
        }

        System.out.println(maxPrices[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
