import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static int N, V;
    private static int[] numbers;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[201];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) numbers[Integer.parseInt(input[i]) + 100]++;

        V = Integer.parseInt(br.readLine());
    }

    private static void process() {
        System.out.print(numbers[V + 100]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
