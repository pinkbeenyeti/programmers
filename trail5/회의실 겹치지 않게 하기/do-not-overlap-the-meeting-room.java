import java.util.*;
import java.io.*;

public class Main {

    private static class Time {
        int start, end;

        public Time(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Time[] times = new Time[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(times, (a, b) -> {
            return Integer.compare(a.end, b.end);
        });

        int current = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (current <= times[i].start) {
                current = times[i].end;
                answer++;
            }
        }

        System.out.print(N - answer);
    }
}