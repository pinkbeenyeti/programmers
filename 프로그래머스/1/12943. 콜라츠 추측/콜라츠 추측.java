class Solution {
    public int solution(int num) {
        int count = 0;
        long number = num;
        
        while (count < 500 && number != 1) {
            if (number % 2 == 0) number /= 2;
            else number = number * 3 + 1;
            
            count++;
        }
        
        return (count == 500) ? -1 : count;
    }
}