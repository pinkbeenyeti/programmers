import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, K;
    static long[] drinks;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        drinks = new long[N];

        for (int i=0; i<N; i++) {
            drinks[i] = scanner.nextLong();
        }

        Arrays.sort(drinks);
    }

    static boolean canDivide(long a) {
        long answer = 0;

        for (long drink : drinks) {
            answer += drink / a;
        }

        return answer >= K;
    }

    static void process() {
        long L = 1, R = drinks[N - 1];

        while (L <= R) {
            long mid = (L + R) / 2;

            if (canDivide(mid)) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(R);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
