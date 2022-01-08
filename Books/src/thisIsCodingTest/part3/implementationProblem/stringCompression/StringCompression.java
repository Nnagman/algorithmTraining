package thisIsCodingTest.part3.implementationProblem.stringCompression;

public class StringCompression {
    public static int Solution(String s) {
        int result = 0;
        int start = 0;
        int len = s.length();
        int sum = len;

//        while (true) {
//            for (int i = len / 2; i > 1; i--) {
//                if (s.substring(start, i).equals(s.substring(i, len % 2 == 0 ? len : len - 1))) {
//                    sum -= i * 2 - 1;
//                }
//            }
//        }
        return result;
    }
}
