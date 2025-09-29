import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static PriorityQueue<Country> pq;

    private static class Country implements Comparable<Country> {
        int country;
        int gold, silver, bronze;

        public Country(int country, int gold, int silver, int bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country other) {
            if (this.gold != other.gold) return other.gold - this.gold;
            if (this.silver != other.silver) return other.silver - this.silver;

            return other.bronze - this.bronze;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken()), silver = Integer.parseInt(st.nextToken()), bronze = Integer.parseInt(st.nextToken());

            pq.offer(new Country(country, gold, silver, bronze));
        }
    }

    private static void process() {
        int rank = 0, count = 0;
        int gold = -1, silver = -1, bronze = -1;

        while (!pq.isEmpty()) {
            Country current = pq.poll();
            count++;

            if (gold != current.gold || silver != current.silver || bronze != current.bronze) {
                gold = current.gold;
                silver = current.silver;
                bronze = current.bronze;
                rank = count;
            }

            if (current.country == K) {
                System.out.println(rank);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
