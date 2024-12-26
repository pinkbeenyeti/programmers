import java.util.Scanner;

public class Main {
    static int N, M;
    static int L, R;
    static int[] balance;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        balance = new int[N];
        R = 0;  // 초기화

        for (int i = 0; i < N; i++) {
            balance[i] = scanner.nextInt();
            R += balance[i];
            L = Math.max(L, balance[i]);
        }
    }

    static boolean determination(int mid) {
        int sum = mid, count = 1;

        for (int money : balance) {
            if (sum < money) {
                count++;
                sum = mid;
            }
            sum -= money;
        }

        return count <= M;
    }

    static void process() {
        while (L <= R) {
            int mid = (L + R) / 2;

            if (determination(mid)) {
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
