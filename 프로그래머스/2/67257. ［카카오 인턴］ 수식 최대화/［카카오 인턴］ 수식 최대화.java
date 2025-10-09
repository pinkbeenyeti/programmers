import java.util.*;

class Solution {
    private static final char[][] opOrders = {
        {'+', '-', '*'}, {'+', '*', '-'}, {'-', '+', '*'},
        {'-', '*', '+'}, {'*', '+', '-'}, {'*', '-', '+'}
    };

    public long solution(String expression) {
        long answer = 0;

        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }

        for (char[] opOrder : opOrders) {
            List<String> currentTokens = new ArrayList<>(tokens);

            for (char op : opOrder) {
                for (int i = 0; i < currentTokens.size(); i++) {
                    if (currentTokens.get(i).equals(String.valueOf(op))) {
                        long num1 = Long.parseLong(currentTokens.get(i - 1));
                        long num2 = Long.parseLong(currentTokens.get(i + 1));
                        long result = calculate(num1, num2, op);

                        currentTokens.remove(i - 1);
                        currentTokens.remove(i - 1); 
                        currentTokens.remove(i - 1);
                        currentTokens.add(i - 1, String.valueOf(result));

                        i = -1;
                    }
                }
            }
            
            long finalResult = Math.abs(Long.parseLong(currentTokens.get(0)));
            answer = Math.max(answer, finalResult);
        }

        return answer;
    }

    private long calculate(long num1, long num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return 0;
        }
    }
}