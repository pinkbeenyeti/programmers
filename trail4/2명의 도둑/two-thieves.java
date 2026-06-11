import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, W, ANSWER = 0;
    private static int[][] map;

    private static class Thief implements Comparable<Thief> {
        int r, s, e, value = 0;
        int[] temp;
        int maxVal;

        public Thief(int r, int s, int e) {
            this.r = r;
            this.s = s;
            this.e = e;

            temp = new int[M];
            for (int i = s; i <= e; i++) temp[e - i] = map[r][i];
            findMaxSquareSum(0, 0, 0);
            this.value = maxVal;
        }

        @Override
        public int compareTo(Thief other) {
            return other.value - this.value;
        }

        private void findMaxSquareSum(int idx, int weightSum, int squareSum) {
            if (weightSum > W) return;
            
            if (idx == M) {
                maxVal = Math.max(maxVal, squareSum);
                return;
            }

            findMaxSquareSum(idx + 1, weightSum + temp[idx], squareSum + (temp[idx] * temp[idx]));
            findMaxSquareSum(idx + 1, weightSum, squareSum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        List<Thief> list = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c <= (N - M); c++) {
                list.add(new Thief(r, c, c + M - 1));
            }
        }

        Collections.sort(list);

        for (int i = 0; i < (list.size() - 1); i++) {
            Thief first = list.get(i);

            for (int j = (i + 1); j < list.size(); j++) {
                Thief second = list.get(j);

                if (first.r == second.r) {
                    if (first.s > second.e || first.e < second.s) ANSWER = Math.max(ANSWER, first.value + second.value);
                } else {
                    ANSWER = Math.max(ANSWER, first.value + second.value);
                }
            }
        }

        System.out.print(ANSWER);

    }
}