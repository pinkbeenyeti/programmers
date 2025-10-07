import java.util.*;

class Solution {
    private char maxDigit = '0';
    private boolean[] candidateDigits = new boolean[10];
    
    private boolean calculateDigit(String[] expression, int digit) {
        int first = 0, second = 0, result = 0;
        char[] firstArray = expression[0].toCharArray(), secondArray = expression[2].toCharArray(), resultArray = expression[4].toCharArray();
        
        for (int i=0; i<firstArray.length; i++) {
            first += ((int) Math.pow(digit, firstArray.length - i - 1)) * (firstArray[i] - '0');
        }
        
        for (int i=0; i<secondArray.length; i++) {
            second += ((int) Math.pow(digit, secondArray.length - i - 1)) * (secondArray[i] - '0');
        }
        
        for (int i=0; i<resultArray.length; i++) {
            result += ((int) Math.pow(digit, resultArray.length - i - 1)) * (resultArray[i] - '0');
        }
        
        if (expression[1].equals("+")) return (first + second) == result;
        else return (first - second) == result;
    }
    
    private String getDigitResult(String[] expression, int digit) {
        int first = 0, second = 0, result = 0;
        char[] firstArray = expression[0].toCharArray(), secondArray = expression[2].toCharArray();
        
        for (int i=0; i<firstArray.length; i++) {
            first += ((int) Math.pow(digit, firstArray.length - i - 1)) * (firstArray[i] - '0');
        }
        
        for (int i=0; i<secondArray.length; i++) {
            second += ((int) Math.pow(digit, secondArray.length - i - 1)) * (secondArray[i] - '0');
        }
        
        if (expression[1].equals("+")) result = first + second;
        else result = first - second;
        
       return Integer.toString(result, digit);
    }
    
    public String[] solution(String[] expressions) {
        List<String[]> queries = new LinkedList<>();
        List<String[]> completed = new LinkedList<>();
        
        for (String expression : expressions) {
            String[] splited = expression.split(" ");
            
            if (splited[4].equals("X")) queries.add(splited);
            else completed.add(splited);
            
            for (String str : splited) {
                if (str.equals("-") || str.equals("+") || str.equals("X") || str.equals("=")) continue;
                else {
                    for (char digit : str.toCharArray()) {
                        if (digit > maxDigit) maxDigit = digit;
                    }
                }
            }
        }
        
        
        if (completed.isEmpty()) Arrays.fill(candidateDigits, true);
        else {
            for (int i=(maxDigit - '0' + 1); i<10; i++) {
                if (calculateDigit(completed.get(0), i)) candidateDigits[i] = true;
            }
            
            for (int i=1; i<completed.size(); i++) {
                for (int j=(maxDigit - '0' + 1); j<10; j++) {
                    if (candidateDigits[j] && !calculateDigit(completed.get(i), j)) {
                        candidateDigits[j] = false;
                    } 
                }
            }
        }
        
        for (int i=0; i<queries.size(); i++) {
            Set<String> set = new HashSet<>();
            
            for (int j=(maxDigit - '0' + 1); j<10; j++) {
                if (candidateDigits[j]) {
                    set.add(getDigitResult(queries.get(i), j));
                } 
            }
            
            if (set.size() > 1) queries.get(i)[4] = "?";
            else {
                for (String number : set) {
                    queries.get(i)[4] =number;
                }
            }
        }
        
        String[] answer = new String[queries.size()];
        
        for (int i=0; i<queries.size(); i++) {
            String print = "";
            
            for (String str : queries.get(i)) {
                print += (str + " ");
            }
            
            answer[i] = print.substring(0, print.length() - 1);
        }
        
        return answer;
    }
}