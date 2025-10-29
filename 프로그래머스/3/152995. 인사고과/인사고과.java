import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wanhoAtt = scores[0][0], wanhoPeer = scores[0][1];
        int wanhoSum = wanhoAtt + wanhoPeer;
        
        Arrays.sort(scores, (s1, s2) -> {
            if (s1[0] != s2[0]) return s2[0] - s1[0];
            else return s1[1] - s2[1];
        });
        
        List<Integer> validSums = new ArrayList<>();
        int maxPeerScore = 0;
        
        for (int[] score : scores) {
            int att = score[0], peer = score[1];
            
            if (peer < maxPeerScore) {
                if (att == wanhoAtt && peer == wanhoPeer) return -1;
            } else {
                maxPeerScore = peer;
                validSums.add(att + peer);
            }
        }
        
        int rank = 1;
        for (int sum : validSums) {
            if (sum > wanhoSum) rank++;
        }
        
        return rank;
    }
}