import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class State {
        int[] water;

        State(int a, int b, int c) {
            this.water = new int[3];
            water[0] = a;
            water[1] = b;
            water[2] = c;
        }

        State move(int from, int to) {
            if (water[from] + water[to] > limit[to]) {
                State newSt = new State(water[0], water[1], water[2]);
                newSt.water[from] -= limit[to] - water[to];
                newSt.water[to] = limit[to];
                
                return newSt;
            }

            State newSt = new State(water[0], water[1], water[2]);
            newSt.water[to] = water[from] + water[to];
            newSt.water[from] = 0;

            return newSt;
        }
    }

    static int A, B, C;
    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();

        visit = new boolean[A+1][B+1][C+1];
        possible = new boolean[C+1];
        limit = new int[]{A, B, C};
    }

    static void bfs(int a, int b, int c) {
        Queue<State> qu = new LinkedList<>();
        visit[a][b][c] = true;
        qu.add(new State(a, b, c));

        while (!qu.isEmpty()) {
            State st = qu.poll();
            if (st.water[0] == 0) possible[st.water[2]] = true;
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    if (i == j) continue;

                    State newSt = st.move(i, j);
                    if (!visit[newSt.water[0]][newSt.water[1]][newSt.water[2]]) {
                        qu.add(newSt);
                        visit[newSt.water[0]][newSt.water[1]][newSt.water[2]] = true;
                    }
                }
            }
        }
    }

    static void process() {
        bfs(0, 0, C);

        StringBuilder answer = new StringBuilder();
        for (int i=0; i<=C; i++) {
            if (possible[i]) {
                answer.append(i).append(' ');
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
