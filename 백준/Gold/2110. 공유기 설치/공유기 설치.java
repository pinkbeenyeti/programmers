import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, C;
    static int[] routers;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        C = scanner.nextInt();
        routers = new int[N];

        for (int i=0; i<N; i++) {
            routers[i] = scanner.nextInt();
        }

        Arrays.sort(routers);
    }

    static boolean get_distance(int mid) {
        int count = 1, last = routers[0];

        for (int i=1; i<N; i++) {
            if (routers[i] - last >= mid) {
                last = routers[i];
                count++;
            }
        }

        return count >= C;
    }

    static void process() {
        int L = 1, R = 1000000000, answer = 0;

        while(L <= R) {
            int mid = (L + R) / 2;

            if (get_distance(mid)) {
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
