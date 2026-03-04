import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] count;

    public static void preProcess() {
        count = new int[5001];
        count[1] = 1;

        for (int i=2; i<=5000; i++) {
            count[i] = count[i - 1] + i;
        }
    }

    public static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int order = Integer.parseInt(br.readLine());

        for (int i=1; i<=5000; i++) {
            if (count[i] < order) {
                continue;
            }

            int a = order - count[i - 1];
            int b = (i + 1) - a;

            if (i % 2 == 0) System.out.print(a + "/" + b);
            else System.out.print(b + "/" + a);

            break;
        }
    }

    public static void main(String[] args) throws IOException {
        preProcess();
        process();
    }
}
