import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Position {
        int position, time;

        Position(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }

    static int N, M, answer;
    static boolean[] visited;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        visited = new boolean[100001];
    }

    static void canGo(Queue<Position> qu, int position, int time) {
        if (position >=0 && position <= 100000 && !visited[position]) {
            if (position < M) {
                qu.add(new Position(position, time+1));
                visited[position] = true;
            }
            else {
                qu.add(new Position(position, time+1));
                visited[position] = true;
            }
        }
    }

    static void bfs() {
        Queue<Position> qu = new LinkedList<>();
        qu.add(new Position(N, 0));
        visited[N] = true;

        while (!qu.isEmpty()) {
            Position pos = qu.poll();
            if (pos.position == M) {
                answer = pos.time;
                break;
            }
            canGo(qu, pos.position+1, pos.time);
            canGo(qu, pos.position-1, pos.time);
            canGo(qu, pos.position*2, pos.time);
        }
    }

    public static void main(String[] args) {
        input();
        bfs();
        System.out.println(answer);
    }
}
