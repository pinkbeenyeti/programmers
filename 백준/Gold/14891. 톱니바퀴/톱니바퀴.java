import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder[] array = new StringBuilder[4];
    private static int answer = 0;

    private static void rotateGear(int number, int direction) {
        int[] rotateDirection = new int[4];
        rotateDirection[number] = direction;

        for (int i=1; i<4; i++) {
            if (number - i < 0 || rotateDirection[number - i + 1] == 0) break;
            else {
                if (array[number - i + 1].charAt(6) != array[number - i].charAt(2)) {
                    rotateDirection[number - i] = rotateDirection[number - i + 1] * -1;
                }
            }
        }

        for (int i=1; i<4; i++) {
            if (number + i > 3 || rotateDirection[number + i - 1] == 0) break;
            else {
                if (array[number + i - 1].charAt(2) != array[number + i].charAt(6)) {
                    rotateDirection[number + i] = rotateDirection[number + i - 1] * -1;
                }
            }
        }

        for (int i=0; i<4; i++) {
            StringBuilder stb = array[i];

            if (rotateDirection[i] == 1) {
                stb.insert(0, stb.charAt(7));
                stb.delete(8, 9);
            }

            if (rotateDirection[i] == -1) {
                stb.append(stb.charAt(0));
                stb.delete(0, 1);
            }
        }
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i=0; i<4; i++) {
            array[i] = new StringBuilder(br.readLine());
        }

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            rotateGear(number - 1, direction);
        }

        for (int i=0; i<4; i++) {
            if (array[i].charAt(0) == '1') {
                answer += (int) Math.pow(2, i);
            }
        }

        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
