import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N;
    static ArrayList<Integer>[] spots;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        spots = new ArrayList[N+1];

        for (int color=1; color<=N; color++) {
            spots[color] = new ArrayList<Integer>();
        }

        for (int i=1; i<=N; i++) {
            int location = scanner.nextInt();
            int color = scanner.nextInt();

            spots[color].add(location);
        }
    }

    static void sort_spot() {
        for (int color=1; color<=N; color++) {
            Collections.sort(spots[color]);
        }
    }

    static void get_distance() {
        int answer = 0;

        for (int color=1; color<=N; color++) {
            for (int i=0; i<spots[color].size(); i++) {
                int ld = get_left(color, i);
                int rd = get_right(color, i);
                answer += Math.min(ld, rd);
            }
        }

        System.out.println(answer);
    }

    static int get_left(int color, int index) {
        if (index == 0) return Integer.MAX_VALUE;

        return spots[color].get(index) - spots[color].get(index-1);
    }

    static int get_right(int color, int index) {
        if (index+1 == spots[color].size()) return Integer.MAX_VALUE;

        return spots[color].get(index+1) - spots[color].get(index);
    }

    public static void main(String[] args) {
        input();
        sort_spot();
        get_distance();
    }
}
