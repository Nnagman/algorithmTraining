package practice.greedy.makingBigNum;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collections;

public class MakingBigNum {
    public static void main(String[] args) {
        String number = "";
        int k = 4;
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        HashMap<Integer, PriorityQueue<String>> hm = new HashMap<>();

        for (int i = 0; i < number.length() - 1; i++) {
            int n = Integer.parseInt(number.substring(i, i + 1));
            int key = (number.length() - i) + (10 - n);
            PriorityQueue<String> queue = hm.getOrDefault(key, new PriorityQueue<>());
            queue.add(Integer.toString(n));
            hm.put(key, queue);
        }

        while (k > 0) {
            int key = Collections.max(hm.keySet());
            String s = hm.get(key).poll();

            number = "";

            if (hm.get(key).isEmpty())
                hm.remove(key);

        }

        return number;
    }
}
