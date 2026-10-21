import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        Set<Character> set = new HashSet<>();

        int l = 0, r = 0, answer = 1;
        set.add(target.charAt(l));

        while (r < target.length() - 1) {
            if (set.contains(target.charAt(r + 1))) {
                while (set.contains(target.charAt(r + 1))) {
                    set.remove(target.charAt(l++));
                }
            }

            set.add(target.charAt(++r));
            answer = Math.max(answer, r - l + 1);
        }

        System.out.print(answer);
    }
}