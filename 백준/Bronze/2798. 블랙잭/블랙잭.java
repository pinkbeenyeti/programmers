import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, value = Integer.MIN_VALUE;
    private static int[] cards;

    public static void preProcess() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void process() {
        for (int i=1; i<=(N-2); i++) {
            for (int j=(i+1); j<=(N-1); j++) {
                for (int k=(j+1); k<=(N); k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum <= M && sum > value) {
                        value = sum;
                    }
                }
            }
        }

        System.out.print(value);
    }

    public static void main(String[] args) throws IOException {
        preProcess();
        process();
    }
}
