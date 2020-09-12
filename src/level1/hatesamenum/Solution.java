package level1.hatesamenum;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/12906?language=java
public class Solution {
    public int[] solution(int[] arr) {
        validateArrayLength(arr);
        List<Integer> integerList = new ArrayList<>();

        int before = -1;

        for (int num : arr) {
            validateArrayNumber(num);
            if (before != num) {
                before = num;
                integerList.add(num);
            }
        }

        // Integer List 를 int Array 로 변환
        return integerList.stream()
                .mapToInt(i -> i)
                .toArray()
                ;
    }

    // 배열 arr의 크기 : 1,000,000 이하의 자연수
    private static void validateArrayLength(int[] array) {
        if (array.length < 1 || array.length > 1000000) {
            throw new RuntimeException();
        }
    }

    // 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
    private static void validateArrayNumber(int number) {
        if (number < 0 || number > 9) {
            throw new RuntimeException();
        }
    }
}
