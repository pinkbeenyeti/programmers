import java.util.Scanner;

public class Main {
    static int N, K;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
    }

    static boolean canIndex(long index) {
        long count = 0;

        for (int i=1; i<=N; i++) {
            count += Math.min(index / i, N);
        }

        return count >= K;
    }

    static void process() {
        long L = 1, R = (long) N * N;

        while (L <= R) {
            long mid = (L + R) / 2;

            if (canIndex(mid)) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(L);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
