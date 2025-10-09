import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String sound;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sound = br.readLine();
    }

    private static void process() {
        Pattern pattern = Pattern.compile("^(100+1+|01)+$");
        Matcher matcher = pattern.matcher(sound);

        if (matcher.find()) {
            System.out.println("SUBMARINE");
        } else {
            System.out.println("NOISE");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
