import java.util.Scanner;

public class Main {
    static int N, M;
    static long[] trees;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        trees = new long[N];

        for (int i=0; i<N; i++) {
            trees[i] = scanner.nextLong();
        }
    }

    static boolean get_height(int height) {
        long sum = 0;

        for (int i=0; i<N; i++) {
            if (trees[i] > height) {
                sum += trees[i] - height;
            }
        }

        return sum >= M;
    }

    static void process() {
        int L = 0, R = 2000000000;
        long answer = 0;

        while(L <= R) {
            int mid = (L + R) / 2;

            if (get_height(mid)) {
                L = mid + 1;
                answer = mid;
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
