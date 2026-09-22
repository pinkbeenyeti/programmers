import java.util.*;

public class Main {

    private static class Gem {
        double w, v;

        public Gem(double w, double v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Gem[] gems = new Gem[n];

        for (int i = 0; i < n; i++) {
            double w = sc.nextDouble();
            double v = sc.nextDouble();

            gems[i] = new Gem(w, v);
        }

        Arrays.sort(gems, (a, b) -> {
            return Double.compare((b.v / b.w), (a.v / a.w));
        });

        double answer = 0;
        
        for (Gem gem : gems) {
            if (gem.w < m) answer += gem.v; 
            else {
                answer += (gem.v / gem.w) * m;
                break;
            }

            m -= (int) gem.w;
        }

        System.out.print(String.format("%.3f", answer));
    }
}