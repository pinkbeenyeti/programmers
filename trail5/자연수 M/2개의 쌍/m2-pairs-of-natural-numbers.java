import java.util.*;
import java.io.*;

public class Main {

    private static class Info {
        int count, number;

        public Info(int c, int num) {
            count = c;
            number = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<Info> infos = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            infos.add(new Info(count, number));
        }

        Collections.sort(infos, (a, b) -> {
            return Integer.compare(a.number, b.number);
        });

        int l = 0, r = N - 1;
        int answer = 0;

        while (l <= r) {
            Info left = infos.get(l);
            Info right = infos.get(r);

            if (left.count < right.count) {
                right.count -= left.count;
                l++;
            }
            else if (left.count == right.count) {
                l++;
                r--;
            }
            else {
                left.count -= right.count;
                r--;
            }

            answer = Math.max(answer, left.number + right.number);
        }

        System.out.print(answer);
    }
}