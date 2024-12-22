import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int T, N, M;
    static int[] A, B;
    static Scanner scanner = new Scanner(System.in);
    static StringBuilder answer;

    static void input() {
        T = scanner.nextInt();
        answer = new StringBuilder();

        for (int i=0; i<T; i++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            get_array();
            process();
        }

        System.out.println(answer);
    }

    static void get_array() {
        A = new int[N];
        B = new int[M];

        for (int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i=0; i<M; i++) {
            B[i] = scanner.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);
    }

    static void process() {
        int count = 0;

        for (int i=0; i<N; i++) {
            count += binary_search(A[i]);
        }

        answer.append(count).append('\n');
    }

    static int binary_search(int value) {
        int L = 0;
        int R = M - 1;
        int result = 0;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (B[mid] < value) {
                result = mid + 1;
                L = mid + 1;
            } else if (B[mid] >= value) {
                R = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        input();
    }
}
