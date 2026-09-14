import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String current = br.readLine();
        String goal = br.readLine();

        int flipCount = 0;
        boolean fliped = false;

        for (int i = 0; i < N; i++) {
            if (current.charAt(i) != goal.charAt(i) && !fliped) {
                flipCount++;
                fliped = true;
            }

            if (current.charAt(i) == goal.charAt(i)) {
                fliped = false;
            }
        }

        System.out.print(flipCount);
    }
}