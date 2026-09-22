import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, (a, b) -> {
            String f = a + b;
            String e = b + a;
            return e.compareTo(f);
        });

        if (arr[0].equals("0")) {
            System.out.print("0");
            return;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(arr[i]);
        }

        System.out.print(answer.toString());
    }
}
