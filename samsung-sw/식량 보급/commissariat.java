import java.io.*;
import java.util.*;

public class Main {

    private static class Query {
        long command, value;
        long[] nums;

        public Query(long c, long v) {
            this.command = c;
            this.value = v;
        }
    }

    private static class Fenwick {
        int n;
        long[] tree;

        Fenwick(int n) {
            this.n = n;
            this.tree = new long[n + 1];
        }

        void update(int idx, long value) {
            for (; idx <= n; idx += (idx & -idx)) {
                tree[idx] += value;
            }
        }

        long getSum(int idx) {
            long sum = 0L;
            for (; idx > 0; idx -= (idx & -idx)) {
                sum += tree[idx];
            }
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        long shift = 0;
        
        List<Query> qs = new ArrayList<>();
        Set<Long> coords = new TreeSet<>();
        Map<Long, Integer> trans = new HashMap<>();
        Map<Integer, Long> indexToNum = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            long command = Long.parseLong(st.nextToken());
            long value = Long.parseLong(st.nextToken());
            Query q = new Query(command, value);

            if (command == 100) {
                // 0-based로 저장하여 빈 값(0L)이 포함되지 않도록 수정
                q.nums = new long[(int) value];
                for (int j = 0; j < value; j++) {
                    if (!st.hasMoreTokens()) {
                        st = new StringTokenizer(br.readLine());
                    }
                    q.nums[j] = Long.parseLong(st.nextToken()); 
                    coords.add(q.nums[j] - shift);
                }
            }

            if (command == 200) {
                coords.add(value - shift);
            }

            if (command == 300) {
                shift += value;
            }

            qs.add(q);
        }

        int index = 1;
        for (Long num : coords) {
            trans.put(num, index);
            indexToNum.put(index, num);
            index++;
        }

        Fenwick houseCount = new Fenwick(trans.size());
        Fenwick foodSum = new Fenwick(trans.size());

        shift = 0;
        for (Query q : qs) {
            if (q.command == 100) {
                for (long v : q.nums) {
                    int idx = trans.get(v - shift);
                    houseCount.update(idx, 1);
                    foodSum.update(idx, v - shift);
                }
            }

            if (q.command == 200) {
                int idx = trans.get(q.value - shift);
                houseCount.update(idx, 1);
                foodSum.update(idx, q.value - shift);
            }

            if (q.command == 300) {
                shift += q.value;
            }

            if (q.command == 400) {
                int l = 1, r = trans.size();
                int idx = 1;

                while (l <= r) {
                    int mid = (l + r) / 2;

                    long count = houseCount.getSum(mid);
                    long sum = foodSum.getSum(mid);
                    long midFood = indexToNum.get(mid);
                    long requiredFood = count * midFood - sum;

                    if (requiredFood > q.value) {
                        r = mid - 1;
                    } else {
                        idx = mid; // 버그 수정: index 대신 idx에 저장
                        l = mid + 1;
                    }
                }

                long totalCount = houseCount.getSum(idx);
                long totalSum = foodSum.getSum(idx);
                long totalFood = indexToNum.get(idx);

                long usedFood = totalCount * totalFood - totalSum;
                long remainFood = q.value - usedFood;

                long result = totalFood + (remainFood / totalCount) + shift;
                answer.append(result).append("\n");
            }
        }

        System.out.print(answer);
    }
}