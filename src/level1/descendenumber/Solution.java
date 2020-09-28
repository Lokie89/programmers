package level1.descendenumber;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12933?language=java
public class Solution {
    public long solution(long n) {
        validateNumber(n);
        Integer[] arr = new Integer[String.valueOf(n).length()];
        int index = 0;
        while (n > 0) {
            arr[index++] = ((int) n % 10);
            n /= 10;
        }
        Arrays.sort(arr);
        long answer = 0;
        int pow = 0;
        for (int a : arr) {
            answer += a * Math.pow(10, pow++);
        }

        return answer;
    }

    // n 은 1이상 8000000000 이하인 자연수입니다.
    private void validateNumber(long n) {
        if (n < 1 || n > 8000000000L) {
            throw new RuntimeException();
        }
    }
}
