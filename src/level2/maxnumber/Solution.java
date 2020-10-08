package level2.maxnumber;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
public class Solution {
//    public String solution(int[] numbers) {
//        validateNumbersLength(numbers);
//        int[] result = Arrays.stream(numbers).boxed().sorted((o1, o2) -> {
//            String strO1 = String.valueOf(o1);
//            String strO2 = String.valueOf(o2);
//            if (strO1.length() > strO2.length()) {
//                for (int i = 0; i < strO1.length() - strO2.length(); i++) {
//                    strO2 += strO2.substring(strO2.length() - 1);
//                }
//            } else if (strO1.length() < strO2.length()) {
//                for (int i = 0; i < strO2.length() - strO1.length(); i++) {
//                    strO1 += strO1.substring(strO1.length() - 1);
//                }
//            }
//            return Integer.parseInt(strO2) - Integer.parseInt(strO1);
//        }).mapToInt(value -> value).toArray();
//        StringBuilder sb = new StringBuilder();
//        for (int r : result) {
//            sb.append(r);
//        }
//        //정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
//        return sb.toString();
//    }

    // 정답
    public String solution(int[] numbers) {
        validateNumbersLength(numbers);
        int[] result = Arrays.stream(numbers).boxed().sorted((o1, o2) -> {
            String strO1 = String.valueOf(o1);
            String strO2 = String.valueOf(o2);
            return Integer.parseInt(strO2 + strO1) - Integer.parseInt(strO1 + strO2);
        }).mapToInt(value -> value).toArray();
        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            sb.append(r);
        }
        if (Arrays.stream(result).filter(value -> value == 0).count() == result.length) {
            return "0";
        }
        //정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
        return sb.toString();
    }

    // numbers의 길이는 1 이상 100,000 이하입니다.
    void validateNumbersLength(int[] numbers) {
        if (numbers.length < 1 || 100000 < numbers.length) {
            throw new RuntimeException();
        }
    }


    //numbers의 원소는 0 이상 1,000 이하입니다.
    void validateNumber(int number) {
        if (number < 0 || 1000 < number) {
            throw new RuntimeException();
        }
    }
}