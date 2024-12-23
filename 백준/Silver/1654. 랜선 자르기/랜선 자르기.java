import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, K, H;
    static int[] lines;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        K = scanner.nextInt();
        N = scanner.nextInt();
        lines = new int[K];

        for (int i=0; i<K; i++) {
            lines[i] = scanner.nextInt();
        }

        Arrays.sort(lines);
        H = lines[K - 1];
    }

    static boolean determine(long length) {
        long sum = 0;

        for (int i=0; i<K; i++) {
            long count = lines[i] / length;
            sum += count;
        }

        return sum >= N;
    }

    static void process() {
        long L = 1, R = H, answer = 0;

        while (L <= R) {
            long mid = (L + R) / 2;

            if (determine(mid)) {
                answer = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
