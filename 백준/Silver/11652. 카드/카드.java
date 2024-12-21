import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, cur_count, cur_max_count;
    static long cur_max_num;
    static long[] cards;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        cards = new long[N];

        for (int i=0; i<N; i++) {
            cards[i] = scanner.nextLong();
        }
    }

    static void cardSort() {
        Arrays.sort(cards, 0, N);

        cur_count = 1;
        cur_max_count = 1;
        cur_max_num = cards[0];

        for (int i=1; i<N; i++) {
            if (cards[i] == cards[i-1]) {
                cur_count++;
            } else {
                cur_count = 1;
            }
            if (cur_count > cur_max_count) {
                cur_max_count = cur_count;
                cur_max_num = cards[i];
            }
        }

        System.out.println(cur_max_num);
    }

    public static void main(String[] args) {
        input();
        cardSort();
    }
}
