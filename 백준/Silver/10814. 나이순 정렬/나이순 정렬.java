import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class Person implements Comparable<Person> {
        String name;
        int age, index;

        public Person(String name, int age, int indx) {
            this.name = name;
            this.age = age;
            this.index = index;
        }

        @Override
        public int compareTo(Person other) {
            if (this.age == other.age) {
                return this.index - other.index;
            }

            return this.age - other.age;
        }

        @Override
        public String toString() {
            return this.age + " " + this.name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            list.add(new Person(name, age, i));
        }

        Collections.sort(list);

        for (int i=0; i<N; i++) {
            answer.append(list.get(i)).append("\n");
        }

        System.out.print(answer);
    }
}
