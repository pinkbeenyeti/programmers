import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    enum Things {
        HOME, WATER, ANIMAL, NONE, STONE
    }

    static class Position {
        int[] home, animal;

        Position() {
            home = new int[2];
            animal = new int[2];
        }
    }

    static class Animal {
        int row, column, count;

        Animal(int row, int column, int count) {
            this.row = row;
            this.column = column;
            this.count = count;
        }
    }

    static class Water {
        int row, column;

        Water(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    static int row, column, answer;
    static Things[][] map;
    static boolean[][] visit;
    static int[][] dict = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static Queue<Water> waterQueue = new LinkedList<>();

    static Position position = new Position();

    static void input() {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        column = scanner.nextInt();
        map = new Things[row][column];
        visit = new boolean[row][column];
        scanner.nextLine();

        for (int i=0; i<row; i++) {
            String[] line = scanner.nextLine().split("");
            for (int j=0; j<column; j++) {
                switch (line[j]) {
                    case "D":
                        map[i][j] = Things.HOME;
                        visit[i][j] = true;
                        position.home[0] = i;
                        position.home[1] = j;
                        break;
                    case "*":
                        map[i][j] = Things.WATER;
                        visit[i][j] = true;
                        waterQueue.add(new Water(i, j));
                        break;
                    case "S":
                        map[i][j] = Things.ANIMAL;
                        visit[i][j] = true;
                        position.animal[0] = i;
                        position.animal[1] = j;
                        break;
                    case ".":
                        map[i][j] = Things.NONE;
                        break;
                    case "X":
                        map[i][j] = Things.STONE;
                        visit[i][j] = true;
                        break;
                    default:
                        break;
                }

            }
        }
    }

    static void spreadWater() {
        int length = waterQueue.size();

        for (int i=0; i<length; i++) {
            Water water = waterQueue.poll();

            for (int[] dr : dict) {
                int nr = water.row + dr[0], nc = water.column + dr[1];

                if (nr < 0 || nr >= row || nc < 0 || nc >= column) continue;
                if (visit[nr][nc]) continue;

                waterQueue.add(new Water(nr, nc));
                visit[nr][nc] = true;
            }
        }
    }

    static void bfs() {
        Queue<Animal> qu = new LinkedList<>();
        qu.add(new Animal(position.animal[0], position.animal[1], 0));

        while(!qu.isEmpty()) {
            spreadWater();
            int size = qu.size();
            for (int i=0; i<size; i++) {
                Animal ani = qu.poll();

                for (int[] dr : dict) {
                    int nr = ani.row + dr[0], nc = ani.column + dr[1];

                    if (nr < 0 || nr >= row || nc < 0 || nc >= column) continue;
                    if (nr == position.home[0] & nc == position.home[1]) {
                        System.out.println(ani.count + 1);
                        return;
                    }
                    if (visit[nr][nc]) continue;

                    qu.add(new Animal(nr, nc, ani.count+1));
                    visit[nr][nc] = true;
                }
            }
        }

        System.out.println("KAKTUS");
    }

    public static void main(String[] args) {
        input();
        bfs();
    }
}
