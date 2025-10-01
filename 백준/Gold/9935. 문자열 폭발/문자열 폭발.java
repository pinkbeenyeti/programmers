import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String str;
    private static String bomb;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        bomb = br.readLine();
    }

    private static void process() {
        StringBuilder answer = new StringBuilder();

        int size = bomb.length();
        char lastCh = bomb.charAt(size - 1);

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            answer.append(ch);

            if (ch == lastCh && answer.length() >= size) {
                int start = answer.length() - size;

                if (answer.substring(start).equals(bomb)) {
                    answer.delete(start, answer.length());
                }
            }
        }

        if (answer.length() != 0) {
            System.out.println(answer.toString());
        } else {
            System.out.println("FRULA");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
