import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, LEVEL = 0, broken = 0;
    private static List<Plate> belt;

    private static class Plate {
        int durability;
        boolean isRobot;

        public Plate(int durability, boolean isRobot) {
            this.durability = durability;
            this.isRobot = isRobot;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<(N * 2); i++) {
            belt.add(new Plate(Integer.parseInt(st.nextToken()), false));
        }
    }

    private static void canRobotDown() {
        Plate plate = belt.get(N - 1);

        if (plate.isRobot) {
            plate.isRobot = false;
        }
    }

    private static void conveyorMove() {
        Plate plate = belt.get(N * 2 - 1);

        belt.remove(N * 2 - 1);
        belt.add(0, plate);

        canRobotDown();
    }

    private static void robotMove() {
        for (int i = N - 2; i >= 0; i--) {
            Plate plate1 = belt.get(i);
            Plate plate2 = belt.get(i + 1);

            if (plate1.isRobot && !plate2.isRobot && plate2.durability > 0) {
                plate1.isRobot = false;
                plate2.isRobot = true;
                plate2.durability--;

                if (plate2.durability == 0) {
                    broken++;
                }
            }
        }

        canRobotDown();
    }

    private static void addRobot() {
        Plate plate = belt.get(0);

        if (!plate.isRobot && plate.durability > 0) {
            plate.isRobot = true;
            plate.durability--;

            if (plate.durability == 0) {
                broken++;
            }
        }
    }

    private static void process() {
        while (true) {
            LEVEL++;

            conveyorMove();
            robotMove();
            addRobot();

            if (broken >= K) {
                break;
            }
        }

        System.out.print(LEVEL);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
