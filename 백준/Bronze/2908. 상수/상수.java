import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder line = new StringBuilder();
        line.append(br.readLine()).reverse();
        
        int A = Integer.parseInt(line.substring(0, 3));
        int B = Integer.parseInt(line.substring(4, 7));

        System.out.print(Math.max(A, B));
    }
}
