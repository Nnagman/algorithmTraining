package practice.stackAndQueue.functionDevelopment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] progresses = {20, 99, 93, 30, 55, 10};
        int[] speeds = {5, 10, 1, 1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> progressList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            progressList.add((int) Math.ceil((100 - progresses[i]) / speeds[i]));
        }

        System.out.println(progressList);

        while (progressList.size() != 0) {
            List<Integer> idxList = new ArrayList<>();
            int number = 0;
            int cnt = 0;

            for (Integer integer : progressList)
                if (number > integer)
                    number = integer;


            for (int i = 0; i < progressList.size(); i++)
                if (number == progressList.get(i)) {
                    cnt = cnt + 1;
                    idxList.add(i);
                }

            for (int idx : idxList) {
                progressList.remove(idx);
            }

            answer.add(cnt);
            break;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
