import java.io.*;
import java.util.*;

public class Main {

    private static class Spot implements Comparable<Spot> {
        int x, y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override 
        public int compareTo(Spot other) {
            if (this.x == other.x) 
                return Integer.compare(this.y, other.y);
            else
                return Integer.compare(this.x, other.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Spot> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            set.add(new Spot(x, y));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Spot spot = set.ceiling(new Spot(x, y));

            if (spot == null) 
                answer.append(-1 + " " + -1 + "\n");
            else 
                answer.append(spot.x + " " + spot.y + "\n");
        }

        System.out.print(answer);
    }
}