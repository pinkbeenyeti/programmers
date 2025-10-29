class Solution {
    private boolean isTree(StringBuilder number, int start, int end) {
        if (start == end) return true;
        
        int mid = (start + end) / 2;
        char root = number.charAt(mid);
        
        int left = (start + mid - 1) / 2, right = (mid + 1 + end) / 2;
        char lChar = number.charAt(left), rChar = number.charAt(right);
        
        if (root == '0' && (lChar == '1' || rChar == '1')) return false;
        return isTree(number, start, (start + end) / 2 - 1) && isTree(number, (start + end) / 2 + 1, end);
    }
    
    private StringBuilder transNumberSize(String number) {
        StringBuilder stb = new StringBuilder();
        int length = number.length(), current = 1;
        
        while ((current - 1) < length) {
            current *= 2;
        }
        
        stb.append("0".repeat((current - 1) - length)).append(number);
        return stb;
    }
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i=0; i<numbers.length; i++) {
            StringBuilder transNumber = transNumberSize(Long.toBinaryString(numbers[i]));
            
            if (isTree(transNumber, 0, transNumber.length() - 1)) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
}