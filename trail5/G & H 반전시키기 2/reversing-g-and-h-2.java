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

        for (int i = (N - 1); i >= 0; i--) {
            char ch = current.charAt(i);

            if (fliped) {
                ch = (ch == 'G') ? 'H' : 'G';
            }
            
            if (ch != goal.charAt(i)) {
                flipCount++;
                fliped = !fliped;
            }
        }

        System.out.print(flipCount);
    }
}