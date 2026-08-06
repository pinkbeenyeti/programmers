import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        Map<Long, Long> countMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            countMap.put(num, countMap.getOrDefault(num, 0L) + 1L);
        }

        List<Long> unique = new ArrayList<>(countMap.keySet());
        Collections.sort(unique);

        long answer = 0;
        int size = unique.size();

        for (int i = 0; i < size; i++) {
            long a = unique.get(i);
            long cntA = countMap.get(a);

            for (int j = i; j < size; j++) {
                long b = unique.get(j);
                long cntB = countMap.get(b);
                long c = K - a - b;

                if (c < b) continue;
                if (!countMap.containsKey(c)) continue;

                long cntC = countMap.get(c);

                if (a == b && b == c) {
                    if (cntA >= 3) {
                        answer += cntA * (cntA - 1) * (cntA - 2) / 6;
                    }
                } else if (a == b && b < c) {
                    if (cntA >= 2) {
                        answer += (cntA * (cntA - 1) / 2) * cntC;
                    }
                } else if (a < b && b == c) {
                    if (cntB >= 2) {
                        answer += cntA * (cntB * (cntB - 1) / 2);
                    }
                } else if (a < b && b < c) {
                    answer += cntA * cntB * cntC;
                }
            }
        }

        System.out.print(answer);
    }
}