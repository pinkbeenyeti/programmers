import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    private static int N, M, R, score = 0;
    private static int[][] values = new int[101][101];
    private static int[][] dominos = new int[101][101];
    private static Queue<List<String>> rounds = new LinkedList<>();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int limit = 0;

        for (int row = 1; row<=N; row++) {
            st = new StringTokenizer(br.readLine());

            for (int col =1; col<=M; col++) {
                int value = Integer.parseInt(st.nextToken());
                values[row][col] = value;
                dominos[row][col] = value;
            }
        }

        for (int i=1; i<=R*2; i++) {
            st = new StringTokenizer(br.readLine());
            List<String> list = new ArrayList<>();
            limit = (i%2 == 0) ? 2 : 3;

            for (int j=1; j<=limit; j++) {
                list.add(st.nextToken());
            }

            rounds.offer(list);
        }
    }

    private static void attack(List<String> input) {
        int row = Integer.parseInt(input.get(0));
        int col = Integer.parseInt(input.get(1));
        String direction = input.get(2);

        int count = 1;

        while (count > 0) {
            if (row < 1 || row > N || col < 1 || col > M) break;

            if (dominos[row][col] != 0) {
                count = Math.max(count - 1, dominos[row][col] - 1);
                dominos[row][col] = 0;
                score++;
            } else {
                count--;
            }

            if (direction.equals("E")) col++;
            else if (direction.equals("W")) col--;
            else if (direction.equals("S")) row++;
            else if (direction.equals("N")) row--;
        }
    }

    private static void defense(List<String> input) {
        int row = Integer.parseInt(input.get(0));
        int col = Integer.parseInt(input.get(1));

        if (dominos[row][col] == 0) {
            dominos[row][col] = values[row][col];
        }
    }

    private static void process() {
        while (!rounds.isEmpty()) {
            if (rounds.peek().size() == 3) {
                attack(rounds.poll());
            } else {
                defense(rounds.poll());
            }
        }

        System.out.println(score);

        for (int row=1; row<=N; row++) {
            for (int col=1; col<=M; col++) {
                if (dominos[row][col] == 0) {
                    System.out.print("F ");
                } else {
                    System.out.print("S ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
