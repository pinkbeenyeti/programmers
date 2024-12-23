import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] budgets;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        budgets = new int[N];

        for (int i=0; i<N; i++) {
            budgets[i] = scanner.nextInt();
        }

        M = scanner.nextInt();
        Arrays.sort(budgets);
    }

    static boolean verify_budget(int money) {
        int total = 0;

        for (int budget : budgets) {
            total += Math.min(budget, money);
        }

        return total <= M;
    }

    static void process() {
        int L = 0, R = budgets[N - 1], answer = 0;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (verify_budget(mid)) {
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
