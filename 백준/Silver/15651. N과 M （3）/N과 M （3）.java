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

    static void list_number(int k) {
        if (k == M + 1) {
            for(int ans = 1; ans <= M; ans++) {
                answer.append(selected[ans]).append(' ');
            }
            answer.append('\n');
            } else {
                for (int cand = 1; cand <= N; cand++) {
                    selected[k] = cand;
                    list_number(k+1);
                    selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        list_number(1);
        System.out.println(answer);
    }
}
