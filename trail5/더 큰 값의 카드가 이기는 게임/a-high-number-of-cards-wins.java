import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] bCards = new int[N];
        boolean[] isB = new boolean[2 * N + 1];

        for (int i = 0; i < N; i++) {
            bCards[i] = Integer.parseInt(br.readLine().trim());
            isB[bCards[i]] = true;
        }

        int[] aCards = new int[N];
        int idx = 0;
        for (int i = 1; i <= 2 * N; i++) {
            if (!isB[i]) {
                aCards[idx++] = i;
            }
        }

        Arrays.sort(bCards);
        Arrays.sort(aCards);

        int aIdx = 0;
        int bIdx = 0;
        int score = 0;

        while (aIdx < N && bIdx < N) {
            if (aCards[aIdx] > bCards[bIdx]) {
                score++;
                bIdx++;
            }

            aIdx++;
        }

        System.out.println(score);
    }
}