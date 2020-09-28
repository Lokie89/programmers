package level1.getaverage;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12944?language=java
public class Solution {
    public double solution(int[] arr) {
        validateArrLength(arr);
        double answer = (double)Arrays.stream(arr).sum() / arr.length;
        return answer;
    }

    // arr은 길이 1 이상, 100 이하인 배열입니다.
    private void validateArrLength(int[] arr) {
        if (arr.length < 1 || arr.length > 100) {
            throw new RuntimeException();
        }
    }

    // arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
    private void validateNumber(int number) {
        if (number < -10000 || number > 10000) {
            throw new RuntimeException();
        }
    }
}