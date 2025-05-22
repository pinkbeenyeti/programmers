import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> getParent = new HashMap<>();
        HashMap<String, Integer> getMoney = new HashMap<>();
        
        for (int i=0; i<enroll.length; i++) {
            if (referral[i].equals("-")) {
                getParent.put(enroll[i], "center");
            } else {
                getParent.put(enroll[i], referral[i]);
            }
            
            getMoney.put(enroll[i], 0);
        }
        
        String me, parent;
        int sellerMoney, cash;
        for (int i=0; i<seller.length; i++) {
            me = seller[i];
            parent = getParent.get(me);
            sellerMoney = getMoney.get(me);
            cash = amount[i] * 100;
            while (true) {
                if (cash < 10) {
                    getMoney.replace(me, sellerMoney+cash);
                    break;
                }
                
                getMoney.replace(me, sellerMoney+cash-(cash*10/100));
                cash = cash*10/100;
                
                if (parent.equals("center")) {
                    break;
                }
                
                me = parent;
                parent = getParent.get(me);
                sellerMoney = getMoney.get(me);
            }
        }
        
        int result[] = new int[enroll.length];
        for (int i=0; i<enroll.length; i++) {
            result[i] = getMoney.get(enroll[i]);
        }
        
        return result;
    }
}