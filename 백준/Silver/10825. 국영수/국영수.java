import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static Elem[] students;
    static StringBuilder answer = new StringBuilder();

    static class Elem implements Comparable<Elem> {
        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            if (korean != other.korean) return other.korean - korean;
            if (english != other.english) return english - other.english;
            if (math != other.math) return other.math - math;

            return name.compareTo(other.name);
        }
    }

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        students = new Elem[N];

        for (int i=0; i<N; i++) {
            students[i] = new Elem();
            students[i].name = scanner.next();
            students[i].korean = scanner.nextInt();
            students[i].english = scanner.nextInt();
            students[i].math = scanner.nextInt();
        }
    }

    static void printScore() {
        Arrays.sort(students);

        for (Elem student : students) {
            answer.append(student.name).append('\n');
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        printScore();
    }

}
