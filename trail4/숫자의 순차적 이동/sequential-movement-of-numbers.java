import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] dicts = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},
                                    {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> numPos = new HashMap<>();
        Map<Integer, Integer> posNum = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());

                numPos.put(number, i * N + j);
                posNum.put(i * N + j, number);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int num = 1; num <= (N * N); num++) {
                int currPos = numPos.get(num);
                int maxPos = 0;
                int maxNum = 0;

                int r = currPos / N;
                int c = currPos % N;

                for (int[] dict : dicts) {
                    int nr = r + dict[0];
                    int nc = c + dict[1];

                    int nextPos = nr * N + nc;
                    int nextNum = 0;

                    if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        nextNum = posNum.get(nextPos);
                        if (nextNum > maxNum) {
                            maxPos = nextPos;
                            maxNum = nextNum;
                        }
                    }
                }

                numPos.put(num, maxPos);
                numPos.put(maxNum, currPos);

                posNum.put(currPos, maxNum);
                posNum.put(maxPos, num);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer.append(posNum.get(i * N + j)).append(" ");
            }
            answer.append("\n");
        }

        System.out.print(answer);
    }
}