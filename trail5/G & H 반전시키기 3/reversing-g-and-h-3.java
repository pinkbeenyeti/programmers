import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String current = br.readLine();
        String goal = br.readLine();

        int flipCount = 0;
        int diffLen = 0;

        for (int i = 0; i < N; i++) {
            if (current.charAt(i) != goal.charAt(i)) diffLen++;
            else {
                if (diffLen > 0) {
                    flipCount += (diffLen + 3) / 4;
                    diffLen = 0;
                }
            }
        }

        if (diffLen > 0) {
            flipCount += (diffLen + 3) / 4;
        }

        System.out.print(flipCount);
    }
}