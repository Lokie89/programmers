package level1.cleardividednumberarray;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://programmers.co.kr/learn/courses/30/lessons/12910?language=java
public class Solution {
    public int[] solution(int[] arr, int divisor) {
        validateNumber(divisor);
        validateArrayLength(arr);
        validateDuplicate(arr);
        Arrays.sort(arr);

        List<Integer> integerList = new ArrayList<>();
        for (int num : arr) {
            validateNumber(num);
            if (num % divisor == 0) {
                integerList.add(num);
            }
        }
        int[] answer = integerList.stream().mapToInt(i -> i).toArray();
        if (answer.length == 0) {
            return new int[]{-1};
        }
        return answer;
    }

    // arr은 자연수를 담은 배열입니다.
    // divisor는 자연수입니다.
    private static void validateNumber(int number) {
        if (number < 1) {
            throw new RuntimeException();
        }
    }

    // array는 길이 1 이상인 배열입니다.
    private static void validateArrayLength(int[] arr) {
        if (arr.length < 1) {
            throw new RuntimeException();
        }
    }

    // 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
    private static void validateDuplicate(int[] arr) {
        Set<Integer> set = IntStream.of(arr).boxed().collect(Collectors.toSet());
        if (arr.length != set.size()) {
            throw new RuntimeException();
        }
    }
}

