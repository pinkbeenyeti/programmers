import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] pickTired = {
                {1, 1, 1},    // diaPick
                {5, 1, 1},    // ironPick
                {25, 5, 1}    // stonePick
        };

        // 곡괭이 순서 생성
        List<Integer> pickOrder = IntStream.range(0, picks.length)
                .flatMap(i -> IntStream.range(0, picks[i]).map(j -> i))
                .boxed()
                .collect(Collectors.toList());

        // 광물 데이터 처리
        List<int[]> sortedMinerals = IntStream.range(0, Math.min(minerals.length, pickOrder.size() * 5))
                .filter(i -> i % 5 == 0)
                .mapToObj(i -> {
                    int[] count = new int[3]; // [diamond, iron, stone]
                    for (int j = i; j < i + 5 && j < minerals.length; j++) {
                        switch (minerals[j]) {
                            case "diamond": count[0]++; break;
                            case "iron": count[1]++; break;
                            case "stone": count[2]++; break;
                        }
                    }
                    return count;
                })
                .sorted(Comparator.comparingInt((int[] c) -> c[0])
                        .thenComparingInt(c -> c[1])
                        .thenComparingInt(c -> c[2])
                        .reversed())
                .collect(Collectors.toList());

        // 결과 계산
        return IntStream.range(0, sortedMinerals.size())
                .map(i -> {
                    if (i < pickOrder.size()) {
                        int pickType = pickOrder.get(i);
                        int[] mineral = sortedMinerals.get(i);
                        return IntStream.range(0, mineral.length)
                                .map(j -> mineral[j] * pickTired[pickType][j])
                                .sum();
                    }
                    return 0;
                })
                .sum();
    }
}
