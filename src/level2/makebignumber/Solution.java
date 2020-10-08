package level2.makebignumber;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42883?language=java
// TODO
public class Solution {
    public String solution(String number, int k) {
        validateNumber(number);
        validateK(number, k);

        char[] cNumber = number.toCharArray();
        char[] copy = Arrays.copyOf(cNumber, cNumber.length);
        Arrays.sort(copy);



        String answer = "";
        return answer;
    }

    // number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
    void validateNumber(String number) {
        if (number.length() < 1 || 1000000 < number.length()) {
            throw new RuntimeException();
        }
    }

    //k는 1 이상 number의 자릿수 미만인 자연수입니다.
    void validateK(String number, int k) {
        if (k < 1 || number.length() <= k) {
            throw new RuntimeException();
        }
    }
}