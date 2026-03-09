import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static Set<String> strings = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        for (int i=1; i<=string.length(); i++) {
            for (int j=0; j<=(string.length() - i); j++) {
                strings.add(string.substring(j, j + i));
            }
        }

        System.out.print(strings.size());
    }
}
