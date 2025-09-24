import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    private static int N, K, P;
    private static String X;
    private static int[][] transformed;


    private static class Info {
        StringBuilder number;
        int limit;

        public Info(StringBuilder number, int limit) {
            this.number = number;
            this.limit = limit;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = st.nextToken();

        transformed = new int[10][10];
    }

    private static void preProcess() {
        String[] segments = {
            "1110111",
            "0010010",
            "1011101",
            "1011011",
            "0111010",
            "1101011",
            "1101111",
            "1010010",
            "1111111",
            "1111011"
        };

        for (int original=0; original<=9; original++) {
            for (int comapare=0; comapare<=9; comapare++) {
                if (original == comapare) continue;

                int count = 0;
                for (int i=0; i<7; i++) {
                    if (segments[original].charAt(i) != segments[comapare].charAt(i)) count++;
                }
                transformed[original][comapare] = count;
            }
        }

        X = String.format("%0" + K + "d", Integer.parseInt(X));
    }

    private static void process() {
        int answer = 0;

        for (int i=1; i<=N; i++) {
            int target = i;
            int totalCost = 0;

            for (int j=K-1; j>=0; j--) {
                int original = X.charAt(j) - '0', compare = target % 10;
                target /= 10;
                totalCost += transformed[original][compare];
            }

            if (totalCost > 0 && totalCost <= P) answer++;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        preProcess();
        process();
    }
}
