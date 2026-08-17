import java.io.*;
import java.util.*;

public class Main {

    private static class Range1 implements Comparable<Range1> {
        int l, r;

        public Range1(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Range1 other) {
            return Integer.compare(this.r, other.r);
        }
    }

    private static class Range2 implements Comparable<Range2> {
        int l, r, length;

        public Range2(int l, int r) {
            this.l = l;
            this.r = r;
            this.length = r - l + 1;
        }

        @Override
        public int compareTo(Range2 other) {
            if (this.length == other.length) return Integer.compare(this.r, other.r);
            return Integer.compare(this.length, other.length);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Range1> set1 = new TreeSet<>();
        TreeSet<Range2> set2 = new TreeSet<>();

        set1.add(new Range1(0, N));
        set2.add(new Range2(0, N));

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());

            Range1 range1 = set1.ceiling(new Range1(x, x));
            Range1 lRange1 = new Range1(range1.l, x - 1);
            Range1 rRange1 = new Range1(x + 1, range1.r);

            Range2 range2 = set2.ceiling(new Range2(range1.l, range1.r));
            Range2 lRange2 = new Range2(range2.l, x - 1);
            Range2 rRange2 = new Range2(x + 1, range2.r);

            set1.remove(range1);
            set2.remove(range2);

            if (lRange1.l < lRange1.r) {
                set1.add(lRange1);
                set2.add(lRange2);
            }

            if (rRange1.l < rRange1.r) {
                set1.add(rRange1);
                set2.add(rRange2);
            }

            answer.append(set2.last().length).append("\n");
        }

        System.out.print(answer);
    }
}