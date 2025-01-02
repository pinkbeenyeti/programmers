import java.util.Scanner;

public class Main {
    static int N, max;
    static int[] numbers;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        numbers = new int[N * 3];

        for (int i=0; i<N*3; i++) {
            int number = scanner.nextInt();
            if (number > max) max = number;
            numbers[i] = number;
        }
    }
    
    static boolean countNumber(long number) {
        int count = 0;

        for (int i=0; i<N*3; i+=3) {
            int A = numbers[i], C = numbers[i+1], B = numbers[i+2];
            if ((number - A) < 0) {
                continue;
            } else if ((number - A) == 0) {
                count++;
            } else if (number > C) {
                count += (C - A) / B;
                count++;
            }else {
                count += (int) (number - A) / B;
                count++;
            }
        }

        return count % 2 == 0;
    }

    static int count(long number) {
        int count = 0;

        for (int i=0; i<N*3; i+=3) {
            int A = numbers[i], C = numbers[i+1], B = numbers[i+2];
            if ((number - A) < 0 || number > C) {
                continue;
            } else if ((number - A) == 0) {
                count++;
            } else {
                int k = (int) (number - A) % B;

                if (k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    static void process() {
        long L = 0, R = max;

        while (L <= R) {
            long mid = (L + R) / 2;

            if (countNumber(mid)) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        if (countNumber(L)) {
            System.out.println("NOTHING");
        } else {
            System.out.println(L + " " + count(L));
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
