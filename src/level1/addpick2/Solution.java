package level1.addpick2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://programmers.co.kr/learn/courses/30/lessons/68644?language=java
// TODO
public class Solution {
    public int[] solution(int[] numbers) {
        validateNumbersLength(numbers);
        for (int number : numbers) {
            validateNumber(number);
        }

        Arrays.sort(numbers);
        Set<Integer> integers = new HashSet<>();
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                integers.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = integers.stream().mapToInt(value -> value).toArray();
        return answer;
    }

    // numbers의 길이는 2 이상 100 이하입니다.
    private void validateNumbersLength(int[] numbers) {
        if (numbers.length < 2 || numbers.length > 100) {
            throw new RuntimeException();
        }
    }

    // numbers의 모든 수는 0 이상 100 이하입니다.
    private void validateNumber(int number) {
        if (number < 0 || number > 100) {
            throw new RuntimeException();
        }
    }
}
