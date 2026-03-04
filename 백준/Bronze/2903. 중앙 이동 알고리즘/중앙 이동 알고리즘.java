import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static long[] lineCount = new long[16];
    private static long[] spotCount = new long[16];

    public static void preProcess() {
        lineCount[1] = 3;
        spotCount[1] = 9;

        for (int i=2; i<=15; i++) {
            lineCount[i] = lineCount[i - 1] * 2 -1;
        }

        for (int i=2; i<=15; i++) {
            spotCount[i] = ((int) Math.pow(2, i - 1)) * lineCount[i - 1] * 2 + ((int) Math.pow(4, i - 1));
            spotCount[i] += spotCount[i - 1];
        }
    }

    public static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(spotCount[Integer.parseInt(br.readLine())]);
    }

    public static void main(String[] args) throws IOException {
        preProcess();
        process();
    }
}
