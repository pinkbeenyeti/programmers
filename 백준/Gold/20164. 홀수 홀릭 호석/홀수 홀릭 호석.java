import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static String N;
    private static int maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;
    private static Queue<Odd> qu = new LinkedList<>();

    private static class Odd {
        String number;
        int count;

        public Odd(String number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        qu.offer(new Odd(N, countOdd(N)));
    }

    private static void process() {
        while (!qu.isEmpty()) {
            if (qu.peek().number.length() > 2) splitThree(qu.poll());
            else if (qu.peek().number.length() == 2) splitTwo(qu.poll());
            else {
                Odd odd = qu.poll();
                maxNum = Math.max(maxNum, odd.count);
                minNum = Math.min(minNum, odd.count);
            }
        }

        System.out.print(minNum + " " + maxNum);
    }

    private static void splitThree(Odd odd) {
        for (int i = 1; i <= odd.number.length() - 2; i++) {
            for (int j = i + 1; j <= odd.number.length() - 1; j++) {
                int x1 = Integer.parseInt(odd.number.substring(0, i));
                int x2 = Integer.parseInt(odd.number.substring(i, j));
                int x3 = Integer.parseInt(odd.number.substring(j, odd.number.length()));

                String result = Integer.toString(x1 + x2 + x3);
                qu.offer(new Odd(result, odd.count + countOdd(result)));
            }
        }
    }

    private static void splitTwo(Odd odd) {
        String trans = Integer.toString(odd.number.charAt(0) + odd.number.charAt(1) - '0' - '0');
        qu.offer(new Odd(trans, odd.count + countOdd(trans)));
    }

    private static int countOdd(String number) {
        int count = 0;

        for (int i=0; i<number.length(); i++) {
            if ((number.charAt(i) - '0') % 2 != 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
