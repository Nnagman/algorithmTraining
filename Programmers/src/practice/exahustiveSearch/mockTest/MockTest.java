package practice.exahustiveSearch.mockTest;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MockTest {
    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers)));
        System.out.println(Arrays.toString(solution2(answers)));
    }

    static public int[] solution(int[] answers) {

        int[] arr_1 = {1, 2, 3, 4, 5};
        int[] arr_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int index_1 = 0, index_2 = 0, index_3 = 0;

        int count_1 = 0, count_2 = 0, count_3 = 0;

        for (int answer : answers) {
            if (answer == arr_1[index_1]) count_1++;
            if (answer == arr_2[index_2]) count_2++;
            if (answer == arr_3[index_3]) count_3++;

            index_1++;
            index_2++;
            index_3++;

            if (index_1 > 4) index_1 = 0;
            if (index_2 > 7) index_2 = 0;
            if (index_3 > 9) index_3 = 0;
        }

        int[] res = new int[2];
        res[0] = 1;
        res[1] = 2;

        if (count_1 == count_2 && count_2 == count_3) {
            res = new int[3];
            res[0] = 1;
            res[1] = 2;
            res[2] = 3;
        } else if (count_1 > count_2) {
            if (count_1 > count_3) {
                res = new int[1];
                res[0] = 1;
                return res;
            } else if (count_1 == count_3) {
                res = new int[2];
                res[0] = 1;
                res[1] = 3;
                return res;
            } else {
                res = new int[1];
                res[0] = 3;
                return res;
            }
        } else if (count_2 > count_1) {
            if (count_2 > count_3) {
                res = new int[1];
                res[0] = 2;
                return res;
            } else if (count_2 == count_3) {
                res = new int[2];
                res[0] = 2;
                res[1] = 3;
                return res;
            } else {
                res = new int[1];
                res[0] = 3;
                return res;
            }
        }
        return res;
    }

    static int[] solution2(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for (int i = 0; i < hit.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], 0);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < hit.length; i++)
            if (max == hit[i]) list.add(i + 1);

        int[] answer = new int[list.size()];
        int cnt = 0;
        for (int num : list)
            answer[cnt++] = num;
        return answer;
    }
}
