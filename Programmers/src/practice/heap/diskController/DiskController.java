package practice.heap.diskController;

import java.util.*;

public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();

        for (int[] job : jobs) {
            PriorityQueue<Integer> temp = hm.getOrDefault(job[0], new PriorityQueue<>());
            temp.offer(job[1]);
            hm.put(job[0], temp);
        }

        for (int key : hm.keySet())
            list.add(key);

        Collections.sort(list);
        int t = list.get(0);
        int w = hm.get(t).poll();
        answer += t + w;

        while (!list.isEmpty()) {
            int tt = 1000;
            int tw = 1000;
            for (int i : list) {
                if (hm.get(i).isEmpty()) {
                    list.remove(i);
                    hm.get(i).remove();
                } else {
                    if (tt + tw > i + hm.get(i).poll()) {
                        t = i;
                        w = hm.get(t).peek();
                    }
                }
            }

            hm.get(tt).poll();

            answer += tt + answer - tw;

            t = tt;
            w = tw;
        }

        return (answer - 1) / jobs.length;
    }
}