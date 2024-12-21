import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N;
    static ArrayList<String> files;
    static StringBuilder answer;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        files = new ArrayList<String>();

        for (int i=0; i<N; i++) {
            String file = scanner.nextLine();
            files.add(file.substring(file.lastIndexOf('.')+1));
        }

        Collections.sort(files);
    }

    static void count_extensions() {
        answer = new StringBuilder();
        files.add("");

        String extension = files.get(0);
        int count = 1;

        for (int i=1; i<files.size(); i++) {
            String nExtension = files.get(i);

            if (extension.equals(nExtension)) {
                count+=1;
            } else {
                answer.append(extension).append(' ').append(count).append('\n');
                extension = nExtension;
                count = 1;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        count_extensions();
    }
}
