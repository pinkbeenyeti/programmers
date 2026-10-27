import java.io.*;
import java.util.*;

public class Main {
    static class Item {
        String str;
        long openCnt, closeCnt;

        Item(String str) {
            this.str = str;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(')
                    this.openCnt++;
                else
                    this.closeCnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        List<Item> items = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            items.add(new Item(br.readLine().trim()));
        }

        items.sort((a, b) -> Long.compare(b.openCnt * a.closeCnt, a.openCnt * b.closeCnt));

        long answer = 0;
        long currentOpen = 0;

        for (Item item : items) {
            for (int i = 0; i < item.str.length(); i++) {
                if (item.str.charAt(i) == '(') {
                    currentOpen++;
                } else {
                    answer += currentOpen;
                }
            }
        }

        System.out.println(answer);
    }
}