import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        Map<Character, Integer> positions = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (!positions.containsKey(ch)) {
                positions.put(ch, i);
            }
            
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        int index = Integer.MAX_VALUE;
        char answer = '0';

        for (char key : counts.keySet()) {
            if (counts.get(key) == 1 && index > positions.get(key)) {
                index = positions.get(key);
                answer = key;
            }
        }

        if (answer == '0') System.out.print("None");
        else System.out.print(answer);
    }
}