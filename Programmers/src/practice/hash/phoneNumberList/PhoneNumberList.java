package practice.hash.phoneNumberList;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberList {
    public static void main(String[] args) {
        String[] stringArr = {""};
        System.out.println(solution(stringArr));
    }

    public static boolean solution(String[] phoneBook) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }

        for (String s : phoneBook) {
            for (int j = 0; j < s.length(); j++) {
                if (map.containsKey(s.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
