import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] selected;
    static StringBuilder answer = new StringBuilder();

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        selected = new int[M + 1];
    }

    static void list_num(int k) {
        if (k == M+1) {
            for (int i = 1; i <= M; i++) {
                answer.append(selected[i]).append(' ');
            }
            answer.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {
                boolean isUsed = false;
                for (int index = 1; index < k; index++) {
                    if (cand == selected[index]) {
                        isUsed = true;
                        break;
                    }
                }
                if (!isUsed) {
                    selected[k] = cand;
                    list_num(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String args[]) {
        input();
        list_num(1);
        System.out.println(answer);
    }
}
