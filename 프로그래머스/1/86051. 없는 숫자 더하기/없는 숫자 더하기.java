import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int sum = Arrays.stream(numbers)
                        .distinct()
                        .sum();
        
        return 45 - sum;
    }
}