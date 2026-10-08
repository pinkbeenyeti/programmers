import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] lines = new String[2 * N + 1];
        for (int i = 1; i <= 2 * N; i++) lines[i] = br.readLine();

        int answer = 0;

        for (int i = 0; i < (M - 2); i++) {
            for (int j = (i + 1); j < (M - 1); j++) {
                for (int k = (j + 1); k < M; k++) {
                    Set<Integer> set = new HashSet<>();
                    boolean isSuccess = true;

                    for (int t = 1; t <= N; t++) {
                        String target = lines[t];

                        int a = target.charAt(i) - 'A' + 1;
                        int b = target.charAt(j) - 'A' + 1;
                        int c = target.charAt(k) - 'A' + 1;

                        set.add(a * 10000 + b * 100 + c);
                    }

                    for (int t = N + 1; t <= (2 * N); t++) {
                        String target = lines[t];

                        int a = target.charAt(i) - 'A' + 1;
                        int b = target.charAt(j) - 'A' + 1;
                        int c = target.charAt(k) - 'A' + 1;

                        if (set.contains(a * 10000 + b * 100 + c)) {
                            isSuccess = false;
                            break;
                        }
                    }

                    if (isSuccess) {
                        answer++;
                    }
                }
            }
        }


        System.out.print(answer);
    }
}
