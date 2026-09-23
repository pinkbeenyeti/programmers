import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = -1;
        
        for (int i = 0; i <= (n / 2); i++) {
            int count = (n - (2 * i)) / 5;
            int remain = (n - (2 * i)) % 5;

            if (remain == 0) {
                answer = i + count;
                break;
            }
        }

        System.out.print(answer);
    }
}