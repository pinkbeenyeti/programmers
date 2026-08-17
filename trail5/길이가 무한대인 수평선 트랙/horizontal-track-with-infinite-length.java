import java.io.*;
import java.util.*;

public class Main {

    private static class Runner {
        long p, s; // p: 출발 위치, s: 속력

        public Runner(long p, long s) {
            this.p = p;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());

        Runner[] runners = new Runner[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            long p = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());

            runners[i] = new Runner(p, s);
        }

        Arrays.sort(runners, (a, b) -> Long.compare(b.p, a.p));

        int groupCount = 1;
        long lastGroupEnd = runners[0].p + runners[0].s * T;

        for (int i = 1; i < N; i++) {
            long curEnd = runners[i].p + runners[i].s * T;

            if (curEnd < lastGroupEnd) {
                groupCount++;
                lastGroupEnd = curEnd;
            }
        }

        System.out.println(groupCount);
    }
}