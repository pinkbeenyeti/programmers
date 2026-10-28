import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] people = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(people);

        int l = 0, r = 1_000_000_000;
        int answer = r;

        while (l <= r) {
            int mid = (l + r) / 2;

            int busCount = 1;
            int currentPeople = 1;
            int currentMintime = people[0];

            for (int i = 1; i < N; i++) {
                if (currentPeople < C && (people[i] - currentMintime) <= mid) {
                    currentPeople++;
                }
                else {
                    busCount++;
                    currentPeople = 1;
                    currentMintime = people[i];
                }
            }

            if (busCount <= M) {
                answer = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        System.out.print(answer);
    }
}