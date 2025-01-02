import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] lights;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        lights = new int[M];

        for (int i=0; i<M; i++) {
            lights[i] = scanner.nextInt();
        }
    }

    static boolean canLight(int height) {
        int L = 0;

        for (int light : lights) {
            if ((light - height) <= L) {
                L = light + height;
            } else {
                return false;
            }
        }

        return L >= N;
    }

    static void process() {
        int L = 1, R = N;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (canLight(mid)) {
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
