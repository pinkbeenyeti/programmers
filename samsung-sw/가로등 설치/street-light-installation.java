import java.io.*;
import java.util.*;

public class Main {

    private static class Distance implements Comparable<Distance> {
        int l, r, d;

        public Distance(int l, int r) {
            this.l = l;
            this.r = r;
            this.d = r - l;
        }

        @Override
        public int compareTo(Distance other) {
            if (this.d != other.d)
                return Integer.compare(other.d, this.d);
            else 
                return Integer.compare(this.l, other.l);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int Q = Integer.parseInt(st.nextToken());

        int N = 0;
        int M = 0;

        TreeSet<Distance> distances = new TreeSet<>();
        TreeSet<Integer> lights = new TreeSet<>();

        List<Integer> lightIndexes = new ArrayList<>();
        lightIndexes.add(0);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            if (command == 100) {
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());

                for (int j = 0; j < M; j++) {
                    int pos = Integer.parseInt(st.nextToken());

                    lights.add(pos);
                    lightIndexes.add(pos);
                }

                for (int j = 1; j < M; j++) {
                    distances.add(new Distance(lightIndexes.get(j), lightIndexes.get(j + 1)));
                }
            }

            if (command == 200) {
                Distance dist = distances.first();

                Distance distL = new Distance(dist.l, (dist.l + dist.r + 1) / 2);
                Distance distR = new Distance((dist.l + dist.r + 1) / 2, dist.r);

                distances.remove(dist);
                distances.add(distL);
                distances.add(distR);

                lights.add((dist.l + dist.r + 1) / 2);
                lightIndexes.add((dist.l + dist.r + 1) / 2);
            }

            if (command == 300) {
                int index = Integer.parseInt(st.nextToken());
                int pos = lightIndexes.get(index);

                Integer l = lights.lower(pos);
                Integer r = lights.higher(pos);

                if (l != null && r != null) {
                    distances.remove(new Distance(l, pos));
                    distances.remove(new Distance(pos, r));
                    distances.add(new Distance(l, r));
                }
                else if (l != null) {
                    distances.remove(new Distance(l, pos));
                }
                else if (r != null) {
                    distances.remove(new Distance(pos, r));
                }

                lights.remove(pos);
            }

            if (command == 400) {
                Distance distance = distances.first();
                int a = (lights.first() - 1) * 2;
                int b = (N - lights.last()) * 2;
                answer.append(Math.max(distance.d, Math.max(a, b))).append("\n");
            }
        }

        System.out.print(answer);
    }
}