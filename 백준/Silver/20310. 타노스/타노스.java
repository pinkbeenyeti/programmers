import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static StringBuilder answer = new StringBuilder();
    private static char[] chars;
    private static String S;

    private static class Number implements Comparable<Number> {
        char value;
        int index;

        public Number(char value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Number other) {
            if (this.value == '0') {
                return other.index - this.index;
            }

            return this.index - other.index;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        chars = new char[501];
    }

    private static void process() {
        PriorityQueue<Number> zeros = new PriorityQueue<>();
        PriorityQueue<Number> ones = new PriorityQueue<>();

        for (int i=0; i<S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '0') {
                zeros.offer(new Number(ch, i));
            } else {
                ones.offer(new Number(ch, i));
            }
        }

        int zeroSize = zeros.size(), oneSize = ones.size();

        for (int i=1; i<=(zeroSize/2); i++) {
            zeros.poll();
        }


        for (int i=1; i<=(oneSize/2); i++) {
            ones.poll();
        }

        while (!zeros.isEmpty()) {
            Number zero = zeros.poll();
            chars[zero.index] = '0';
        }

        while (!ones.isEmpty()) {
            Number one = ones.poll();
            chars[one.index] = '1';
        }

        for (int i=0; i<501; i++) {
            if (chars[i] == '0') answer.append("0");
            else if (chars[i] == '1') answer.append("1");
        }

        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
