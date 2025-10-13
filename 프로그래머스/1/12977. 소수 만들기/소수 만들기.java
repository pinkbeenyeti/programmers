class Solution {
    public int solution(int[] nums) {
        boolean[] isPrime = new boolean[3001];
        int answer = 0;
        
        for (int num=2; num<=3000; num++) {
            int count = 0;
            
            for (int divisor=2; divisor<=Math.sqrt(num); divisor++) {
                if (num % divisor == 0) {
                    count++;
                    break;
                }
            }
            
            if (count == 0) {
                isPrime[num] = true;
            }
        }
        
        for (int i=0; i<nums.length - 2; i++) {
            for (int j=i+1; j<nums.length - 1; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    if (isPrime[nums[i] + nums[j] + nums[k]]) answer++;
                }
            }
        }
        
        return answer;
    }
}